package com.ntgclarity.mandarine.model;

import java.util.List;

import com.ntgclarity.mandarine.entity.PriceBasis;

public class PriceBasisListRepsonse {

	private MessageResponse messageResponseObj;
	private List<PriceBasis> priceBasis;

	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}

	public List<PriceBasis> getPriceBasis() {
		return priceBasis;
	}

	public void setPriceBasis(List<PriceBasis> priceBasis) {
		this.priceBasis = priceBasis;
	}

}