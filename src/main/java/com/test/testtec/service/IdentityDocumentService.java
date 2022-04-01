package com.test.testtec.service;

import java.util.List;
import java.util.Optional;

import com.test.testtec.model.IdentityDocument;
import com.test.testtec.repository.IdentityDocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityDocumentService {
    
    @Autowired
    private IdentityDocumentRepository identityDocumentRepository;

    public List<IdentityDocument> findAll() {
        return identityDocumentRepository.findAll();
    }

    public IdentityDocument findById(String id) {

        IdentityDocument identityDocumenttemp = null;

        Optional<IdentityDocument> result = identityDocumentRepository.findById(id);

        if(result.isPresent()){
            identityDocumenttemp =  result.get();
        }
        
        return identityDocumenttemp;

         
    }


    public IdentityDocument createIdentityDocument(IdentityDocument identityDocument){

        return identityDocumentRepository.save(identityDocument);
    }

    public IdentityDocument updateIdentityDocument(IdentityDocument identityDocument){


        return identityDocumentRepository.save(identityDocument);
    }


    public void deleteIdentityDocument(String id){

//validar si existe
         identityDocumentRepository.deleteById(id);
    }


}
