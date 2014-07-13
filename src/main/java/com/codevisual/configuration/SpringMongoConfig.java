package com.codevisual.configuration;

/**
 * Created by Home on 11/07/2014.
 */
import com.codevisual.persistence.NatureRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig {

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(), "dissertation");
    }

 /*   public @Bean
    MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }*/

   /* public @Bean
    NatureRepositoryImpl natureRepository() throws Exception {

       // MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        NatureRepositoryImpl natureRepository = new NatureRepositoryImpl();
        return natureRepository;

    }*/
}