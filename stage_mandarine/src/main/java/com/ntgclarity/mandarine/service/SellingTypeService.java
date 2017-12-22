/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.service;

import com.ntgclarity.mandarine.entity.SellingType;
import com.ntgclarity.mandarine.repository.SellingTypeRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yasmeen
 */
@Service
public class SellingTypeService extends BaseService<SellingType> {

    @Autowired
    SellingTypeRepository sellingTypeRepository;

    @Override
    public BaseRepository<SellingType> getRepositoryInstance() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return sellingTypeRepository;
    }

    public void addSellingType(SellingType sellingType)
    {
        sellingTypeRepository.save(sellingType);
    }
    public void updateSellingType(SellingType sellingType) {
		sellingTypeRepository.save(sellingType);
	}
    public void deleteSellingType(SellingType sellingType) {
		sellingType.setDeleted(1);
		sellingTypeRepository.save(sellingType);
	}
    public List<SellingType> getAllSellingTypes()
    {
        return (List<SellingType>) sellingTypeRepository.findAll();
    }
    
    public SellingType getSellingTypeById(Long id) {

		return sellingTypeRepository.findOne(id);
	}
}
