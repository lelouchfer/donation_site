package com.teslus.donation.services.impl;

import com.teslus.donation.commons.impl.GenericServiceImpl;
import com.teslus.donation.entities.Document;
import com.teslus.donation.repositories.DocumentRepository;
import com.teslus.donation.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public  class DocumentServiceImpl extends GenericServiceImpl<Document, Integer> implements DocumentService {


    @Autowired
    DocumentRepository documentRepository;
    @Override
    public CrudRepository<Document, Integer> getDao() {
        return documentRepository;
    }
}
