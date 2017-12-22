/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.model;

import com.ntgclarity.mandarine.dto.OrderDto;
import com.ntgclarity.mandarine.entity.DownloadType;
import java.util.List;

/**
 *
 * @author yasmeen
 */
public class DownloadTypeListResponse {

    private static final long serialVersionUID = 1L;
    private MessageResponse messageResponseObj;
    private List<DownloadType> downloadTypes;

    public MessageResponse getMessageResponseObj() {
        return messageResponseObj;
    }

    public void setMessageResponseObj(MessageResponse messageResponseObj) {
        this.messageResponseObj = messageResponseObj;
    }

    public List<DownloadType> getDownloadTypes() {
        return downloadTypes;
    }

    public void setDownloadTypes(List<DownloadType> downloadTypes) {
        this.downloadTypes = downloadTypes;
    }

}
