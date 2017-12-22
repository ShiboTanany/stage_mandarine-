
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.service;

import com.ntgclarity.mandarine.entity.AttributeValue;
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.entity.Orders;
import com.ntgclarity.mandarine.repository.AttributeValueRepository;
import com.ntgclarity.mandarine.repository.ComponentRepository;
import com.ntgclarity.mandarine.repository.OrderRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sheko
 */
@Service
public class AttributeValueService extends BaseService<AttributeValue> {

	@Autowired
	AttributeValueRepository attributeValueRepository;

	public List<AttributeValue> getAllComponent() {
		List<AttributeValue> attributeValues = new ArrayList<>();
		attributeValueRepository.findAll().forEach((t) -> {
			attributeValues.add(t);
		});
		return attributeValues;
	}

	public void addComponent(AttributeValue attributeValue) {
		attributeValueRepository.save(attributeValue);
	}

	public void updateComponent(AttributeValue attributeValue) {
		attributeValueRepository.save(attributeValue);
	}

	public void deleteComponent(AttributeValue attributeValue) {
		attributeValue.setDeleted(1);
		attributeValueRepository.save(attributeValue);
	}

//	public AttributeValue getOneComponent(Long Id) {
//		return attributeValueRepository.findOne(new BigDecimal(Id));
//	}

	@Override
	public BaseRepository<AttributeValue> getRepositoryInstance() {
		// TODO Auto-generated method stub
		return attributeValueRepository;
	}
}
