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
        entityManagerFactoryRef = "userEntityManagerFactory",
        transactionManagerRef = "userTransactionManager",
        basePackages = {"com.example.mysql.repository.user"}
)
public class UserDBConfig {
    @Bean("userDataSource")
    public DataSource userDatasource(
            @Value("${spring.datasource.user.driver-class-name}") String driverClassName,
            @Value("${spring.datasource.user.url}") String dataSourceUrl,
            @Value("${spring.datasource.user.username}") String username,
            @Value("${spring.datasource.user.password}") String password) {
        HikariDataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class)
                .driverClassName(driverClassName)
                .url(dataSourceUrl)
                .username(username)
                .password(password)
                .build();

        dataSource.setPoolName("user-pool");
        dataSource.setConnectionInitSql("SET NAMES utf8mb4");
        return dataSource;
    }

    private Map<String, Object> jpaProperties() {
        return new HashMap<>() {{
            put("hibernate.physical_naming_strategy", CamelCaseToUnderscoresNamingStrategy.class.getName());
            put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        }};
    }


    @Bean("userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("userDataSource") DataSource userDataSource) {
        return builder
                .dataSource(userDataSource)
                .packages("com.example.mysql.entity.user")
                .persistenceUnit("users")
                .properties(jpaProperties())
                .build();
    }

    @Bean("userTransactionManager")
    public JpaTransactionManager userTransactionManager(
            @Qualifier("userEntityManagerFactory") LocalContainerEntityManagerFactoryBean userEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(userEntityManagerFactory.getObject()));
    }
}
