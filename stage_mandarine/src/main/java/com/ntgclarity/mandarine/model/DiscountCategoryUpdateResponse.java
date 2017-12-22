package com.ntgclarity.mandarine.model;

import com.ntgclarity.mandarine.entity.Bandwidth;
import com.ntgclarity.mandarine.entity.DiscountCategory;

public class DiscountCategoryUpdateResponse {
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;

	private DiscountCategory discountCategory;

	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}

	public DiscountCategory getDiscountCategory() {
		return discountCategory;
	}

	public void setDiscountCategory(DiscountCategory discountCategory) {
		this.discountCategory = discountCategory;
	}

}