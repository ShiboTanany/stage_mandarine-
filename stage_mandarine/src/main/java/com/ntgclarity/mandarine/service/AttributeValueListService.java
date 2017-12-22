
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.mandarine.entity.AttributeValueList;
import com.ntgclarity.mandarine.repository.AttributeValueListRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;

/**
 *
 * @author Mustafa
 */
@Service
public class AttributeValueListService extends BaseService<AttributeValueList> {

	@Autowired
	AttributeValueListRepository attributeValueListRepository;

	public void addAttributeValue(AttributeValueList attributeValue) {
		attributeValueListRepository.save(attributeValue);
	}

	public void updateAttributeValue(AttributeValueList attributeValue) {
		attributeValueListRepository.save(attributeValue);
	}

	public void deleteAttributeValue(AttributeValueList attributeValue) {
		attributeValue.setDeleted(1);
		attributeValueListRepository.save(attributeValue);
	}

	public List<AttributeValueList> getAllAttributeValues() {
		List<AttributeValueList> attributes = new ArrayList<>();
		attributeValueListRepository.findAll().forEach((t) -> {
			attributes.add(t);
		});
		return attributes;
	}

	public AttributeValueList getOneAttributeValue(Long id) {

		return attributeValueListRepository.findOne(id);
	}

	@Override
	public BaseRepository<AttributeValueList> getRepositoryInstance() {
		// TODO Auto-generated method stub
		return attributeValueListRepository;
	}

}
