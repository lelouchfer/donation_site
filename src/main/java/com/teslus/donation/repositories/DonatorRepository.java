package com.teslus.donation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.teslus.donation.entities.Donator;

public interface DonatorRepository extends JpaRepository<Donator, Integer>, JpaSpecificationExecutor<Donator> {
    Donator findByIdUser(int idUser);
}