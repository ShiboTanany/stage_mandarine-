package com.ntgclarity.mandarine.model;

import java.io.Serializable;
import java.util.List;

import com.ntgclarity.mandarine.dto.CategoryDTO;
import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.EmployeeDiscountCategory;

public class EmployeeDiscountListResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private List<EmployeeDiscountCategory> discounts;
	
	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj =messageResponseObj;
	}
	
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public List<EmployeeDiscountCategory> getDiscounts() {
		return discounts;
	}
	
	public void setDiscounts(List<EmployeeDiscountCategory> discounts) {
		this.discounts = discounts;
	}
}
