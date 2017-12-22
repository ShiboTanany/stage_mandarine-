package com.ntgclarity.mandarine.controller.endpoint;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import com.ntgclarity.mandarine.dto.ServiceDto;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.entity.Service;
import com.ntgclarity.mandarine.entity.ServiceCategory;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.CategoryAddResponse;
import com.ntgclarity.mandarine.model.CategoryListResponse;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.model.ServiceAddResponse;
import com.ntgclarity.mandarine.model.ServiceDeleteResponse;
import com.ntgclarity.mandarine.model.ServiceListResponse;
import com.ntgclarity.mandarine.repository.ServiceRepository;
import com.ntgclarity.mandarine.service.ServiceService;
import com.ntgclarity.mandarine.util.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/Service", produces = "application/json")
@CrossOrigin
public class ServiceController {

	@Autowired
	ServiceService serviceService;

	private static final Logger log = LoggerFactory.getLogger(ServiceController.class);

	
	@ApiOperation(value = "add service  ", nickname = "add service ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Service.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addService(@RequestBody Service service) {

		ServiceAddResponse response = new ServiceAddResponse();

		try {

			// Validation
			if (service.getName().trim().isEmpty() || service.getType().trim().isEmpty()){
				throw new ApplicationException("400", "Service name and type are required");}
			else{
			serviceService.addService(service);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			response.setServiceDTO(new ServiceDto(service));
			log.info("[NTG_LOG_START] 200 OK, add Service request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);}
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, add Service request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error("[NTG_LOG_START] 500, add Service request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@ApiOperation(value = "delete service  ", nickname = "delete service ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Service.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public ResponseEntity<?> deleteService(@RequestBody Long id) {

		ServiceDeleteResponse response = new ServiceDeleteResponse();
		try {

			// Validation
			Service service = serviceService.getServiceById(id);

			if (service != null) {

				serviceService.delete(id);
				response.setMessageResponseObj(
						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));

				log.info("[NTG_LOG_START] 200 OK, add Service request succeeded [NTG_LOG_END]");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				throw new ApplicationException("400", "service id is not exist");

			}
		} catch (ApplicationException e) {
			e.printStackTrace();
			log.info("[NTG_LOG_START] 400, add Service request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			log.error("[NTG_LOG_START] 500, add Service request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// serviceService.deleteService(service);
	}

	@ApiOperation(value = "update service  ", nickname = "update service ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Service.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateService(@RequestBody Service service) {
		ServiceAddResponse response = new ServiceAddResponse();

		try {

			// Validation
			if (service.getName().trim().isEmpty() || service.getType().trim().isEmpty())
				throw new ApplicationException("400", "category name and type are required");
			serviceService.updateService( service);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			response.setServiceDTO(new ServiceDto(service));
			log.info("[NTG_LOG_START] 200 OK, add Service request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			e.printStackTrace();
			log.info("[NTG_LOG_START] 400, add Service request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error("[NTG_LOG_START] 500, add Service request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(path = "/getAll", method = RequestMethod.GET)
	@ApiOperation(value = "get all services  ", nickname = "get all services ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Service.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	public ResponseEntity<?> getAllService() {

		ServiceListResponse response = new ServiceListResponse();
		try {
			List<Service> services = serviceService.getAllService();
			List<ServiceDto> servicesDTO = new ArrayList<>();
			for (Service service2 : services) {
				servicesDTO.add(new ServiceDto(service2));
			}
			response.setServiceDtos(servicesDTO);

			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, get all Services request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, get all Services request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR MESSAGE IS " + ex.getMessage());
			log.error("[NTG_LOG_START] 500, get all Services request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@ApiOperation(value = "get  service  by id ", nickname = "get service by id ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Service.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(path = "/service", method = RequestMethod.POST)
	public ResponseEntity<?> getServiceById(@RequestBody Long id) {
		ServiceAddResponse response = new ServiceAddResponse();
		
		try {

			// Validation
			if (id==null)
				throw new ApplicationException("400", "category name and type are required");
			
			Service service=serviceService.getServiceById(id);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			response.setServiceDTO(new ServiceDto(service));
			log.info("[NTG_LOG_START] 200 OK, search Service request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			e.printStackTrace();
			log.info("[NTG_LOG_START] 400, search Service request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			log.error("[NTG_LOG_START] 500, search Service request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
	}

}
