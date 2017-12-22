package com.ntgclarity.mandarine.model;

import java.util.List;

import com.ntgclarity.mandarine.entity.Contractterms;
import com.ntgclarity.mandarine.entity.Modifyreason;

public class ModifyReasonResponse {
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private Modifyreason  modifyReason;
	private List<Modifyreason> list;

	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}

	public Modifyreason getModifyReason() {
		return modifyReason;
	}

	public void setModifyReason(Modifyreason modifyReason) {
		this.modifyReason = modifyReason;
	}

	public List<Modifyreason> getList() {
		return list;
	}

	public void setList(List<Modifyreason> list) {
		this.list = list;
	}

	
}
