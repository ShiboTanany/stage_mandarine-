package com.ntgclarity.mandarine.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ntgclarity.mandarine.entity.AttributeValueList;
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.entity.Service;
import com.ntgclarity.mandarine.repository.ComponentRepository;
import com.ntgclarity.mandarine.repository.ServiceRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;

@org.springframework.stereotype.Service
public class ServiceService extends BaseService<Service> {

    @Autowired
    ServiceRepository serviceRepo;
    @Autowired
    AttributeValueListService attributeValueListService;
    @Autowired
    componentService componentService;
    @Autowired
    ComponentRepository componentRepo;
    @Autowired
    AttributeService attributeService;

    public void addService(Service service) {

        serviceRepo.save(service);

        if (service.getComponentCollection() != null) {
            service.getComponentCollection().forEach((component) -> {
                Collection<Service> tempcol = component.getServiceCollection();
                if (tempcol == null) {
                    tempcol = new ArrayList<Service>();
                }
                tempcol.add(service);
                component.setServiceCollection(tempcol);
                componentService.save(component);

            });
        }

        if (service.getAttributeCollection() != null) {
            System.out.println("have list value");

            service.getAttributeCollection().forEach((attr) -> {
                attr.setServiceId(service);
                if (attr.getAttributeValueListCollection() != null) {
                    attr.getAttributeValueListCollection().forEach((attrValue) -> {
                        attrValue.setAttributeId(attr);
                        attrValue.setServiceid(service);
                        attributeValueListService.save(attrValue);

                    });
                }
            });
        }

    }

    public void deleteService(Service service) {
        service.setDeleted(1);
        serviceRepo.save(service);
    }

    public void updateService(Service service) {
        System.out.println("In Update");
        if (service.getAttributeCollection() != null) {
            System.out.println("have list value");

            service.getAttributeCollection().forEach((attr) -> {
                attr.setServiceId(service);
                attributeService.save(attr);
                if (attr.getAttributeValueListCollection() != null) {
                    attr.getAttributeValueListCollection().forEach((attrValue) -> {
                        attrValue.setAttributeId(attr);
                        attrValue.setServiceid(service);
                        attributeValueListService.save(attrValue);

                    });
                }
            });
        }

        if (service.getComponentCollection() != null) {
            service.getComponentCollection().forEach((component) -> {
                Collection<Service> tempcol = component.getServiceCollection();
                if (tempcol == null) {
                    tempcol = new ArrayList<Service>();
                }
                tempcol.add(service);
                component.setServiceCollection(tempcol);
                componentService.save(component);

            });
        }

        serviceRepo.save(service);

    }

    public List<Service> getAllService() {
        return (List<Service>) serviceRepo.findAll();

    }

    public Service getServiceById(Long id) {

        return serviceRepo.findOne(id);
    }

    public int totalCount() {
        return (int) serviceRepo.count();
    }

    @Override
    public BaseRepository<Service> getRepositoryInstance() {
        // TODO Auto-generated method stub
        return serviceRepo;
    }
}
