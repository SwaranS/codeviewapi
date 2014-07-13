package com.codevisual.persistence;

/**
 * Created by Home on 12/07/2014.
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;
import com.codevisual.model.Person;
import org.springframework.stereotype.Service;

@Service
public class NatureRepositoryImpl implements Repository<Person> {
    @Autowired
    MongoTemplate mongoTemplate;



    /**
     * Get all Persons.
     */
    public List<Person> getAllObjects() {
        return mongoTemplate.findAll(Person.class);
    }

    /**
     * Saves a {@link Person}.
     */
    public void saveObject(Person Person) {
        mongoTemplate.insert(Person);
    }

    /**
     * Gets a {@link Person} for a particular id.
     */
    public Person getObject(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),
                Person.class);
    }

    /**
     * Updates a {@link Person} name for a particular id.
     */
    public WriteResult updateObject(String id, String name) {
        return mongoTemplate.updateFirst(
                new Query(Criteria.where("id").is(id)),
                Update.update("name", name), Person.class);
    }

    /**
     * Delete a {@link Person} for a particular id.
     */
    public void deleteObject(String id) {
        mongoTemplate
                .remove(new Query(Criteria.where("id").is(id)), Person.class);
    }

    /**
     * Create a {@link Person} collection if the collection does not already
     * exists
     */
    public void createCollection() {
        if (!mongoTemplate.collectionExists(Person.class)) {
            mongoTemplate.createCollection(Person.class);
        }
    }

    /**
     * Drops the {@link Person} collection if the collection does already exists
     */
    public void dropCollection() {
        if (mongoTemplate.collectionExists(Person.class)) {
            mongoTemplate.dropCollection(Person.class);
        }
    }
}