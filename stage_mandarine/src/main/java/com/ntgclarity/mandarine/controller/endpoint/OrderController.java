//<<<<<<< HEAD
//package com.ntgclarity.mandarine.controller.endpoint;
//
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ntgclarity.mandarine.constants.CodesAndMessages;
//import com.ntgclarity.mandarine.dto.OrderDto;
//import com.ntgclarity.mandarine.dto.StatusResponse;
//import com.ntgclarity.mandarine.dto.Order.AddOrderDto;
//import com.ntgclarity.mandarine.entity.Orders;
//import com.ntgclarity.mandarine.entity.Service;
//import com.ntgclarity.mandarine.exception.ApplicationException;
//import com.ntgclarity.mandarine.mapper.OrderMapper;
//import com.ntgclarity.mandarine.model.MessageResponse;
//import com.ntgclarity.mandarine.model.OrderAddResponse;
//import com.ntgclarity.mandarine.model.OrderListResponse;
//import com.ntgclarity.mandarine.service.OrderService;
//import com.ntgclarity.mandarine.service.ServiceService;
//import com.ntgclarity.mandarine.util.Utils;
//
//@CrossOrigin
//@RestController
//@RequestMapping(path = "/api/v1/order", produces = "application/json")
//public class OrderController {
//	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
//	@Autowired
//	OrderService orderService;
//
//	@Autowired
//	ServiceService serviceService;
//	@Autowired
//	OrderMapper mapper;
//	// @RequestMapping(path = "/add", method = RequestMethod.POST)
//	// public ResponseEntity<?> addOrder(@RequestBody Orders order) {
//	//
//	// OrderAddResponse response = new OrderAddResponse();
//	// Service service =new Service();
//	// service.setName("test");
//	// service.setSuspensionFees(new BigInteger("100"));
//	// service.setDeliveryFees(new BigInteger("100"));
//	// serviceService.save(service);
//	//
//	// try {
//	// if (!orderService.valid(order)) {
//	// throw new ApplicationException("400", "Order all attributes are
//	// requirded");
//	// } else {
//	// order.setServiceid(service);
//	// orderService.save(order);
//	// ArrayList<Orders> orders=new ArrayList<>();
//	// orders.add(order);
//	// service.setOrdersCollection(orders);
//	// response.setMessageResponseObj(
//	// new MessageResponse(CodesAndMessages.NO_ERRORS_CODE,
//	// CodesAndMessages.NO_ERRORS_MESSAGE));
//	// response.setOrders(order);
//	// log.info("[NTG_LOG_START] 200 OK, add Order request succeeded
//	// [NTG_LOG_END]");
//	// return new ResponseEntity<>(response, HttpStatus.OK);
//	// }
//	//
//	// } catch (ApplicationException e) {
//	// e.printStackTrace();
//	// log.info("[NTG_LOG_START] 400, add Order request failed with error: ("
//	// + Utils.buildErrorMessage(e.getStatus()).getMessage() + ")
//	// [NTG_LOG_END]");
//	// return new
//	// ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()),
//	// HttpStatus.BAD_REQUEST);
//	// } catch (Exception ex) {
//	// ex.printStackTrace();
//	// log.error("[NTG_LOG_START] 500, add Order request failed with error: ("
//	// + Utils.internalServerError(ex.getMessage()).getMessage() + ")
//	// [NTG_LOG_END]");
//	// return new
//	// ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
//	// HttpStatus.INTERNAL_SERVER_ERROR);
//	// }
//	// }
//
//	@RequestMapping(path = "/add", method = RequestMethod.POST)
//	public ResponseEntity<?> addOrder(@RequestBody AddOrderDto addOrderDto) {
//
//		OrderAddResponse response = new OrderAddResponse();
//
//		try {
//			if (!orderService.valid(addOrderDto)) {
//				throw new ApplicationException("400", "Order all attributes are requirded");
//			} else {
//				Orders order = mapper.toOrders(addOrderDto);
//				response.setMessageResponseObj(
//						new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
//				response.setOrders(order);
//				log.info("[NTG_LOG_START] 200 OK, add Order request succeeded [NTG_LOG_END]");
//				return new ResponseEntity<>(response, HttpStatus.OK);
//			}
//
//		} catch (ApplicationException e) {
//			e.printStackTrace();
//			log.info("[NTG_LOG_START] 400, add Order request failed with error: ("
//					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
//			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			log.error("[NTG_LOG_START] 500, add Order request failed with error: ("
//					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
//			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@RequestMapping(path = "/all", method = RequestMethod.GET)
//	public ResponseEntity<?> getAll() {
//		OrderListResponse response = new OrderListResponse();
//		try {
//			List<OrderDto> orders = orderService.getAllOrders();
//			response.setOrderDtos(orders);
//			response.setMessageResponseObj(
//					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
//			log.info("[NTG_LOG_START] 200 OK, get all order request succeeded [NTG_LOG_END]");
//			return new ResponseEntity<>(response, HttpStatus.OK);
//		} catch (ApplicationException e) {
//			log.info("[NTG_LOG_START] 400, get all order request failed with error: ("
//					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
//			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			log.error("[NTG_LOG_START] 500, get all order request failed with error: ("
//					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
//			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//}
//=======
package com.ntgclarity.mandarine.controller.endpoint;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ntgclarity.mandarine.constants.CodesAndMessages;
import com.ntgclarity.mandarine.dto.OrderDto;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.dto.Order.AddOrderDto;
import com.ntgclarity.mandarine.entity.Modifyreason;
import com.ntgclarity.mandarine.entity.Orders;
import com.ntgclarity.mandarine.entity.Service;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.mapper.OrderMapper;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.model.OrderAddResponse;
import com.ntgclarity.mandarine.model.OrderListResponse;
import com.ntgclarity.mandarine.service.OrderService;
import com.ntgclarity.mandarine.service.ServiceService;
import com.ntgclarity.mandarine.util.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/order", produces = "application/json")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    OrderService orderService;

    @Autowired
    ServiceService serviceService;
    @Autowired
    OrderMapper mapper;
    // @RequestMapping(path = "/add", method = RequestMethod.POST)
    // public ResponseEntity<?> addOrder(@RequestBody Orders order) {
    //
    // OrderAddResponse response = new OrderAddResponse();
    // Service service =new Service();
    // service.setName("test");
    // service.setSuspensionFees(new BigInteger("100"));
    // service.setDeliveryFees(new BigInteger("100"));
    // serviceService.save(service);
    //
    // try {
    // if (!orderService.valid(order)) {
    // throw new ApplicationException("400", "Order all attributes are
    // requirded");
    // } else {
    // order.setServiceid(service);
    // orderService.save(order);
    // ArrayList<Orders> orders=new ArrayList<>();
    // orders.add(order);
    // service.setOrdersCollection(orders);
    // response.setMessageResponseObj(
    // new MessageResponse(CodesAndMessages.NO_ERRORS_CODE,
    // CodesAndMessages.NO_ERRORS_MESSAGE));
    // response.setOrders(order);
    // log.info("[NTG_LOG_START] 200 OK, add Order request succeeded
    // [NTG_LOG_END]");
    // return new ResponseEntity<>(response, HttpStatus.OK);
    // }
    //
    // } catch (ApplicationException e) {
    // e.printStackTrace();
    // log.info("[NTG_LOG_START] 400, add Order request failed with error: ("
    // + Utils.buildErrorMessage(e.getStatus()).getMessage() + ")
    // [NTG_LOG_END]");
    // return new
    // ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()),
    // HttpStatus.BAD_REQUEST);
    // } catch (Exception ex) {
    // ex.printStackTrace();
    // log.error("[NTG_LOG_START] 500, add Order request failed with error: ("
    // + Utils.internalServerError(ex.getMessage()).getMessage() + ")
    // [NTG_LOG_END]");
    // return new
    // ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
    // HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "add order dto ", nickname = "add oderdto")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = AddOrderDto.class)
        ,
            @ApiResponse(code = 401, message = "Unauthorized")
        ,
            @ApiResponse(code = 403, message = "Forbidden")
        ,
            @ApiResponse(code = 404, message = "Not Found")
        ,
            @ApiResponse(code = 500, message = "Failure")})
    public ResponseEntity<?> addOrder(@RequestBody AddOrderDto addOrderDto) {

        OrderAddResponse response = new OrderAddResponse();

        try {
            if (!orderService.valid(addOrderDto)) {
                throw new ApplicationException("400", "Order all attributes are requirded");
            } else {
                Orders order = mapper.toOrders(addOrderDto);
                response.setMessageResponseObj(
                        new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
                response.setOrders(order);
                log.info("[NTG_LOG_START] 200 OK, add Order request succeeded [NTG_LOG_END]");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

        } catch (ApplicationException e) {
            e.printStackTrace();
            log.info("[NTG_LOG_START] 400, add Order request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("[NTG_LOG_START] 500, add Order request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "get all order dto ", nickname = "get all oderdto")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = AddOrderDto.class)
        ,
            @ApiResponse(code = 401, message = "Unauthorized")
        ,
            @ApiResponse(code = 403, message = "Forbidden")
        ,
            @ApiResponse(code = 404, message = "Not Found")
        ,
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        OrderListResponse response = new OrderListResponse();
        try {
            List<OrderDto> orders = orderService.getAllOrders();
            response.setOrderDtos(orders);
            response.setMessageResponseObj(
                    new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
            log.info("[NTG_LOG_START] 200 OK, get all order request succeeded [NTG_LOG_END]");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            log.info("[NTG_LOG_START] 400, get all order request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("[NTG_LOG_START] 500, get all order request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
//>>>>>>> origin/master
