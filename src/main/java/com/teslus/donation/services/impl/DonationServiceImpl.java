package com.teslus.donation.services.impl;

import com.teslus.donation.commons.impl.GenericServiceImpl;
import com.teslus.donation.entities.Donation;
import com.teslus.donation.repositories.DonationRepository;
import com.teslus.donation.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class DonationServiceImpl extends GenericServiceImpl<Donation, Integer> implements DonationService {


    @Autowired
    DonationRepository donationRepository;
    @Override
    public CrudRepository<Donation, Integer> getDao() {
        return donationRepository;
    }

    @Override
    public List<Donation> findAllbyIdDonator(Integer id) {
        return ((DonationRepository)donationRepository).findAllByIdDonator(id);
    }
}
