package com.example.mysql.config;


import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "productEntityManagerFactory",
        transactionManagerRef = "productTransactionManager",
        basePackages = {"com.example.mysql.repository.product"}
)
public class ProductDBConfig {
    @Bean("productDataSource")
    public DataSource productDatasource(
            @Value("${spring.datasource.product.driver-class-name}") String driverClassName,
            @Value("${spring.datasource.product.url}") String dataSourceUrl,
            @Value("${spring.datasource.product.username}") String username,
            @Value("${spring.datasource.product.password}") String password) {
        HikariDataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class)
                .driverClassName(driverClassName)
                .url(dataSourceUrl)
                .username(username)
                .password(password)
                .build();

        dataSource.setConnectionInitSql("SET NAMES utf8mb4");
        return dataSource;
    }

    private Map<String, Object> jpaProperties() {
        return new HashMap<>() {{
            put("hibernate.physical_naming_strategy", CamelCaseToUnderscoresNamingStrategy.class.getName());
            put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        }};
    }


    @Bean("productEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean productEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("productDataSource") DataSource productDataSource) {
        return builder
                .dataSource(productDataSource)
                .packages("com.example.mysql.entity.product")
                .persistenceUnit("products")
                .properties(jpaProperties())
                .build();
    }

    @Bean("productTransactionManager")
    public JpaTransactionManager productTransactionManager(
            @Qualifier("productEntityManagerFactory") LocalContainerEntityManagerFactoryBean productEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(productEntityManagerFactory.getObject()));
    }
}
