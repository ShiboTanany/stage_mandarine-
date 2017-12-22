
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.mandarine.entity.Attribute;
import com.ntgclarity.mandarine.entity.EmployeeDiscountCategory;
import com.ntgclarity.mandarine.entity.EmployeeDiscountCategory;
import com.ntgclarity.mandarine.repository.AttributeRepository;
import com.ntgclarity.mandarine.repository.EmployeeDiscountCategoryRepoistory;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;

/**
 *
 * @author Mustafa
 */
@Service
public class EmployeeDiscountCategoryService extends BaseService<EmployeeDiscountCategory>{

    @Autowired
    EmployeeDiscountCategoryRepoistory employeeDiscountRepo;

    public void addEmployeeDiscountCategory(EmployeeDiscountCategory employeeDiscountRec) {
        
    	employeeDiscountRepo.save(employeeDiscountRec);
    }

    public void updateEmployeeDiscountCategory(EmployeeDiscountCategory employeeDiscountRec) {
    	employeeDiscountRepo.save(employeeDiscountRec);
    }

    public void deleteEmployeeDiscountCategory(EmployeeDiscountCategory employeeDiscountRec) {
    	employeeDiscountRec.setDeleted(1);
        employeeDiscountRepo.save(employeeDiscountRec);
    }

    public List<EmployeeDiscountCategory> getAllEmployeeDiscountCategory() {
        List<EmployeeDiscountCategory> employeeDiscounts = new ArrayList<>();
        employeeDiscountRepo.findAll().forEach((t) -> {
        	employeeDiscounts.add(t);
        });
        return employeeDiscounts;
    }

    public EmployeeDiscountCategory getOneEmployeeDiscountCategory(Long id) {
        
        return employeeDiscountRepo.findOne(id);
    }

	@Override
	public BaseRepository<EmployeeDiscountCategory> getRepositoryInstance() {
		// TODO Auto-generated method stub
		return employeeDiscountRepo;
	}

	


}
