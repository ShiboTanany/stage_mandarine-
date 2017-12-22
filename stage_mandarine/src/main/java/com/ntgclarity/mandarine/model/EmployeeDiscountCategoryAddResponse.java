package com.ntgclarity.mandarine.model;

import java.io.Serializable;

import com.ntgclarity.mandarine.entity.EmployeeDiscountCategory;

public class EmployeeDiscountCategoryAddResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private EmployeeDiscountCategory employeeDiscountCategory;
	

	public EmployeeDiscountCategory getEmployeeDiscountCategory() {
		return employeeDiscountCategory;
	}

	public void setEmployeeDiscountCategory(EmployeeDiscountCategory employeeDiscountCategory) {
		this.employeeDiscountCategory = employeeDiscountCategory;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj =messageResponseObj;
	}
	
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

}
