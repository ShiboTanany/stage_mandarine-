package com.ntgclarity.mandarine.model;

import java.io.Serializable;
import java.util.List;

import com.ntgclarity.mandarine.dto.CategoryDTO;
import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.PcDeliveryType;

public class DeliveryTypeListResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private List<PcDeliveryType> deliveryTypes;
	
	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj =messageResponseObj;
	}
	
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public List<PcDeliveryType> getdeliveryTypes() {
		return deliveryTypes;
	}
	
	public void setdeliveryTypes(List<PcDeliveryType> deliveryTypes) {
		this.deliveryTypes = deliveryTypes;
	}
}
