package com.teslus.donation.services;

import com.teslus.donation.commons.GenericService;
import com.teslus.donation.entities.Donation;

import java.util.List;

public interface DonationService extends GenericService<Donation,Integer> {
    List<Donation> findAllbyIdDonator(Integer id);

}
