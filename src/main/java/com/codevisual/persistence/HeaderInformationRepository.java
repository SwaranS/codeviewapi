package com.codevisual.persistence;

import com.codevisual.model.CommitInformation;
import com.codevisual.model.HeaderInformation;
import com.codevisual.model.Person;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Home on 30/07/2014.
 */
@Service
public class HeaderInformationRepository implements Repository<HeaderInformation> {

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public List<HeaderInformation> getAllObjects() {
        return mongoTemplate.findAll(HeaderInformation.class);
    }

    @Override
    public void saveObject(HeaderInformation headerInformation) {
        mongoTemplate.insert(headerInformation);
    }

    @Override
    public HeaderInformation getObject(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),
                HeaderInformation.class);
    }

    @Override
    public WriteResult updateObject(String id, String name) {
        return mongoTemplate.updateFirst(
                new Query(Criteria.where("id").is(id)),
                Update.update("name", name), HeaderInformation.class);
    }

    @Override
    public void deleteObject(String id) {
        mongoTemplate
                .remove(new Query(Criteria.where("id").is(id)), HeaderInformation.class);

    }

    @Override
    public void createCollection() {
        if (!mongoTemplate.collectionExists(HeaderInformation.class)) {
            mongoTemplate.createCollection(HeaderInformation.class);
        }
    }

    @Override
    public void dropCollection() {
        if (mongoTemplate.collectionExists(HeaderInformation.class)) {
            mongoTemplate.dropCollection(HeaderInformation.class);
        }
    }
}