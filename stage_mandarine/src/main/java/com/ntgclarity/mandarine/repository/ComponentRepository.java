/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.repository;

import org.springframework.data.jpa.repository.Query;

import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.service.base.BaseRepository;

/**
 *
 * @author Sheko
 */
public interface ComponentRepository extends BaseRepository<Component>{

    
    @Override
    public Iterable<Component> findAll();
    
     
    
}
