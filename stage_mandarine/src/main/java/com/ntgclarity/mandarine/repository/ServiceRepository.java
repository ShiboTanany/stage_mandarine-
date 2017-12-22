/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.repository;

import org.springframework.data.jpa.repository.Query;

import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.entity.Service;
import com.ntgclarity.mandarine.service.base.BaseRepository;

/**
 *
 * @author Sheko
 */
public interface ServiceRepository extends BaseRepository<Service> {
    @Override
    public Iterable<Service> findAll();
}
