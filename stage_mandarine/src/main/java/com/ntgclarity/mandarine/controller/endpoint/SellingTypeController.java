/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.controller.endpoint;

import com.ntgclarity.mandarine.constants.CodesAndMessages;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.entity.SellingType;
import com.ntgclarity.mandarine.entity.Service;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.model.SellingTypeAddResponse;
import com.ntgclarity.mandarine.model.SellingTypeDeleteReponse;
import com.ntgclarity.mandarine.model.SellingTypeListResponse;
import com.ntgclarity.mandarine.model.SellingTypeUpdateResponse;
import com.ntgclarity.mandarine.model.ServiceAddResponse;
import com.ntgclarity.mandarine.service.SellingTypeService;
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
@RequestMapping(path = "/api/v1/sellingType", produces = "application/json")
public class SellingTypeController {

    @Autowired
    SellingTypeService sellingTypeService;

    private static final Logger log = LoggerFactory.getLogger(SellingTypeController.class);

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addSellingType(@RequestBody SellingType sellingType) {

        SellingTypeAddResponse response = new SellingTypeAddResponse();

        try {
            if (sellingType.getHideInDropDown() == null || sellingType.getType().trim().isEmpty()) {
                throw new ApplicationException("400", " type is required");
            }
            sellingTypeService.addSellingType(sellingType);
            response.setMessageResponseObj(
                    new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
            response.setSellingType(sellingType);
            log.info("[NTG_LOG_START] 200 OK, add SellingType request succeeded [NTG_LOG_END]");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            e.printStackTrace();
            log.info("[NTG_LOG_START] 400, add SellingType request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            log.error("[NTG_LOG_START] 500, add SellingType request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<?> getAllSellingTypes() {

        SellingTypeListResponse response = new SellingTypeListResponse();
        try {
            List<SellingType> sellingTypes = sellingTypeService.getAllSellingTypes();

            response.setSellingType(sellingTypes);
            response.setMessageResponseObj(
                    new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
            log.info("[NTG_LOG_START] 200 OK, get all Sellingtypes request succeeded [NTG_LOG_END]");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            log.info("[NTG_LOG_START] 400, get all Sellingtypes request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR MESSAGE IS " + ex.getMessage());
            log.error("[NTG_LOG_START] 500, get all Sellingtypes request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/deleteSellingType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSellingType(@PathVariable Long id) {

        SellingTypeDeleteReponse response = new SellingTypeDeleteReponse();
        try {
            SellingType sellingType = sellingTypeService.getSellingTypeById(id);
            if (sellingType != null) {
                sellingTypeService.delete(id);
                response.setMessageResponseObj(
                        new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
                log.info("[NTG_LOG_START] 200 OK, delete SellingType request succeeded [NTG_LOG_END]");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                throw new ApplicationException("400", "SellingType id is not exist");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
            log.info("[NTG_LOG_START] 400, delete sellingType request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            log.error("[NTG_LOG_START] 500, Delete sellingType request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateSellingType(@RequestBody SellingType sellingType) {
		      SellingTypeAddResponse response = new SellingTypeAddResponse();

		try {
			// Validation
			if (sellingType.getHideInDropDown()==null || sellingType.getType().trim().isEmpty())
				throw new ApplicationException("400", "type is required");
			sellingTypeService.update(sellingType.getId(), sellingType);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			response.setSellingType(sellingType);
			log.info("[NTG_LOG_START] 200 OK, update SellingType request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			e.printStackTrace();
			log.info("[NTG_LOG_START] 400, update SellingType request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			log.error("[NTG_LOG_START] 500, update SellingType request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
