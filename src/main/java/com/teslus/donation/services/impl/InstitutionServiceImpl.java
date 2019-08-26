package com.teslus.donation.services.impl;

import com.teslus.donation.commons.impl.GenericServiceImpl;
import com.teslus.donation.entities.Institution;
import com.teslus.donation.repositories.InstitutionRepository;
import com.teslus.donation.services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public  class InstitutionServiceImpl extends GenericServiceImpl<Institution, Integer> implements InstitutionService {


    @Autowired
    InstitutionRepository institutionRepository;
    @Override
    public CrudRepository<Institution, Integer> getDao() {
        return institutionRepository;
    }
}
