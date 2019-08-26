package com.teslus.donation.services.impl;

import com.teslus.donation.commons.impl.GenericServiceImpl;
import com.teslus.donation.entities.Department;
import com.teslus.donation.repositories.DepartmentRepository;
import com.teslus.donation.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class DepartmentServiceImpl extends GenericServiceImpl<Department, Integer> implements DepartmentService {


    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public CrudRepository<Department, Integer> getDao() {
        return departmentRepository;
    }

    @Override
    public List<Department> findDepartmentsByIdCountry(Integer id) {
        return ((DepartmentRepository)getDao()).findAllByIdCountry(id);
    }
}
