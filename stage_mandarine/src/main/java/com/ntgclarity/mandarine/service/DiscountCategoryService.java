/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.service;

import com.ntgclarity.mandarine.entity.DiscountCategory;
import com.ntgclarity.mandarine.repository.DiscountCategoryRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sheko
 */
@Service
public class DiscountCategoryService extends BaseService<DiscountCategory> {

    @Autowired
    DiscountCategoryRepository discountCategoryRepository;
    @Override
    public BaseRepository<DiscountCategory> getRepositoryInstance() {
        return  discountCategoryRepository;
    }
    public List<DiscountCategory> getAll()
    {
		return (List<DiscountCategory>) discountCategoryRepository.findAll();
    }

}