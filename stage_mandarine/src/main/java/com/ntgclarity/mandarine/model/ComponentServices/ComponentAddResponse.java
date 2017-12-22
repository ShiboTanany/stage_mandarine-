package com.ntgclarity.mandarine.model.ComponentServices;

import java.io.Serializable;

import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.model.MessageResponse;

public class ComponentAddResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private Long componentID;
	
	public void setComponentID(Long component) {
		this.componentID =component;
	}
	public Long getComponentID( ) {
		return this.componentID;
	}
	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj =messageResponseObj;
	}
	
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

}
