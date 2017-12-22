package com.ntgclarity.mandarine.controller.endpoint;

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
import org.springframework.web.bind.annotation.RestController;

import com.ntgclarity.mandarine.constants.CodesAndMessages;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.entity.Servicetype;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.model.ServiceTypeAddResponse;
import com.ntgclarity.mandarine.model.ServiceTypeDeleteResponse;
import com.ntgclarity.mandarine.model.ServiceTypeListResponse;
import com.ntgclarity.mandarine.model.ServiceTypeUpdateResponse;
import com.ntgclarity.mandarine.service.ServiceTypeService;
import com.ntgclarity.mandarine.util.Utils;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/serviceType", produces = "application/json")
public class ServiceTypeController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    ServiceTypeService serviceTypeService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        ServiceTypeListResponse response = new ServiceTypeListResponse();
        try {
            response.setServicetypes(serviceTypeService.getAll());
            response.setMessageResponseObj(
                    new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
            log.info("[NTG_LOG_START] 200 OK, get all Service Type request succeeded [NTG_LOG_END]");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            log.info("[NTG_LOG_START] 400, get all Serivc Type request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {

            log.error("[NTG_LOG_START] 500, get all Service Type request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Servicetype serviceType) {
        ServiceTypeAddResponse response = new ServiceTypeAddResponse();
        try {
            if (serviceType.getServiceType().trim().isEmpty()) {
                throw new ApplicationException("400", "service type is required");
            }
            serviceTypeService.save(serviceType);
            response.setServicetype(serviceType);
            response.setMessageResponseObj(
                    new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
            log.info("[NTG_LOG_START] 200 OK, get all Service Type request succeeded [NTG_LOG_END]");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            log.info("[NTG_LOG_START] 400, add Serivc Type request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {

            log.error("[NTG_LOG_START] 500, add Service Type request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody Servicetype serviceType) {
        ServiceTypeUpdateResponse response = new ServiceTypeUpdateResponse();
        try {
            if (serviceType.getServiceType().trim().isEmpty()) {
                throw new ApplicationException("400", "service type is required");
            }

            serviceTypeService.update(serviceType.getId(), serviceType);
            response.setServicetype(serviceType);
            response.setMessageResponseObj(
                    new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
            log.info("[NTG_LOG_START] 200 OK, update Service Type request succeeded [NTG_LOG_END]");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            log.info("[NTG_LOG_START] 400, update Serivc Type request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {

            log.error("[NTG_LOG_START] 500, update Service Type request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ServiceTypeDeleteResponse response = new ServiceTypeDeleteResponse();
        try {
            serviceTypeService.delete(id);
            response.setMessageResponseObj(
                    new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
            log.info("[NTG_LOG_START] 200 OK, update Service Type request succeeded [NTG_LOG_END]");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ApplicationException e) {
            log.info("[NTG_LOG_START] 400, update Serivc Type request failed with error: ("
                    + Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {

            log.error("[NTG_LOG_START] 500, update Service Type request failed with error: ("
                    + Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
            return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
