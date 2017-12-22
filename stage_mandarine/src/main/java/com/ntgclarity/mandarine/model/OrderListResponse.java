package com.ntgclarity.mandarine.model;

import java.io.Serializable;
import java.util.List;

import com.ntgclarity.mandarine.dto.OrderDto;

public class OrderListResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private List<OrderDto> orderDtos;
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}
	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}
	public List<OrderDto> getOrderDtos() {
		return orderDtos;
	}
	public void setOrderDtos(List<OrderDto> orderDtos) {
		this.orderDtos = orderDtos;
	}
	
}
