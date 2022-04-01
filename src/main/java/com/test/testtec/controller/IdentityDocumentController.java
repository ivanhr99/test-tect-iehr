package com.test.testtec.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.test.testtec.model.IdentityDocument;
import com.test.testtec.service.IdentityDocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;






@RestController
@RequestMapping("/identitydocuments")
public class IdentityDocumentController {
    
    @Autowired
    private IdentityDocumentService identityDocumentService;

    @GetMapping
   // public List<IdentityDocument> findAll(){
   //      return identityDocumentService.findAll();
   // }
       

    

    public ResponseEntity<List<IdentityDocument>> getAll(){
        HttpStatus status =  null ;
        List<IdentityDocument> identityDocumentList = new ArrayList<>();
        try {
            identityDocumentList = identityDocumentService.findAll();
            if(identityDocumentList.size()>0){
                status =  HttpStatus.OK;
            }else{
                status = HttpStatus.NOT_FOUND;
            }
            
        } catch (Exception e) {
            
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<List<IdentityDocument>>(identityDocumentList, status);
        
    }


    @PostMapping
    public ResponseEntity<IdentityDocument> create(@Valid @RequestBody IdentityDocument identityDocument){
        HttpStatus status =  null ;
        IdentityDocument identityDocumentTemp = new IdentityDocument();
        try {
            identityDocumentTemp = identityDocumentService.createIdentityDocument(identityDocument);
            status = HttpStatus.CREATED;
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(status).body(identityDocumentTemp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IdentityDocument> update(@Valid  @RequestBody IdentityDocument identityDocument, @PathVariable("id") String id){
        HttpStatus status =  null ;
        IdentityDocument identityDocumentTemp = new IdentityDocument();
        try {
            identityDocumentTemp =  identityDocumentService.findById(id);
            if(identityDocumentTemp !=null){
                identityDocument.setId(id);
                identityDocumentTemp = identityDocumentService.updateIdentityDocument(identityDocument);
                status= HttpStatus.CREATED;
            }else{
                status = HttpStatus.NOT_FOUND;
                identityDocumentTemp = identityDocument;
            }

        } catch (Exception e) {
            
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
        return ResponseEntity.status(status).body(identityDocumentTemp);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<IdentityDocument> delete( @PathVariable("id") String id){
        HttpStatus status =  null ;
        IdentityDocument identityDocumentTemp = new IdentityDocument();
        try {
            identityDocumentTemp =  identityDocumentService.findById(id);
            if(identityDocumentTemp !=null){
                identityDocumentService.deleteIdentityDocument(id);
                status= HttpStatus.ACCEPTED;
            }else{
                status = HttpStatus.NOT_FOUND;
                
            }

        } catch (Exception e) {
            
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(status).body(identityDocumentTemp);
    }

    
}
