/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.service;

import com.ntgclarity.mandarine.entity.PriceBasis;
import com.ntgclarity.mandarine.repository.PriceBasisRepository;
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
public class PriceBasisService extends BaseService<PriceBasis>{
    @Autowired
    PriceBasisRepository priceBasisRepository;

    @Override
    public BaseRepository<PriceBasis> getRepositoryInstance() {
    return  priceBasisRepository;
    }
    public List<PriceBasis>getAll()
    {
    	return (List<PriceBasis>) priceBasisRepository.findAll();
    }
}
 