package com.ntgclarity.mandarine.controller.endpoint;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntgclarity.mandarine.constants.CodesAndMessages;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.entity.Contractterms;
import com.ntgclarity.mandarine.entity.Modifyreason;
import com.ntgclarity.mandarine.entity.Servicemigration;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.ContractTermsResponse;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.model.ModifyReasonResponse;
import com.ntgclarity.mandarine.model.ServiceMigrationResponse;
import com.ntgclarity.mandarine.service.ModifyReasonService;
import com.ntgclarity.mandarine.service.ServiceMigrationService;
import com.ntgclarity.mandarine.util.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/reason",produces = "application/json")
@CrossOrigin
public class ModifyReasonController {
	

		private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

		@Autowired
		ModifyReasonService reasonService;
		

		  @ApiOperation(value = "add reason   ", nickname = "add reason ")
		    @ApiResponses(value = { 
		            @ApiResponse(code = 200, message = "Success", response = Modifyreason.class),
		            @ApiResponse(code = 401, message = "Unauthorized"),
		            @ApiResponse(code = 403, message = "Forbidden"),
		            @ApiResponse(code = 404, message = "Not Found"),
		            @ApiResponse(code = 500, message = "Failure")})
		 @RequestMapping(path = "/add", method = RequestMethod.POST)
		  @CrossOrigin
		    public ResponseEntity<?> addReason(@RequestBody Modifyreason modifyReason) {//String body) {
		       // categoryService.addCategory(category);
		    	System.out.println("adding reason "+modifyReason.getRecid());
			  ModifyReasonResponse response = new ModifyReasonResponse();
		    	try {
		    		
		    		//Validation
		    		
		    		if(modifyReason.getRecid()!=null){
		    			reasonService.addModifyReason(modifyReason);
		    		
		    		response.setModifyReason(modifyReason);
		    		response.setMessageResponseObj(
							new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
					log.info("[NTG_LOG_START] 200 OK, add modifyReason  request succeeded [NTG_LOG_END]");
					return new ResponseEntity<>(response, HttpStatus.OK);}
		    		else{
		    			
		    			throw new ApplicationException("400", " modifyReason can't be null"
		    					);
		    		}
				} catch (ApplicationException e) {
					log.info("[NTG_LOG_START] 400, modifyReason  request failed with error: ("
							+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
					return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
				} catch (Exception ex) {
					log.error("[NTG_LOG_START] 500, modifyReason  request failed with error: ("
							+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
					return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
							HttpStatus.INTERNAL_SERVER_ERROR);
				}
		    }

	// Get Component List
	@ApiOperation(value = "get ModifyReason  ", nickname = "get all ModifyReason")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Modifyreason.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<?> getALlServiceMigration() {

		ModifyReasonResponse response = new ModifyReasonResponse();
		try {
			List<Modifyreason> services = reasonService.getAllModifyReason();
			response.setList(services);

			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, get allmodify reason request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400,get all modify reason request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error("[NTG_LOG_START] 500, get all modify reason request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
		   
		   
		  @ApiOperation(value = " get all modify reason by id   ", nickname = "get all modify reason by id ")
		    @ApiResponses(value = { 
		            @ApiResponse(code = 200, message = "Success", response = Modifyreason.class),
		            @ApiResponse(code = 401, message = "Unauthorized"),
		            @ApiResponse(code = 403, message = "Forbidden"),
		            @ApiResponse(code = 404, message = "Not Found"),
		            @ApiResponse(code = 500, message = "Failure")})
		   @RequestMapping(path = "/allModifyReason/{id}", method = RequestMethod.GET)
		    public ResponseEntity<?> getAllComponents(@PathVariable Long id) {
				ModifyReasonResponse response = new ModifyReasonResponse();
		    	try {
		    		Modifyreason modifyService = reasonService.getModifyReason(id);
		    		if(modifyService!=null){
		    		response.setModifyReason(modifyService);
		    	//	response.setCount(componentService.getRowsCount());
		    		response.setMessageResponseObj(
							new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
					log.info("[NTG_LOG_START] 200 OK, get modifyService request succeeded [NTG_LOG_END]");
					return new ResponseEntity<>(response, HttpStatus.OK);}else{
						
						throw new ApplicationException("400","no service migartion with this id");
					}
				} catch (ApplicationException e) {
					log.info("[NTG_LOG_START] 400, get modifyService request failed with error: ("
							+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
					return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
				} catch (Exception ex) {
					log.error("[NTG_LOG_START] 500, get modifyService request failed with error: ("
							+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
					return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
							HttpStatus.INTERNAL_SERVER_ERROR);
				}
		    	
		    }
		

		  @ApiOperation(value = "update modifyService   ", nickname = "update modifyService ")
		    @ApiResponses(value = { 
		            @ApiResponse(code = 200, message = "Success", response = Modifyreason.class),
		            @ApiResponse(code = 401, message = "Unauthorized"),
		            @ApiResponse(code = 403, message = "Forbidden"),
		            @ApiResponse(code = 404, message = "Not Found"),
		            @ApiResponse(code = 500, message = "Failure")})
		   @RequestMapping(path = "/update", method = RequestMethod.POST)
		    public ResponseEntity<?> updateComponent(@RequestBody Modifyreason reason) {
		       
				ModifyReasonResponse response = new ModifyReasonResponse();
		    	try {
		    		System.out.println("object is :"+reason.getId()+""+reason.getRecid()+""+reason.getModifyreason());
		    		Modifyreason  reason2 =reasonService.getModifyReason(reason.getId());
		    		if(reason2!=null){
		    			reasonService.updateModifyReason(reason);
		    		response.setMessageResponseObj(
							new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
					log.info("[NTG_LOG_START] 200 OK, update modifyService request succeeded [NTG_LOG_END]");
					return new ResponseEntity<>(response, HttpStatus.OK);}
		    		else{throw new ApplicationException("400","id isnot existed");}
				} catch (ApplicationException e) {
					log.info("[NTG_LOG_START] 400, update modifyService request failed with error: ("
							+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
					return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
				} catch (Exception ex) {
					log.error("[NTG_LOG_START] 500, update modifyService request failed with error: ("
							+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
					return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
							HttpStatus.INTERNAL_SERVER_ERROR);
				}
		    	
		    }

		   //Delete Component
		   @ResponseBody
		   @ApiOperation(value = "delete  modifyService   ", nickname = "delete modifyService ")
		    @ApiResponses(value = { 
		            @ApiResponse(code = 200, message = "Success", response = Modifyreason.class),
		            @ApiResponse(code = 401, message = "Unauthorized"),
		            @ApiResponse(code = 403, message = "Forbidden"),
		            @ApiResponse(code = 404, message = "Not Found"),
		            @ApiResponse(code = 500, message = "Failure")})
		   @CrossOrigin
		   @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE, produces="application/json")
		    public ResponseEntity<?> deleteComponent(@PathVariable Long id)//@RequestBody Category category) {
		    {
				ModifyReasonResponse response = new ModifyReasonResponse();
		    	try {	    		
		    		Modifyreason reason=reasonService.getModifyReason(id);
		    		System.out.println("in delete method"+id);
		    		if(reason!=null){
		    		reasonService.deleteModifyReason(reason);
		    		response.setModifyReason(reason);
		    		response.setMessageResponseObj(
							new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
					log.info("[NTG_LOG_START] 200 OK, Delete modifyService request succeeded [NTG_LOG_END]");
					return new ResponseEntity<>(response, HttpStatus.OK);}
		    		else{
		    			
		    			throw new ApplicationException("400","id is not exist ");
		    		}
				} catch (ApplicationException e) {
					log.info("[NTG_LOG_START] 400,  Delete modifyService request failed with error: ("
							+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
					return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
				} catch (Exception ex) {
					log.error("[NTG_LOG_START] 500,  Delete modifyService request failed with error: ("
							+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
					return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
							HttpStatus.INTERNAL_SERVER_ERROR);
				}}
		    	
}
	
