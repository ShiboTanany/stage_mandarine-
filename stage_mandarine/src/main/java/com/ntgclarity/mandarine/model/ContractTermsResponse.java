package com.ntgclarity.mandarine.model;

import java.util.List;

import com.ntgclarity.mandarine.entity.Contractterms;
import com.ntgclarity.mandarine.entity.Servicemigration;

public class ContractTermsResponse {
	private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private Contractterms contractTerm;
	private List<Contractterms> list;

	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}

	public Contractterms getContractTerm() {
		return contractTerm;
	}

	public void setContractTerm(Contractterms contractTerm) {
		this.contractTerm = contractTerm;
	}

	public List<Contractterms> getList() {
		return list;
	}

	public void setList(List<Contractterms> list) {
		this.list = list;
	}

	
	
}
