/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.model;

import com.ntgclarity.mandarine.entity.Servicetype;

public class ServiceTypeUpdateResponse {
	private MessageResponse messageResponseObj;
	private Servicetype servicetype;
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}
	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}
	public Servicetype getServicetype() {
		return servicetype;
	}
	public void setServicetype(Servicetype servicetype) {
		this.servicetype = servicetype;
	}
	
}