/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.controller.endpoint;

import com.ntgclarity.mandarine.constants.CodesAndMessages;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.entity.CancelationReason;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.CancelationReasonAddResponse;
import com.ntgclarity.mandarine.model.CancelationReasonDeleteResponse;
import com.ntgclarity.mandarine.model.CancelationReasonListResponse;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.service.CancelationReasonService;
import com.ntgclarity.mandarine.util.Utils;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/CancelationReason", produces = "application/json")
public class CancelationReasonController {
    
    
    @Autowired
    CancelationReasonService cancelationReasonService;

    private static final Logger log = LoggerFactory.getLogger(CancelationReasonController.class);

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addCancelationReason(@RequestBody CancelationReason cancelationReason) {

        CancelationReasonAddResponse response = new CancelationReasonAddResponse();

        try {
            if (cancelationReason.getIscustomerrequest() == null || cancelationReason.getCancelreason().trim().isEmpty()) {
                throw new ApplicationException("400", " cancelation reason is required");
            }
            else{
            cancelationReasonService.addCancelationReason(cancelationReason);
            response.setMessageResponseObj(
                    new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
            response.setCancelationReason(cancelationReason);
            log.info("[NTG_LOG_START] 200 OK, add cancelationReason request succeeded [NTG_LOG_END]");
            }  return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            e.printStackTrace();
            log.info("[NTG_LOG_START] 400, add cancelationReason request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            log.error("[NTG_LOG_START] 500, add cancelationReason request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/getAllCancelationReasons", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCancelationReasons() {

        CancelationReasonListResponse response = new CancelationReasonListResponse();
        try {
            List<CancelationReason> cancelationReasons = cancelationReasonService.getAllCancelationReasons();
            response.setCancelationReason(cancelationReasons);
            response.setMessageResponseObj(
                    new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
            log.info("[NTG_LOG_START] 200 OK, get all CancelationReason request succeeded [NTG_LOG_END]");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            log.info("[NTG_LOG_START] 400, get all CancelationReason request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR MESSAGE IS " + ex.getMessage());
            log.error("[NTG_LOG_START] 500, get all CancelationReason request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/deleteCancelationReason/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCancelationReason(@PathVariable Long id) {

        CancelationReasonDeleteResponse response = new CancelationReasonDeleteResponse();
        try {
            CancelationReason cancelationReason = cancelationReasonService.getCancelationReasonById(id);
            if (cancelationReason != null) {
                cancelationReasonService.delete(id);
                response.setMessageResponseObj(
                        new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
                log.info("[NTG_LOG_START] 200 OK, delete cancelationReason request succeeded [NTG_LOG_END]");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                throw new ApplicationException("400", "cancelationReason id is not exist");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
            log.info("[NTG_LOG_START] 400, delete cancelationReason request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            log.error("[NTG_LOG_START] 500, Delete cancelationReason request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateCancelationReason(@RequestBody CancelationReason cancelationReason) {
		      CancelationReasonDeleteResponse response = new CancelationReasonDeleteResponse();
		try {
			if (cancelationReason.getIscustomerrequest()==null || cancelationReason.getCancelreason().trim().isEmpty())
				throw new ApplicationException("400", "category name and type are required");
			cancelationReasonService.update(cancelationReason.getId(), cancelationReason);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, update cancelationReason request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, update cancelationReason request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			log.error("[NTG_LOG_START] 500, update cancelationReason request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

    
}
