package com.ntgclarity.mandarine.model;

import java.util.List;

import com.ntgclarity.mandarine.entity.Servicemigration;
import com.ntgclarity.mandarine.entity.UserTable;

public class ServiceMigrationResponse {
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private Servicemigration serviceMigration;
	
	private List<Servicemigration> list;
	

	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}

	public Servicemigration getServiceMigration() {
		return serviceMigration;
	}

	public void setServiceMigration(Servicemigration serviceMigration) {
		this.serviceMigration = serviceMigration;
	}

	public List<Servicemigration> getList() {
		return list;
	}

	public void setList(List<Servicemigration> list) {
		this.list = list;
	}

	
	
	
}