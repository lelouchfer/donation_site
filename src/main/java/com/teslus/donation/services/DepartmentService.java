package com.teslus.donation.services;

import com.teslus.donation.commons.GenericService;
import com.teslus.donation.entities.Department;

import java.util.List;

public interface DepartmentService extends GenericService<Department,Integer> {
    List<Department> findDepartmentsByIdCountry(Integer id);


    }
