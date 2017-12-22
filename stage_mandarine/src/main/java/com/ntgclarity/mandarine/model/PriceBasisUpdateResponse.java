package com.ntgclarity.mandarine.model;

import com.ntgclarity.mandarine.entity.PriceBasis;

public class PriceBasisUpdateResponse {
	
	private MessageResponse messageResponseObj;
	private PriceBasis priceBasis;

	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}

	public PriceBasis getPriceBasis() {
		return priceBasis;
	}

	public void setPriceBasis(PriceBasis priceBasis) {
		this.priceBasis = priceBasis;
	}
}