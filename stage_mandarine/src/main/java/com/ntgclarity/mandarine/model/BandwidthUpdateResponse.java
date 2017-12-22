/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.model;

import com.ntgclarity.mandarine.entity.Bandwidth;

/**
 *
 * @author Sheko
 */
public class BandwidthUpdateResponse {

    private static final long serialVersionUID = 1L;
    private MessageResponse messageResponseObj;
    private Bandwidth bandwidth;

    public MessageResponse getMessageResponseObj() {
        return messageResponseObj;
    }

    public void setMessageResponseObj(MessageResponse messageResponseObj) {
        this.messageResponseObj = messageResponseObj;
    }

    public Bandwidth getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Bandwidth bandwidth) {
        this.bandwidth = bandwidth;
    }

}