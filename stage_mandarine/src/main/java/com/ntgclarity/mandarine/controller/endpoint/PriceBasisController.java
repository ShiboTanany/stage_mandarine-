/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.controller.endpoint;

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

import com.ntgclarity.mandarine.constants.CodesAndMessages;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.entity.Bandwidth;
import com.ntgclarity.mandarine.entity.PriceBasis;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.model.PriceBasisAddResponse;
import com.ntgclarity.mandarine.model.PriceBasisDeleteResponse;
import com.ntgclarity.mandarine.model.PriceBasisListRepsonse;
import com.ntgclarity.mandarine.service.PriceBasisService;
import com.ntgclarity.mandarine.util.Utils;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/PriceBasis", produces = "application/json")
public class PriceBasisController {
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	PriceBasisService priceBasisService;

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		PriceBasisListRepsonse response = new PriceBasisListRepsonse();
		try {
			response.setPriceBasis(priceBasisService.getAll());
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, get all Price Basis request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, get all Price Basis request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {

			log.error("[NTG_LOG_START] 500, get all Price Basis request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody PriceBasis priceBasis) {
		PriceBasisAddResponse response = new PriceBasisAddResponse();
		try {
			priceBasisService.save(priceBasis);
			response.setPriceBasis(priceBasis);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, add Price Basis request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, add Price Basis request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {

			log.error("[NTG_LOG_START] 500, add Price Basis request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody PriceBasis priceBasis) {
		PriceBasisAddResponse response = new PriceBasisAddResponse();
		try {

			priceBasisService.update(priceBasis.getId(), priceBasis);
			response.setPriceBasis(priceBasis);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, update Price Basis request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, update Price Basis request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {

			log.error("[NTG_LOG_START] 500, update Price Basis request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> deleteBandwidth(@PathVariable Long id) {
		PriceBasisDeleteResponse response = new PriceBasisDeleteResponse();
		try {

			priceBasisService.delete(id);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, delete Price Basis request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, delete Price Basis request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {

			log.error("[NTG_LOG_START] 500, delete Price Basis request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
