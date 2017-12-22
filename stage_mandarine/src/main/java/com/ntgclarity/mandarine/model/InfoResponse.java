package com.ntgclarity.mandarine.model;

import java.io.Serializable;

import com.ntgclarity.mandarine.dto.StatsticsDto;

public class InfoResponse implements Serializable {
	private MessageResponse messageResponseObj;
	private StatsticsDto statsticsDto;
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}
	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}
	public StatsticsDto getStatsticsDto() {
		return statsticsDto;
	}
	public void setStatsticsDto(StatsticsDto statsticsDto) {
		this.statsticsDto = statsticsDto;
	}
	
}
