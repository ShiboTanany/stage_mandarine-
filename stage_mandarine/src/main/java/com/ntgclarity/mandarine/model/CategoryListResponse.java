package com.ntgclarity.mandarine.model;

import java.io.Serializable;
import java.util.List;

import com.ntgclarity.mandarine.dto.CategoryDTO;
import com.ntgclarity.mandarine.entity.Category;

public class CategoryListResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private List<CategoryDTO> categories;
	
	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj =messageResponseObj;
	}
	
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}
	
	public void setCategoriesDTO(List<CategoryDTO> categories) {
		this.categories = categories;
	}
}
