/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.repository;

import com.ntgclarity.mandarine.entity.AttributeValue;
import com.ntgclarity.mandarine.service.base.BaseRepository;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Sheko
 */
public interface AttributeValueRepository extends BaseRepository<AttributeValue> {
//    @Query("Select attr from AttributeValue attr where attr.deleted =0")
//    @Override
//    public Iterable<AttributeValue> findAll();
    
}
