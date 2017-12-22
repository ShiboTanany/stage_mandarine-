package com.ntgclarity.mandarine.controller.endpoint;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.ntgclarity.mandarine.entity.Contractterms;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.ContractTermsResponse;
import com.ntgclarity.mandarine.model.MessageResponse;

import com.ntgclarity.mandarine.service.ContractTermsService;

import com.ntgclarity.mandarine.util.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



import com.ntgclarity.mandarine.constants.CodesAndMessages;
import com.ntgclarity.mandarine.dto.StatusResponse;


@RestController
@RequestMapping(path = "/api/v1/contracts",produces = "application/json")
@CrossOrigin
public class ContractTermsController {
private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

	
	@Autowired
	ContractTermsService  contractTermService;
	

	
	
	
	  @ApiOperation(value = "add contract term  ", nickname = "add contract term ")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Contractterms.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	 @RequestMapping(path = "/add", method = RequestMethod.POST)
	  @CrossOrigin
	    public ResponseEntity<?> addContract(@RequestBody Contractterms contract) {//String body) {
	       // categoryService.addCategory(category);
	    	ContractTermsResponse response = new ContractTermsResponse();
	    	try {
	    		
	    		//Validation
	    		
	    		if(contract.getContractterm()!=null&&contract.getNumberofmonths()!=null){
	    		contractTermService.addContractTerm(contract);
	    		
	    		response.setContractTerm(contract);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, add contract  request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);}
	    		else{
	    			
	    			throw new ApplicationException("400", "contract term can't be null"
	    					+ " and number of months too");
	    		}
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, add contract  request failed with error: ("
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
	  @ApiOperation(value = "get all contracts   ", nickname = "get all contracts")
	  @CrossOrigin
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Contractterms.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	   @RequestMapping(path = "/all", method = RequestMethod.GET)
	    public ResponseEntity<?> getAllContracts() {

			ContractTermsResponse response = new ContractTermsResponse();
	    	try {
	    		List<Contractterms> contracts = contractTermService.getAllContractTerms();
	    		response.setList(contracts);
	    		
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, get all contracts request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, get all components request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				ex.printStackTrace();
				log.error("[NTG_LOG_START] 500, get all components request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }
	   
	   
	  @ApiOperation(value = "get all contracts by id   ", nickname = "get all contracts ny id ")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Contractterms.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	   @RequestMapping(path = "/allContracts/{id}", method = RequestMethod.GET)
	  @CrossOrigin
	    public ResponseEntity<?> getAllComponents(@PathVariable Long id) {
			ContractTermsResponse response = new ContractTermsResponse();
	    	try {
	    		Contractterms contract = contractTermService.getContractTerm(id);
	    		response.setContractTerm(contract);
	    	//	response.setCount(componentService.getRowsCount());
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, get  contract request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, get Contract request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, get all Contract request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }
	
//Update Component
	  @ApiOperation(value = "update contract    ", nickname = "update contract ")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Contractterms.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	   @RequestMapping(path = "/update", method = RequestMethod.POST)
	  @CrossOrigin
	    public ResponseEntity<?> updateComponent(@RequestBody Contractterms contract) {
	       
			ContractTermsResponse response = new ContractTermsResponse();
	    	try {
	    		contractTermService.updateContractTerm( contract);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, update Contract request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, update Contract request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, update Contract request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }

	   //Delete Component
	   @ResponseBody
	   @ApiOperation(value = "delete  contract   ", nickname = "delete contract ")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Contractterms.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	   @CrossOrigin
	   @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE, produces="application/json")
	    public ResponseEntity<?> deleteComponent(@PathVariable Long id)//@RequestBody Category category) {
	    {
			ContractTermsResponse response = new ContractTermsResponse();
	    	try {	    		
	    		Contractterms contract=contractTermService.getContractTerm(id);
	    		if(contract!=null){
	    		contractTermService.deleteContractTerm(contract);
	    		response.setContractTerm(contract);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, Delete Contract request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);}
	    		else{
	    			
	    			throw new ApplicationException("400","id is not exist ");
	    		}
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, Delete Contract request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, Delete Contract request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }

	   
}
