package com.ntgclarity.mandarine.controller.endpoint;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntgclarity.mandarine.constants.CodesAndMessages;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.PcDeliveryType;
import com.ntgclarity.mandarine.entity.Service;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.CategoryAddResponse;
import com.ntgclarity.mandarine.model.CategoryListResponse;
import com.ntgclarity.mandarine.model.CategoryUpdateResponse;
import com.ntgclarity.mandarine.model.DeliveryTypeAddResponse;
import com.ntgclarity.mandarine.model.DeliveryTypeListResponse;
import com.ntgclarity.mandarine.model.DeliveryTypeUpdateResponse;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.util.Utils;

@RestController
@RequestMapping(path = "/api/v1/DeliveryType",produces = "application/json")
@CrossOrigin
public class DeliveryTypeController {
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

	
	@Autowired
	com.ntgclarity.mandarine.service.DeliveryTypeService  deliveryTypeService;

	//DeliveryType Add Service
	 @RequestMapping(path = "/add", method = RequestMethod.POST)
	    public ResponseEntity<?> addDeliveryType(@RequestBody PcDeliveryType DeliveryType) {//String body) {
	       // categoryService.addCategory(category);
	    	DeliveryTypeAddResponse response = new DeliveryTypeAddResponse();
	    	try {
	    		
	    		//Validation
	    		PcDeliveryType temp=deliveryTypeService.save(DeliveryType);
	    		response.setPcDeliveryType(temp);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, add DeliveryType request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, add DeliveryType request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, add DeliveryType request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }
	//Get DeliveryType List
	   @RequestMapping(path = "/all", method = RequestMethod.GET)
	    public ResponseEntity<?> getAllDeliveryTypes() {

	    	DeliveryTypeListResponse response = new DeliveryTypeListResponse();
	    	try {
	    		List<PcDeliveryType> deliveryTypes = deliveryTypeService.getAllPcDeliveryType();
	    		response.setdeliveryTypes(deliveryTypes);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, get all DeliveryTypes request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, get all DeliveryTypes request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				ex.printStackTrace();
				log.error("[NTG_LOG_START] 500, get all DeliveryTypes request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }
	   
	   
//Update DeliveryType
	   @RequestMapping(path = "/update", method = RequestMethod.POST)
	    public ResponseEntity<?> updateDeliveryType(@RequestBody PcDeliveryType DeliveryType) {
	        //categoryService.updateCategory(category);
	    	DeliveryTypeUpdateResponse response = new DeliveryTypeUpdateResponse();
	    	try {
	    		deliveryTypeService.update(DeliveryType.getId(), DeliveryType);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, update DeliveryType request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, update DeliveryType request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, update DeliveryType request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }

	   //Delete DeliveryType
	   @ResponseBody
	   @RequestMapping(path = "/delete", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	    public ResponseEntity<?> deleteDeliveryType(@RequestBody Integer id,HttpServletRequest request)//@RequestBody Category category) {
	    {
	    	//
	    	DeliveryTypeUpdateResponse response = new DeliveryTypeUpdateResponse();
	    	try {	    		
	    		PcDeliveryType comp = deliveryTypeService.getOnePcDeliveryType(new Long(id));
	    		comp.setUpdatedBy("");//TODO enter user;
	    		comp.setUpdatedAt(new Date());
	    		deliveryTypeService.deletePcDeliveryType(comp);
	    		
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, Delete DeliveryType request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, Delete DeliveryType request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, Delete DeliveryType request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }

	   //getOne DeliveryType
	   
	   @RequestMapping (path = "/service/{id}",method = RequestMethod.GET)
    public PcDeliveryType getOneDeliveryType(@PathVariable("id")Long id) {
        return deliveryTypeService.getOnePcDeliveryType(id);
    }
}
