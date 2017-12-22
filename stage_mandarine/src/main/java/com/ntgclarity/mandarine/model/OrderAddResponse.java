package com.ntgclarity.mandarine.model;

import java.io.Serializable;

import com.ntgclarity.mandarine.entity.Orders;

public class OrderAddResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private Orders orders;

	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

}
