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
import com.ntgclarity.mandarine.dto.Order.AddOrderDto;
import com.ntgclarity.mandarine.entity.ServiceCategory;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.model.ServiceCategoryAddResponse;
import com.ntgclarity.mandarine.model.ServiceCategoryListResponse;
import com.ntgclarity.mandarine.model.ServiceCategoryUpdateResponse;
import com.ntgclarity.mandarine.service.ServiceCategoryService;
import com.ntgclarity.mandarine.util.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/ServiceCategory",produces = "application/json")
@CrossOrigin
public class ServiceCategoryController {
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

	
	@Autowired
	ServiceCategoryService  serviceCategoryService;

	//ServiceCategory Add Service
	@ApiOperation(value = "add service category ", nickname = "add service category")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = ServiceCategory.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	 @RequestMapping(path = "/add", method = RequestMethod.POST)
	    public ResponseEntity<?> addServiceCategory(@RequestBody ServiceCategory serviceCategory) {//String body) {
	       // categoryService.addCategory(category);
	    	ServiceCategoryAddResponse response = new ServiceCategoryAddResponse();
	    	try {
	    		
	    		//Validation
	    		ServiceCategory temp=serviceCategoryService.save(serviceCategory);
	    		response.setServiceCategory(temp);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, add ServiceCategory request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, add ServiceCategory request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, add ServiceCategory request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }
	//Get ServiceCategory List
	@ApiOperation(value = "get all service category ", nickname = "get all service category")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = ServiceCategory.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	   @RequestMapping(path = "/all", method = RequestMethod.GET)
	    public ResponseEntity<?> getAllServiceCategorys() {

	    	ServiceCategoryListResponse response = new ServiceCategoryListResponse();
	    	try {
	    		List<ServiceCategory> ServiceCategorys = serviceCategoryService.getAllServiceCategory();
	    		response.setCategories(ServiceCategorys);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, get all ServiceCategorys request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, get all ServiceCategorys request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				ex.printStackTrace();
				log.error("[NTG_LOG_START] 500, get all ServiceCategorys request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }
	   
	   
//Update ServiceCategory
	@ApiOperation(value = "update service category ", nickname = "update service category")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = ServiceCategory.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	   @RequestMapping(path = "/update", method = RequestMethod.POST)
	    public ResponseEntity<?> updateServiceCategory(@RequestBody ServiceCategory ServiceCategory) {
	        //categoryService.updateCategory(category);
	    	ServiceCategoryUpdateResponse response = new ServiceCategoryUpdateResponse();
	    	try {
	    		serviceCategoryService.update(ServiceCategory.getId(), ServiceCategory);
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, update ServiceCategory request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				e.printStackTrace();
				log.info("[NTG_LOG_START] 400, update ServiceCategory request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				ex.printStackTrace();
				log.error("[NTG_LOG_START] 500, update ServiceCategory request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }

	   //Delete ServiceCategory
	@ApiOperation(value = "delete service category ", nickname = "delete service category")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = ServiceCategory.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	   @ResponseBody
	   @RequestMapping(path = "/delete", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	    public ResponseEntity<?> deleteServiceCategory(@RequestBody Integer id,HttpServletRequest request)//@RequestBody Category category) {
	    {
	    	//
	    	ServiceCategoryUpdateResponse response = new ServiceCategoryUpdateResponse();
	    	try {	    		
	    		ServiceCategory comp = new ServiceCategory();
	    		comp.setId(new Long(id));
	    		comp.setUpdatedBy("");//TODO enter user;
	    		comp.setUpdatedAt(new Date());
	    		serviceCategoryService.delete(comp);
	    		
	    		response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
				log.info("[NTG_LOG_START] 200 OK, Delete ServiceCategory request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (ApplicationException e) {
				log.info("[NTG_LOG_START] 400, Delete ServiceCategory request failed with error: ("
						+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
			} catch (Exception ex) {
				log.error("[NTG_LOG_START] 500, Delete ServiceCategory request failed with error: ("
						+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
				return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	
	    }

	   //getOne ServiceCategory
	@ApiOperation(value = "get service category  by id", nickname = "get service category by id")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = ServiceCategory.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	   @RequestMapping (path = "/service/{id}",method = RequestMethod.GET)
    public ServiceCategory getOneServiceCategory(@PathVariable("id")Long id) {
        return serviceCategoryService.getOneServiceCategory(id);
    }
}
