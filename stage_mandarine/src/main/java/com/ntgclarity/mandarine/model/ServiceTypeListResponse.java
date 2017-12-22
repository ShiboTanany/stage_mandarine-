/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.model;

import java.util.List;

import com.ntgclarity.mandarine.entity.Servicetype;

public class ServiceTypeListResponse {
	private MessageResponse messageResponseObj;
	private List<Servicetype>servicetypes;
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}
	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}
	public List<Servicetype> getServicetypes() {
		return servicetypes;
	}
	public void setServicetypes(List<Servicetype> servicetypes) {
		this.servicetypes = servicetypes;
	}
	
}