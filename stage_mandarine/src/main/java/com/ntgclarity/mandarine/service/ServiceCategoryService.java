
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
import com.ntgclarity.mandarine.entity.ServiceCategory;
import com.ntgclarity.mandarine.repository.AttributeRepository;
import com.ntgclarity.mandarine.repository.ServiceCategoryRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;

/**
 *
 * @author Mustafa
 */
@Service
public class ServiceCategoryService extends BaseService<ServiceCategory>{

    @Autowired
    ServiceCategoryRepository serviceCategoryRepo;

    public void addServiceCategory(ServiceCategory serviceCat) {
        
    	serviceCategoryRepo.save(serviceCat);
    }

    public void updateServiceCategory(ServiceCategory serviceCat) {
    	serviceCategoryRepo.save(serviceCat);
    }

    public void deleteServiceCategory(ServiceCategory serviceCat) {
    	serviceCat.setDeleted(1);
        serviceCategoryRepo.save(serviceCat);
    }

    public List<ServiceCategory> getAllServiceCategory() {
        List<ServiceCategory> serviceCatgoreis = new ArrayList<>();
        serviceCategoryRepo.findAll().forEach((t) -> {
        	serviceCatgoreis.add(t);
        });
        return serviceCatgoreis;
    }

    public ServiceCategory getOneServiceCategory(Long id) {
        
        return serviceCategoryRepo.findOne(id);
    }

	@Override
	public BaseRepository<ServiceCategory> getRepositoryInstance() {
		// TODO Auto-generated method stub
		return serviceCategoryRepo;
	}

	


}
