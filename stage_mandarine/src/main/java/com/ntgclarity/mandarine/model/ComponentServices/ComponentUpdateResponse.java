package com.ntgclarity.mandarine.model.ComponentServices;

import java.io.Serializable;
import java.util.Collection;

import com.ntgclarity.mandarine.entity.Service;
import com.ntgclarity.mandarine.model.MessageResponse;

public class ComponentUpdateResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private Collection<Service> colServices;
	
	public Collection<Service> getColServices() {
		return colServices;
	}

	public void setColServices(Collection<Service> colServices) {
		this.colServices = colServices;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj =messageResponseObj;
	}
	
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

}
