/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.controller.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntgclarity.mandarine.constants.CodesAndMessages;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.entity.DownloadType;
import com.ntgclarity.mandarine.entity.Service;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.DownloadTypeAddResponse;
import com.ntgclarity.mandarine.model.DownloadTypeListResponse;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.model.ServiceAddResponse;
import com.ntgclarity.mandarine.model.ServiceDeleteResponse;
import com.ntgclarity.mandarine.model.ServiceListResponse;
import com.ntgclarity.mandarine.service.DownloadTypeService;
import com.ntgclarity.mandarine.util.Utils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yasmeen
 */
@RestController
@RequestMapping(path = "/api/v1/DownloadType", produces = "application/json")
@CrossOrigin
public class DownloadTypeController {

    @Autowired
    DownloadTypeService downloadTypeService;
    private static final Logger log = LoggerFactory.getLogger(ServiceController.class);

    @RequestMapping(path = "/addDownloadType", method = RequestMethod.POST)
    public ResponseEntity<?> addDownloadType(@RequestBody DownloadType downloadType) {

        DownloadTypeAddResponse response = new DownloadTypeAddResponse();

        try {
            if (downloadType.getName().trim().isEmpty()) {
                throw new ApplicationException("400", "downloadType name is required");
            }
            downloadTypeService.addDownloadType(downloadType);
            response.setMessageResponseObj(
                    new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
            response.setDownloadType(downloadType);
            log.info("[NTG_LOG_START] 200 OK, add downloadType request succeeded [NTG_LOG_END]");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            e.printStackTrace();
            log.info("[NTG_LOG_START] 400, add downloadType request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            log.error("[NTG_LOG_START] 500, add downloadType request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDownloadType(@PathVariable Long id) {

        DownloadTypeAddResponse response = new DownloadTypeAddResponse();
        System.out.println("*************" + id);
        try {
            downloadTypeService.delete(id);
//			DownloadType downloadType =new DownloadType();
//                            downloadType =downloadTypeService.getDownloadTypeById(id);
//000000000000
//			if (downloadType != null) {
//                            downloadTypeService.deleteDownloadType(downloadType);
            response.setMessageResponseObj(
                    new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));

            log.info("[NTG_LOG_START] 200 OK, delete downloadType request succeeded [NTG_LOG_END]");
            return new ResponseEntity<>(response, HttpStatus.OK);
//			} else {
//				throw new ApplicationException("400", "downloadType id is not exist");
//
//			}
        } catch (ApplicationException e) {
            e.printStackTrace();
            log.info("[NTG_LOG_START] 400, delete downloadType request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("[NTG_LOG_START] 500, delete downloadType request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateDownloadType(@RequestBody DownloadType downloadType) {
        DownloadTypeAddResponse response = new DownloadTypeAddResponse();
        try {
            System.out.println("/*/*/**************" + downloadType.getName());
            if (downloadType.getName().trim().isEmpty()) {
                throw new ApplicationException("400", "downloadType name is required");
            }
            downloadTypeService.update(downloadType.getId(), downloadType);
            response.setMessageResponseObj(
                    new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
            log.info("[NTG_LOG_START] 200 OK, update downloadType request succeeded [NTG_LOG_END]");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            e.printStackTrace();
            log.info("[NTG_LOG_START] 400, update downloadType request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("[NTG_LOG_START] 500, update downloadType request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<?> getAllDownloadTypes() {

        DownloadTypeListResponse response = new DownloadTypeListResponse();
        try {
            List<DownloadType> DownloadTypes = downloadTypeService.getAllDownloadTypes();
            response.setDownloadTypes(DownloadTypes);
            response.setMessageResponseObj(
                    new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
            log.info("[NTG_LOG_START] 200 OK, get all DownloadType request succeeded [NTG_LOG_END]");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            log.info("[NTG_LOG_START] 400, get all DownloadType request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR MESSAGE IS " + ex.getMessage());
            log.error("[NTG_LOG_START] 500, get all DownloadType request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
