package com.teslus.donation.services.impl;

import com.teslus.donation.commons.impl.GenericServiceImpl;
import com.teslus.donation.entities.Country;
import com.teslus.donation.repositories.CountryRepository;
import com.teslus.donation.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class CountryServiceImpl extends GenericServiceImpl<Country, Integer> implements CountryService {


    @Autowired
    CountryRepository countryRepository;
    @Override
    public CrudRepository<Country, Integer> getDao() {
        return countryRepository;
    }


}
