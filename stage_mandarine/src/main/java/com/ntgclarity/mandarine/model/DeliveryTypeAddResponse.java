package com.ntgclarity.mandarine.model;

import java.io.Serializable;

import com.ntgclarity.mandarine.entity.PcDeliveryType;
import com.ntgclarity.mandarine.entity.PcDeliveryType;

public class DeliveryTypeAddResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private PcDeliveryType PcDeliveryType;
	

	public PcDeliveryType getPcDeliveryType() {
		return PcDeliveryType;
	}

	public void setPcDeliveryType(PcDeliveryType PcDeliveryType) {
		this.PcDeliveryType = PcDeliveryType;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj =messageResponseObj;
	}
	
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

}
