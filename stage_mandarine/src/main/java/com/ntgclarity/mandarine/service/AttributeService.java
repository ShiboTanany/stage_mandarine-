
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
import com.ntgclarity.mandarine.repository.AttributeRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;

/**
 *
 * @author Mustafa
 */
@Service
public class AttributeService extends BaseService<Attribute>{

    @Autowired
    AttributeRepository attributeRepo;

    public void addAttribute(Attribute attribute) {
        
    	attributeRepo.save(attribute);
    }

    public void updateAttribute(Attribute attribute) {
    	attributeRepo.save(attribute);
    }

    public void deleteAttribute(Attribute attribute) {
    	attribute.setDeleted(1);
        attributeRepo.save(attribute);
    }

    public List<Attribute> getAllAttributes() {
        List<Attribute> attributes = new ArrayList<>();
        attributeRepo.findAll().forEach((t) -> {
        	attributes.add(t);
        });
        return attributes;
    }

    public Attribute getOneAttribute(Long id) {
        
        return attributeRepo.findOne(id);
    }

	@Override
	public BaseRepository<Attribute> getRepositoryInstance() {
		return attributeRepo;
	}

}
