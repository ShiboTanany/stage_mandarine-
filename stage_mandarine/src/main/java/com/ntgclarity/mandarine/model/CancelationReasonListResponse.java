/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.model;

import com.ntgclarity.mandarine.entity.CancelationReason;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author yasmeen
 */
public class CancelationReasonListResponse  implements Serializable{
    private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private List<CancelationReason> cancelationReason;

    public MessageResponse getMessageResponseObj() {
        return messageResponseObj;
    }

    public void setMessageResponseObj(MessageResponse messageResponseObj) {
        this.messageResponseObj = messageResponseObj;
    }

    public List<CancelationReason> getCancelationReason() {
        return cancelationReason;
    }

    public void setCancelationReason(List<CancelationReason> cancelationReason) {
        this.cancelationReason = cancelationReason;
    }
        
}
