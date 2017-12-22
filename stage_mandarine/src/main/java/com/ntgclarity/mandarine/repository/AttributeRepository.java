/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.repository;

import org.springframework.data.jpa.repository.Query;

import com.ntgclarity.mandarine.entity.Attribute;
import com.ntgclarity.mandarine.service.base.BaseRepository;

/**
 *
 * @author Mustafa
 */
public interface AttributeRepository extends BaseRepository<Attribute> 
 {
    @Query( "SELECT c FROM Attribute c where c.deleted=0")
    @Override
    public Iterable<Attribute> findAll();
}
