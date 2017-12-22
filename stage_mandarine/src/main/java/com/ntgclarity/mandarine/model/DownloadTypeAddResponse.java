/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.model;

import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.DownloadType;
import java.io.Serializable;

/**
 *
 * @author yasmeen
 */
public class DownloadTypeAddResponse  implements Serializable{
 
    private static final long serialVersionUID = 1L;
	private MessageResponse messageResponseObj;
	private DownloadType downloadType;

    public MessageResponse getMessageResponseObj() {
        return messageResponseObj;
    }

    public void setMessageResponseObj(MessageResponse messageResponseObj) {
        this.messageResponseObj = messageResponseObj;
    }

    public DownloadType getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(DownloadType downloadType) {
        this.downloadType = downloadType;
    }
        
}
