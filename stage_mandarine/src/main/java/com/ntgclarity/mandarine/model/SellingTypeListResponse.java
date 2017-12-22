/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.model;

import com.ntgclarity.mandarine.dto.OrderDto;
import com.ntgclarity.mandarine.entity.SellingType;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author yasmeen
 */
public class SellingTypeListResponse  implements Serializable{
    private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private List<SellingType> sellingType;
	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}
	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}

    public List<SellingType> getSellingType() {
        return sellingType;
    }

    public void setSellingType(List<SellingType> sellingType) {
        this.sellingType = sellingType;
    }
	
}
