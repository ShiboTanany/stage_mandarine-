package com.ntgclarity.mandarine.model.ComponentServices;

import java.io.Serializable;
import java.util.List;

import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.model.MessageResponse;

public class ComponentListResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private List<Component> components;
	
	

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj =messageResponseObj;
	}
	
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public List<Component> getComponents() {
		return components;
	}
	
	public void setComponents(List<Component> components) {
		this.components = components;
	}
}
