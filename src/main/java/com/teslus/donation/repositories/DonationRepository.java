package com.teslus.donation.repositories;

import com.teslus.donation.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Integer>, JpaSpecificationExecutor<Donation> {
    List<Donation> findAllByIdDonator(int id);
}