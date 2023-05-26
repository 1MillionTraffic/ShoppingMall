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
        entityManagerFactoryRef = "billingEntityManagerFactory",
        transactionManagerRef = "billingTransactionManager",
        basePackages = {"com.example.mysql.repository.billing"}
)
public class BillingDBConfig {
    @Bean("billingDataSource")
    public DataSource billingDatasource(
            @Value("${spring.datasource.billing.driver-class-name}") String driverClassName,
            @Value("${spring.datasource.billing.url}") String dataSourceUrl,
            @Value("${spring.datasource.billing.username}") String username,
            @Value("${spring.datasource.billing.password}") String password) {
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

    @Bean("billingEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean billingEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("billingDataSource") DataSource billingDataSource) {
        return builder
                .dataSource(billingDataSource)
                .packages("com.example.entity.billing")
                .persistenceUnit("billing")
                .properties(jpaProperties())
                .build();
    }

    @Bean("billingTransactionManager")
    public JpaTransactionManager billingTransactionManager(
            @Qualifier("billingEntityManagerFactory") LocalContainerEntityManagerFactoryBean billingEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(billingEntityManagerFactory.getObject()));
    }
}
