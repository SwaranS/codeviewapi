package com.codevisual.persistence;

import com.codevisual.model.CommitInformation;
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
public class CommitInformationRepository implements Repository<CommitInformation> {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<CommitInformation> getCommitInformationByUrl(String url){
        return mongoTemplate.find(new Query(Criteria.where("url").is(url)),CommitInformation.class);
    }

    @Override
    public List<CommitInformation> getAllObjects() {
        return mongoTemplate.findAll(CommitInformation.class);
    }

    @Override
    public void saveObject(CommitInformation CommitInformation) {
        mongoTemplate.insert(CommitInformation);
    }

    @Override
    public CommitInformation getObject(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),
                CommitInformation.class);
    }

    @Override
    public WriteResult updateObject(String id, String name) {
        return mongoTemplate.updateFirst(
                new Query(Criteria.where("id").is(id)),
                Update.update("name", name), CommitInformation.class);
    }

    @Override
    public void deleteObject(String id) {
        mongoTemplate
                .remove(new Query(Criteria.where("id").is(id)), CommitInformation.class);

    }

    @Override
    public void createCollection() {
        if (!mongoTemplate.collectionExists(CommitInformation.class)) {
            mongoTemplate.createCollection(CommitInformation.class);
        }
    }

    @Override
    public void dropCollection() {
        if (mongoTemplate.collectionExists(CommitInformation.class)) {
            mongoTemplate.dropCollection(CommitInformation.class);
        }
    }
}