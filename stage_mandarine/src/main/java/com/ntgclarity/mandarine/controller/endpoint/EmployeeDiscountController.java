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
import com.ntgclarity.mandarine.constants.CodesAndMessages;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.entity.EmployeeDiscountCategory;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.EmployeeDiscountCategoryAddResponse;
import com.ntgclarity.mandarine.model.EmployeeDiscountListResponse;
import com.ntgclarity.mandarine.model.EmployeeDiscountUpdateResponse;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.service.EmployeeDiscountCategoryService;
import com.ntgclarity.mandarine.util.Utils;

@RestController
@RequestMapping(path = "/api/v1/EmployeeDiscount",produces = "application/json")
@CrossOrigin
public class EmployeeDiscountController {
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

	
	@Autowired
	EmployeeDiscountCategoryService  employeeDiscountCategoryServiceService;

	//EmployeeDiscountCategoryService Add Service
	 @RequestMapping(path = "/add", method = RequestMethod.POST)
	    public ResponseEntity<?> addEmployeeDiscountCategoryService(@RequestBody EmployeeDiscountCategory employeeDiscountCategory) {//String body) {
	       // categoryService.addCategory(category);
		 EmployeeDiscountCategoryAddResponse response = new EmployeeDiscountCategoryAddResponse();
	    	try {
	    		
	    		//Validation
	    		EmployeeDiscountCategory temp=employeeDiscountCategoryServiceService.save(employeeDiscountCategory);
	    		response.setEmployeeDiscountCategory(temp);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, add EmployeeDiscountCategoryService request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, add EmployeeDiscountCategoryService request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, add EmployeeDiscountCategoryService request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }
	//Get EmployeeDiscountCategoryService List
	   @RequestMapping(path = "/all", method = RequestMethod.GET)
	    public ResponseEntity<?> getAllEmployeeDiscountCategoryServices() {

	    	EmployeeDiscountListResponse response = new EmployeeDiscountListResponse();
	    	try {
	    		List<EmployeeDiscountCategory> EmployeeDiscountCategoryServices = employeeDiscountCategoryServiceService.getAllEmployeeDiscountCategory();
	    		response.setDiscounts(EmployeeDiscountCategoryServices);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, get all EmployeeDiscountCategoryServices request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, get all EmployeeDiscountCategoryServices request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				ex.printStackTrace();
				log.error("[NTG_LOG_START] 500, get all EmployeeDiscountCategoryServices request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }
	   
	   
//Update EmployeeDiscountCategoryService
	   @ResponseBody
	   @RequestMapping(path = "/update", method = RequestMethod.POST)
	    public ResponseEntity<?> updateEmployeeDiscountCategoryService(@RequestBody EmployeeDiscountCategory employeeDiscountCategory) {
	        //categoryService.updateCategory(category);
		   EmployeeDiscountUpdateResponse response = new EmployeeDiscountUpdateResponse();
	    	try {
	    		System.out.println(employeeDiscountCategory.getDiscountCategory());
	    		employeeDiscountCategoryServiceService.update(employeeDiscountCategory.getId(), employeeDiscountCategory);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, update EmployeeDiscountCategoryService request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, update EmployeeDiscountCategoryService request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				ex.printStackTrace();
				log.error("[NTG_LOG_START] 500, update EmployeeDiscountCategoryService request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }

	   //Delete EmployeeDiscountCategoryService
	   @ResponseBody
	   @RequestMapping(path = "/delete", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	    public ResponseEntity<?> deleteEmployeeDiscountCategoryService(@RequestBody Integer id,HttpServletRequest request)//@RequestBody Category category) {
	    {
	    	//
	    	EmployeeDiscountUpdateResponse response = new EmployeeDiscountUpdateResponse();
	    	try {	    		
	    		EmployeeDiscountCategory comp = employeeDiscountCategoryServiceService.getOneEmployeeDiscountCategory(new Long(id));
	    		comp.setUpdatedBy("");//TODO enter user;
	    		comp.setUpdatedAt(new Date());
	    		employeeDiscountCategoryServiceService.delete(comp);
	    		
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, Delete EmployeeDiscountCategoryService request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, Delete EmployeeDiscountCategoryService request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, Delete EmployeeDiscountCategoryService request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }

	   //getOne EmployeeDiscountCategoryService
	   
	   @RequestMapping (path = "/service/{id}",method = RequestMethod.GET)
    public EmployeeDiscountCategory getOneEmployeeDiscountCategoryService(@PathVariable("id")Long id) {
        return employeeDiscountCategoryServiceService.getOneEmployeeDiscountCategory(id);
    }
}
