/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.repository;

import java.math.BigDecimal;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ntgclarity.mandarine.entity.Attribute;
import com.ntgclarity.mandarine.entity.AttributeValueList;
import com.ntgclarity.mandarine.service.base.BaseRepository;

/**
 *
 * @author Sheko
 */
public interface AttributeValueListRepository extends BaseRepository<AttributeValueList> {
    
}
