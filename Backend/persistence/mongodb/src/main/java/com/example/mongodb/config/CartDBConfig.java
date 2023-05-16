package com.example.mongodb.config;

import com.mongodb.MongoCredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(basePackages = {"com.example.mongodb.repository"})
public class CartDBConfig {

    @Bean
    public MongoClientFactoryBean mongo(
            @Value("${mongo.cart.host}") String host,
            @Value("${mongo.cart.port}") int port,
            @Value("${mongo.cart.username}") String username,
            @Value("${mongo.cart.password}") String password,
            @Value("${mongo.cart.database}") String database
    ) {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost(host);
        mongo.setPort(port);
        mongo.setCredential(new MongoCredential[]{MongoCredential.createCredential(username, database, password.toCharArray())});
        return mongo;
    }

}
