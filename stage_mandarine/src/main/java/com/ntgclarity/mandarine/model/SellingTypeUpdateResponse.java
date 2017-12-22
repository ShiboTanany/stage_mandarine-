/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.model;

import java.io.Serializable;

/**
 *
 * @author yasmeen
 */
public class SellingTypeUpdateResponse  implements Serializable{
 private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;

    public MessageResponse getMessageResponseObj() {
        return messageResponseObj;
    }

    public void setMessageResponseObj(MessageResponse messageResponseObj) {
        this.messageResponseObj = messageResponseObj;
    }
        
}
