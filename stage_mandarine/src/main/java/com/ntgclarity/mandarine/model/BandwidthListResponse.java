/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.model;

import com.ntgclarity.mandarine.entity.Bandwidth;
import java.util.List;

/**
 *
 * @author Sheko
 */
public class BandwidthListResponse {

    
    private MessageResponse messageResponseObj;
    private List<Bandwidth> bandwidths;

    public MessageResponse getMessageResponseObj() {
        return messageResponseObj;
    }

    public void setMessageResponseObj(MessageResponse messageResponseObj) {
        this.messageResponseObj = messageResponseObj;
    }

    public List<Bandwidth> getBandwidths() {
        return bandwidths;
    }

    public void setBandwidths(List<Bandwidth> bandwidths) {
        this.bandwidths = bandwidths;
    }
    
}