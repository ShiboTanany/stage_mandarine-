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
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.entity.Contractterms;
import com.ntgclarity.mandarine.entity.Servicemigration;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.ContractTermsResponse;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.model.ServiceMigrationResponse;
import com.ntgclarity.mandarine.model.ComponentServices.ComponentAddResponse;
import com.ntgclarity.mandarine.model.ComponentServices.ComponentListResponse;
import com.ntgclarity.mandarine.model.ComponentServices.ComponentUpdateResponse;
import com.ntgclarity.mandarine.service.ContractTermsService;
import com.ntgclarity.mandarine.service.ServiceMigrationService;
import com.ntgclarity.mandarine.service.componentService;
import com.ntgclarity.mandarine.util.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/serviceMigration",produces = "application/json")
@CrossOrigin
public class ServiceMigrationController {
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

	
	
	@Autowired
	ServiceMigrationService migrationService;
	

	  @ApiOperation(value = "add migration service  ", nickname = "add mgration service ")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Servicemigration.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	 @RequestMapping(path = "/add", method = RequestMethod.POST)
	  @CrossOrigin
	    public ResponseEntity<?> addMigrationService(@RequestBody Servicemigration serviceMigration) {//String body) {
	       // categoryService.addCategory(category);
	    	ServiceMigrationResponse response = new ServiceMigrationResponse();
	    	try {
	    		
	    		//Validation
	    		
	    		if(serviceMigration.getFromserviceid()!=null&&serviceMigration.getToserviceid()!=null){
	    migrationService.addMigrationService(serviceMigration);
	    		
	    		response.setServiceMigration(serviceMigration);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, add migration service  request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);}
	    		else{
	    			
	    			throw new ApplicationException("400", " migration service can't be null"
	    					+ " and number of months too");
	    		}
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, migration servicet  request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, add contract  request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }
	//Get Component List
	  @ApiOperation(value = "get service migration  ", nickname = "get all service migration")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Servicemigration.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	   @RequestMapping(path = "/all", method = RequestMethod.GET)
	  @CrossOrigin
	    public ResponseEntity<?> getALlServiceMigration() {

		  ServiceMigrationResponse response = new ServiceMigrationResponse();
	    	try {
	    		List<Servicemigration> services = migrationService.getAllMigrationService();
	    		response.setList(services);
	    		
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, get all services migration request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400,get all services migrationrequest failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				ex.printStackTrace();
				log.error("[NTG_LOG_START] 500, get all services migration request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }
	   
	   
	  @ApiOperation(value = " get all services migration by id   ", nickname = "get all services migration by id ")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Servicemigration.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	   @RequestMapping(path = "/allServices/{id}", method = RequestMethod.GET)
	  @CrossOrigin
	    public ResponseEntity<?> getAllComponents(@PathVariable Long id) {
		  ServiceMigrationResponse response = new ServiceMigrationResponse();
	    	try {
	    		Servicemigration service = migrationService.getMigrationService(id);
	    		if(service!=null){
	    		response.setServiceMigration(service);
	    	//	response.setCount(componentService.getRowsCount());
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, get  contract request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);}else{
					
					throw new ApplicationException("400","no service migartion with this id");
				}
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, get Contract request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, get all components request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }
	

	  @ApiOperation(value = "update service migrate    ", nickname = "update cservice migrate ")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Servicemigration.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	   @RequestMapping(path = "/update", method = RequestMethod.POST)
	  @CrossOrigin
	    public ResponseEntity<?> updateComponent(@RequestBody Servicemigration contract) {
	       
			ContractTermsResponse response = new ContractTermsResponse();
	    	try {
	    		Servicemigration  service =migrationService.getMigrationService(contract.getId());
	    		if(service!=null){
	    			migrationService.updateMigrationService(contract);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, update component request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);}
	    		else{throw new ApplicationException("400","id isnot existed");}
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, update component request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, update component request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }

	   //Delete Component
	   @ResponseBody
	   @ApiOperation(value = "delete  service migrate   ", nickname = "delete service migrate ")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Servicemigration.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	   @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE, produces="application/json")
	   @CrossOrigin 
	   public ResponseEntity<?> deleteComponent(@PathVariable Long id)//@RequestBody Category category) {
	    {
		   ServiceMigrationResponse response = new ServiceMigrationResponse();
	    	try {	    		
	    		Servicemigration contract=migrationService.getMigrationService(id);
	    		if(contract!=null){
	    		migrationService.deleteMigrationService(contract);
	    		response.setServiceMigration(contract);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, Delete service migration request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);}
	    		else{
	    			
	    			throw new ApplicationException("400","id is not exist ");
	    		}
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400,  Delete service migration request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500,  Delete service migration request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }

}
