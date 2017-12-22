package com.ntgclarity.mandarine.controller.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ntgclarity.mandarine.constants.CodesAndMessages;
import com.ntgclarity.mandarine.dto.StatsticsDto;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.InfoResponse;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.service.CategoryService;
import com.ntgclarity.mandarine.service.OrderService;
import com.ntgclarity.mandarine.service.ServiceService;
import com.ntgclarity.mandarine.service.componentService;
import com.ntgclarity.mandarine.util.Utils;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/home", produces = "application/json")
public class HomePageController {

	@Autowired
	componentService componentService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	OrderService orderService;
	@Autowired
	ServiceService serviceService;

	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

	@RequestMapping(path = "/info", produces = "application/json",method=RequestMethod.GET)
	public ResponseEntity<?> getInfo() {
		InfoResponse infoResponse = new InfoResponse();
		try {
			StatsticsDto statsticsDto = new StatsticsDto();
			statsticsDto.setTotalServices(serviceService.totalCount());
			statsticsDto.setTotalComponent(componentService.totalCount());
			statsticsDto.setTotalOrder(orderService.totalCount());
			statsticsDto.setTotalCategory(categoryService.totalCount());
			infoResponse.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			infoResponse.setStatsticsDto(statsticsDto);
			log.info("[NTG_LOG_START] 200 OK, all HomePage request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(infoResponse, HttpStatus.OK);
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, get all HomePage request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {

			log.error("[NTG_LOG_START] 500, get all HomePage request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
