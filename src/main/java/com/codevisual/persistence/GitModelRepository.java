package com.codevisual.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Home on 28/07/2014.
 */
@Service
public class GitModelRepository {

    @Autowired
    MongoTemplate mongoTemplate;


}
