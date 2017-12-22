package com.ntgclarity.mandarine.model;

import java.io.Serializable;

import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.ServiceCategory;

public class ServiceCategoryAddResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private ServiceCategory category;
	

	public ServiceCategory getServiceCategory() {
		return category;
	}

	public void setServiceCategory(ServiceCategory category) {
		this.category = category;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj =messageResponseObj;
	}
	
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

}
