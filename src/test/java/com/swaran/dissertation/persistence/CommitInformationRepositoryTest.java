package com.swaran.dissertation.persistence;

import com.codevisual.persistence.CommitInformationRepository;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;

/**
 * Created by Home on 01/08/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CommitInformationRepositoryTest {

    @Rule
    public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("demo-test");

    @Autowired
    private ApplicationContext applicationContext;


    /*@Autowired
    private CommitInformationRepository commitInformationRepository;*/

}
