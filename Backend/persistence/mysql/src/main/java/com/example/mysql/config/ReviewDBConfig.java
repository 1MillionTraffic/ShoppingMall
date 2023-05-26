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
        entityManagerFactoryRef = "reviewEntityManagerFactory",
        transactionManagerRef = "reviewTransactionManager",
        basePackages = {"com.example.mysql.repository.review"}
)
public class ReviewDBConfig {
    @Bean("reviewDataSource")
    public DataSource reviewDatasource(
            @Value("${spring.datasource.review.driver-class-name}") String driverClassName,
            @Value("${spring.datasource.review.url}") String dataSourceUrl,
            @Value("${spring.datasource.review.username}") String username,
            @Value("${spring.datasource.review.password}") String password) {
        HikariDataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class)
                .driverClassName(driverClassName)
                .url(dataSourceUrl)
                .username(username)
                .password(password)
                .build();

        dataSource.setPoolName("review-pool");
        dataSource.setConnectionInitSql("SET NAMES utf8mb4");
        return dataSource;
    }

    private Map<String, Object> jpaProperties() {
        return new HashMap<>() {{
            put("hibernate.physical_naming_strategy", CamelCaseToUnderscoresNamingStrategy.class.getName());
            put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        }};
    }


    @Bean("reviewEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean reviewEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("reviewDataSource") DataSource reviewDataSource) {
        return builder
                .dataSource(reviewDataSource)
                .packages("com.example.mysql.entity.review")
                .persistenceUnit("reviews")
                .properties(jpaProperties())
                .build();
    }

    @Bean("reviewTransactionManager")
    public JpaTransactionManager reviewTransactionManager(
            @Qualifier("reviewEntityManagerFactory") LocalContainerEntityManagerFactoryBean reviewEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(reviewEntityManagerFactory.getObject()));
    }
}
