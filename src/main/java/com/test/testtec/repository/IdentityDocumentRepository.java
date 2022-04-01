package com.test.testtec.repository;

import com.test.testtec.model.IdentityDocument;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityDocumentRepository extends MongoRepository<IdentityDocument,String> {
    
}
