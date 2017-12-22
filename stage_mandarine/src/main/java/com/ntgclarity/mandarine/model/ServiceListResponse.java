package com.ntgclarity.mandarine.model;

import java.io.Serializable;
import java.util.List;

import com.ntgclarity.mandarine.dto.ServiceDto;
import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.Service;

public class ServiceListResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private List<ServiceDto> serviceDtos;
	
	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj =messageResponseObj;
	}
	
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public List<ServiceDto> getServiceDtos() {
		return serviceDtos;
	}

	public void setServiceDtos(List<ServiceDto> serviceDtos) {
		this.serviceDtos = serviceDtos;
	}



}
