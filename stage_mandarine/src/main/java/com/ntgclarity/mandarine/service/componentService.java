
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.service;

import com.ntgclarity.mandarine.constants.CodesAndKeys;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.repository.ComponentRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mustafa
 */
@Service
public class componentService extends BaseService<Component>{

    @Autowired
    ComponentRepository componentRepository;

    public List<Component> getAllComponent() {
        List<Component> components = new ArrayList<>();
        componentRepository.findAll().forEach((t) -> {
        	Category cat=t.getCategoryId();

            if(cat!=null&&cat.getDeleted() ==0)
            {
            	if(cat!=null)
            	cat.setComponentCollection(null);
            	t.setServiceCollection(null);
            }
            
        	components.add(t);

        });
        return components;
    }

    public List<Component> getAllComponent(int page,int size) {
        List<Component> components = new ArrayList<>();
        componentRepository.findAll(new PageRequest(page, size)).forEach((t) -> {
            components.add(t);
        });
        return components;
    }

    
    public Component addComponent(Component component) {
        return componentRepository.save(component);
    }

    public void updateComponent(Component component) {
        componentRepository.save(component);
    }

    public void  deleteComponent(Component component) {
       
    	long id= component.getId();
    	component=componentRepository.findOne(id);
    	if(component==null)
    		throw new ApplicationException(new StatusResponse(CodesAndKeys.CAN_NOT_DELETE_COMPONENT_CODE,
					CodesAndKeys.CAN_NOT_DELETE_COMPONENT_KEY ));

    	Collection<com.ntgclarity.mandarine.entity.Service> col=component.getServiceCollection();
    	if((col==null||col.size()==0))
    	{
    	component.setDeleted(1);
        componentRepository.save(component);
    	//return null;
    	}
    	else
    	{
    		StringBuilder builder =new StringBuilder();
    	   		for (com.ntgclarity.mandarine.entity.Service service : col) {
				builder.append(service.getName());
				builder.append(",");
			}
    		throw new ApplicationException(new StatusResponse(CodesAndKeys.CAN_NOT_DELETE_COMPONENT_CODE,
					CodesAndKeys.CAN_NOT_DELETE_COMPONENT_KEY,builder.toString() ));
    	}
    }

    public Component getOneComponent(Long Id) {
        return componentRepository.findOne(Id);
    }
    public int totalCount()
    {
    	return (int) componentRepository.count();
    }

	@Override
	public BaseRepository<Component> getRepositoryInstance() {
		
		return componentRepository;
	}

	public int getRowsCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}

