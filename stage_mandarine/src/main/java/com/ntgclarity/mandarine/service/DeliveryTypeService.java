
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

import com.ntgclarity.mandarine.entity.PcDeliveryType;
import com.ntgclarity.mandarine.repository.DeliveryTypeRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;

/**
 *
 * @author Mustafa
 */
@Service
public class DeliveryTypeService extends BaseService<PcDeliveryType>{

    @Autowired
    DeliveryTypeRepository deliveryRepo;

    public void addPcDeliveryType(PcDeliveryType deliveryType) {
        
    	deliveryRepo.save(deliveryType);
    }

    public void updatePcDeliveryType(PcDeliveryType deliveryType) {
    	deliveryRepo.save(deliveryType);
    }

    public void deletePcDeliveryType(PcDeliveryType deliveryType) {
    	
    	deliveryType.setDeleted(1);
        deliveryRepo.save(deliveryType);
    }

    public List<PcDeliveryType> getAllPcDeliveryType() {
        List<PcDeliveryType> employeeDiscounts = new ArrayList<>();
        deliveryRepo.findAll().forEach((t) -> {
        	employeeDiscounts.add(t);
        });
        return employeeDiscounts;
    }

    public PcDeliveryType getOnePcDeliveryType(Long id) {
        
        return deliveryRepo.findOne(id);
    }

	@Override
	public BaseRepository<PcDeliveryType> getRepositoryInstance() {
		// TODO Auto-generated method stub
		return deliveryRepo;
	}

	


}
