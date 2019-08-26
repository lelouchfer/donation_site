package com.teslus.donation.services;

import com.teslus.donation.commons.GenericService;
import com.teslus.donation.entities.Donator;

public interface DontaorService extends GenericService<Donator,Integer> {
    Donator findDonatorByUserId(int id);
}
