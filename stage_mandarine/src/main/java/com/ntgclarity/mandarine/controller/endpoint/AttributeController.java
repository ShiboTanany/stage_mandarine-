/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.controller.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ntgclarity.mandarine.entity.Attribute;
import com.ntgclarity.mandarine.entity.Modifyreason;
import com.ntgclarity.mandarine.service.AttributeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 *
 * @author Sheko
 */
@CrossOrigin()
@RestController
@RequestMapping(path = "/api/v1/attribute", produces = "application/json")
public class AttributeController {

    @Autowired
    AttributeService attributeService;

    @ApiOperation(value = "add attribute   ", nickname = "add attribute ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Attribute.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public void addAttribue(@RequestBody Attribute attribute) {
        attributeService.addAttribute(attribute);
    }

    @ApiOperation(value = "show all attributes   ", nickname ="show all attributes" )
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Attribute.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Attribute> getAllAttributes() {
        return attributeService.getAllAttributes();
    }

    @ApiOperation(value = "update attribute   ", nickname = "update attribute ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Attribute.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public void updateAttribute(@RequestBody Attribute attribute) {
        attributeService.updateAttribute(attribute);
    }

    @ApiOperation(value = "delete attribute ", nickname = "delete attribute ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Attribute.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public void deleteAttribute(@RequestBody Attribute attribute) {
        attributeService.deleteAttribute(attribute);
    }
    
    @ApiOperation(value = "select one attribute   ", nickname = "select one attribute ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Attribute.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(path = "/selectOne", method = RequestMethod.POST)
    public Attribute getOneAttribute(Long id)
    {
        return attributeService.getOneAttribute(id);
    }
}
