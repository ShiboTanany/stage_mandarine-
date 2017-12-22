package com.ntgclarity.mandarine.model;

import java.io.Serializable;
import java.util.List;

import com.ntgclarity.mandarine.entity.DiscountCategory;

public class DiscountCategoryListResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private List<DiscountCategory> discountCategories;

	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}

	public List<DiscountCategory> getDiscountCategories() {
		return discountCategories;
	}

	public void setDiscountCategories(List<DiscountCategory> discountCategories) {
		this.discountCategories = discountCategories;
	}

}