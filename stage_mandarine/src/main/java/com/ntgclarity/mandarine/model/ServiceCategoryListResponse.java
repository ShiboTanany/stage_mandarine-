package com.ntgclarity.mandarine.model;

import java.io.Serializable;
import java.util.List;

import com.ntgclarity.mandarine.dto.CategoryDTO;
import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.ServiceCategory;

public class ServiceCategoryListResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private List<ServiceCategory> categories;
	
	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj =messageResponseObj;
	}
	
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public List<ServiceCategory> getCategories() {
		return categories;
	}
	
	public void setCategories(List<ServiceCategory> categories) {
		this.categories = categories;
	}
}
