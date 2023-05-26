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
        entityManagerFactoryRef = "photoEntityManagerFactory",
        transactionManagerRef = "photoTransactionManager",
        basePackages = {"com.example.mysql.repository.photo"}
)
public class PhotoDBConfig {
    @Bean("photoDataSource")
    public DataSource photoDatasource(
            @Value("${spring.datasource.photo.driver-class-name}") String driverClassName,
            @Value("${spring.datasource.photo.url}") String dataSourceUrl,
            @Value("${spring.datasource.photo.username}") String username,
            @Value("${spring.datasource.photo.password}") String password) {
        HikariDataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class)
                .driverClassName(driverClassName)
                .url(dataSourceUrl)
                .username(username)
                .password(password)
                .build();

        dataSource.setPoolName("photo-pool");
        dataSource.setConnectionInitSql("SET NAMES utf8mb4");
        return dataSource;
    }

    private Map<String, Object> jpaProperties() {
        return new HashMap<>() {{
            put("hibernate.physical_naming_strategy", CamelCaseToUnderscoresNamingStrategy.class.getName());
            put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        }};
    }


    @Bean("photoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean photoEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("photoDataSource") DataSource photoDataSource) {
        return builder
                .dataSource(photoDataSource)
                .packages("com.example.mysql.entity.photo")
                .persistenceUnit("photos")
                .properties(jpaProperties())
                .build();
    }

    @Bean("photoTransactionManager")
    public JpaTransactionManager photoTransactionManager(
            @Qualifier("photoEntityManagerFactory") LocalContainerEntityManagerFactoryBean photoEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(photoEntityManagerFactory.getObject()));
    }
}
