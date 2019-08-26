package com.teslus.donation.services.impl;

import com.teslus.donation.commons.impl.GenericServiceImpl;
import com.teslus.donation.entities.Donator;
import com.teslus.donation.repositories.DonatorRepository;
import com.teslus.donation.services.DontaorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public  class DonatorServiceImpl extends GenericServiceImpl<Donator, Integer> implements DontaorService {


    @Autowired
    DonatorRepository donatorRepository;
    @Override
    public CrudRepository<Donator, Integer> getDao() {
        return donatorRepository;
    }


    @Override
    public Donator findDonatorByUserId(int id) {
        return ((DonatorRepository) donatorRepository).findByIdUser(id);
    }
}
