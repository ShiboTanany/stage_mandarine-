/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.model;

import com.ntgclarity.mandarine.entity.SellingType;
import java.io.Serializable;

/**
 *
 * @author yasmeen
 */
public class SellingTypeAddResponse  implements Serializable{
 
    private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private SellingType sellingType;

	public MessageResponse getMessageResponseObj() {
		return messageResponseObj;
	}

	public void setMessageResponseObj(MessageResponse messageResponseObj) {
		this.messageResponseObj = messageResponseObj;
	}

    public SellingType getSellingType() {
        return sellingType;
    }

    public void setSellingType(SellingType sellingType) {
        this.sellingType = sellingType;
    }

	
}
