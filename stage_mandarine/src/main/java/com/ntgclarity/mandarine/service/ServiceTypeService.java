/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.mandarine.entity.Servicetype;
import com.ntgclarity.mandarine.repository.ServiceTypeRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;
@Service
public class ServiceTypeService extends BaseService<Servicetype> {
	@Autowired
	ServiceTypeRepository repository;

	public List<Servicetype> getAll() {
		return (List<Servicetype>) repository.findAll();
	}

	@Override
	public BaseRepository<Servicetype> getRepositoryInstance() {
		// TODO Auto-generated method stub
		return repository;
	}

}