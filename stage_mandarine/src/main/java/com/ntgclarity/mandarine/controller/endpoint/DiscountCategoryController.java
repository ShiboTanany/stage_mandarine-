/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.controller.endpoint;

import javax.ws.rs.PathParam;

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
import com.ntgclarity.mandarine.entity.DiscountCategory;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.DiscountCategoryAddResponse;
import com.ntgclarity.mandarine.model.DiscountCategoryDeleteResponse;
import com.ntgclarity.mandarine.model.DiscountCategoryListResponse;
import com.ntgclarity.mandarine.model.DiscountCategoryUpdateResponse;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.service.DiscountCategoryService;
import com.ntgclarity.mandarine.util.Utils;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/DiscountCategory", produces = "application/json")
public class DiscountCategoryController {
	@Autowired
	DiscountCategoryService discountCategoryService;
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		DiscountCategoryListResponse response = new DiscountCategoryListResponse();
		try {
			response.setDiscountCategories(discountCategoryService.getAll());
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, get all Discount Category request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, get all Discount Category request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {

			log.error("[NTG_LOG_START] 500, get all Discount Category request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody DiscountCategory discountCategory) {
		DiscountCategoryAddResponse response = new DiscountCategoryAddResponse();
		try {
			discountCategoryService.save(discountCategory);
			response.setDiscountCategory(discountCategory);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, add Discount Category request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, add  Discount Category request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {

			log.error("[NTG_LOG_START] 500, add  Discount Category request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody DiscountCategory discountCategory) {
		DiscountCategoryUpdateResponse response = new DiscountCategoryUpdateResponse();
		try {
			discountCategoryService.update(discountCategory.getId(), discountCategory);
			response.setDiscountCategory(discountCategory);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, update Discount Category request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, update  Discount Category request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {

			log.error("[NTG_LOG_START] 500, update  Discount Category request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		DiscountCategoryDeleteResponse response = new DiscountCategoryDeleteResponse();
		try {
			discountCategoryService.delete(id);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK,update  Bandwidth request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, delete  Discount Category request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {

			log.error("[NTG_LOG_START] 500, delete  Discount Category request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}