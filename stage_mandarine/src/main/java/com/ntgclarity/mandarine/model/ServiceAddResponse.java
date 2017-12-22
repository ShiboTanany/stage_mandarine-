package com.ntgclarity.mandarine.model;

import java.io.Serializable;

import com.ntgclarity.mandarine.dto.ServiceDto;
import com.ntgclarity.mandarine.entity.Service;

public class ServiceAddResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private ServiceDto service;
	

	
	public ServiceDto getService() {
		return service;
	}

	public void setServiceDTO(ServiceDto service) {
		this.service = service;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj =messageResponseObj;
	}
	
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}
}