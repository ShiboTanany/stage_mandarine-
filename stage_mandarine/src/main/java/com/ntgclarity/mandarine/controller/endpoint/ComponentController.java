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
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.entity.Modifyreason;
import com.ntgclarity.mandarine.entity.Service;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.CategoryAddResponse;
import com.ntgclarity.mandarine.model.CategoryListResponse;
import com.ntgclarity.mandarine.model.CategoryUpdateResponse;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.model.ComponentServices.ComponentAddResponse;
import com.ntgclarity.mandarine.model.ComponentServices.ComponentListResponse;
import com.ntgclarity.mandarine.model.ComponentServices.ComponentUpdateResponse;
import com.ntgclarity.mandarine.service.componentService;
import com.ntgclarity.mandarine.util.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/Component",produces = "application/json")
@CrossOrigin
public class ComponentController {
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

	
	@Autowired
	componentService  componentService;
	
	//test method
	  @RequestMapping (path = "/getInt",method = RequestMethod.GET)
	    public Integer getOneComponent() {
	        return 55;
	    }
	
	
	//Component Add Service
	  @ApiOperation(value = "add component  ", nickname = "add component ")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Component.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	 @RequestMapping(path = "/add", method = RequestMethod.POST)
	    public ResponseEntity<?> addComponent(@RequestBody Component component) {//String body) {
	       // categoryService.addCategory(category);
	    	ComponentAddResponse response = new ComponentAddResponse();
	    	try {
	    		
	    		//Validation
	    		Component temp=componentService.save(component);
	    		response.setComponentID(temp.getId());
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, add Component request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, add Component request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, add Component request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }
	//Get Component List
	  @ApiOperation(value = "get all components ", nickname = "show all components  ")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Component.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	   @RequestMapping(path = "/all", method = RequestMethod.GET)
	    public ResponseEntity<?> getAllComponents() {

	    	ComponentListResponse response = new ComponentListResponse();
	    	try {
	    		List<Component> components = componentService.getAllComponent();
	    		response.setComponents(components);
	    		System.out.println("HERE");
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, get all components request succeeded [NTG_LOG_END]");
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
	   
	   
		//Get Component List Pageable
	  @ApiOperation(value = "get all components by page and size  ", nickname = "show components by size and page ")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Component.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	   @RequestMapping(path = "/allPageable/{page}/{size}", method = RequestMethod.GET)
	    public ResponseEntity<?> getAllComponents(@PathVariable int page,@PathVariable int size) {
	    	ComponentListResponse response = new ComponentListResponse();
	    	try {
	    		List<Component> components = componentService.getAllComponent(page,size);
	    		response.setComponents(components);
	    	//	response.setCount(componentService.getRowsCount());
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, get all components request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, get all components request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, get all components request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }
	
//Update Component
	  @ApiOperation(value = "update component  ", nickname = "update component")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Component.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	   @RequestMapping(path = "/update", method = RequestMethod.POST)
	    public ResponseEntity<?> updateComponent(@RequestBody Component component) {
	        //categoryService.updateCategory(category);
	    	ComponentUpdateResponse response = new ComponentUpdateResponse();
	    	try {
	    		componentService.update(component.getId(), component);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, update component request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
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
	  @ApiOperation(value = "delete component  ", nickname = "delete component")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Component.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	   @ResponseBody
	   @RequestMapping(path = "/delete", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	    public ResponseEntity<?> deleteComponent(@RequestBody Integer id,HttpServletRequest request)//@RequestBody Category category) {
	    {
	    	//
	    	ComponentUpdateResponse response = new ComponentUpdateResponse();
	    	try {	    		
	    		Component comp = new Component();
	    		comp.setId(new Long(id));
	    		comp.setUpdatedBy("");//TODO enter user;
	    		comp.setUpdatedAt(new Date());
	    		componentService.deleteComponent(comp);
	    		
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, Delete Component request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, Delete Component request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, Delete Component request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }

	   //getOne Component
	  @ApiOperation(value = "get component by id ", nickname = "get component by id ")
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = Component.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")})
	   
	   @RequestMapping (path = "/service/{id}",method = RequestMethod.GET)
    public Component getOneComponent(@PathVariable("id")Long id) {
        return componentService.getOneComponent(id);
    }
}
