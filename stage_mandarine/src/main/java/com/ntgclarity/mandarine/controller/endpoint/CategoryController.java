/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.controller.endpoint;

import java.util.ArrayList;
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
import com.ntgclarity.mandarine.dto.CategoryDTO;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.entity.Modifyreason;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.CategoryAddResponse;
import com.ntgclarity.mandarine.model.CategoryListResponse;
import com.ntgclarity.mandarine.model.CategoryUpdateResponse;
import com.ntgclarity.mandarine.model.MessageResponse;
import com.ntgclarity.mandarine.service.CategoryService;
import com.ntgclarity.mandarine.util.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 *
 * @author Sheko
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/category", produces = "application/json")
public class CategoryController {

	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	CategoryService categoryService;
	
	@ApiOperation(value = "add category   ", nickname = "add category ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Category.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addCategory(@RequestBody Category category) {// String
																			// body)
																			// {
		// categoryService.addCategory(category);
		CategoryAddResponse response = new CategoryAddResponse();
		try {
			// Validation
			if (category.getName().trim().isEmpty() || category.getType().trim().isEmpty())
				throw new ApplicationException("400", "category name and type are required");
			Category temp=categoryService.save(category);
			response.setCategory(temp);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, add Category request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			e.printStackTrace();
			log.info("[NTG_LOG_START] 400, add Category request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			log.error("[NTG_LOG_START] 500, add Category request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "get all categories  ", nickname = "show all categories ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Category.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAllCategory() {
		CategoryListResponse response = new CategoryListResponse();
		try {
			List<Category> categories = categoryService.getAllCategories();
			List<CategoryDTO> catgoriesdto=new ArrayList<>();
			for (Category category : categories) {
				catgoriesdto.add(new CategoryDTO(category));
			}
			response.setCategoriesDTO(catgoriesdto);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, get all categories request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, get all categories request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			
			log.error("[NTG_LOG_START] 500, get all categories request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation(value = "show all name of categories   ", nickname = "show all categories names ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Category.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(path = "/allnames", method = RequestMethod.GET)
	public ResponseEntity<?> getAllCategorynames() {
		CategoryListResponse response = new CategoryListResponse();
		try {
			List<Category> categories = categoryService.getAllCategoriesName();
			List<CategoryDTO> catgoriesdto=new ArrayList<>();
			for (Category category : categories) {
				catgoriesdto.add(new CategoryDTO(category));
			}
			response.setCategoriesDTO(catgoriesdto);
			
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, get all categories request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, get all categories request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			
			log.error("[NTG_LOG_START] 500, get all categories request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@ApiOperation(value = "update category   ", nickname = "update category ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Category.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateCategory(@RequestBody Category category) {
		// categoryService.updateCategory(category);
		CategoryUpdateResponse response = new CategoryUpdateResponse();
		try {
			if (category.getName().trim().isEmpty() || category.getType().trim().isEmpty())
				throw new ApplicationException("400", "category name and type are required");
			categoryService.update(category.getId(), category);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, update Category request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, update Category request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			log.error("[NTG_LOG_START] 500, update Category request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@ApiOperation(value = "delete category  ", nickname = "delete category")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Category.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	@ResponseBody
	@RequestMapping(path = "/delete", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public ResponseEntity<?> deleteCategory(@RequestBody Long id, HttpServletRequest request)// @RequestBody
																								// Category
																								// category)
																								// {
	{
		//
		CategoryUpdateResponse response = new CategoryUpdateResponse();
		try {

			Category cat = new Category();
			cat.setId(id);
			cat.setUpdatedBy("");// TODO enter user;
			cat.setUpdatedAt(new Date());
			categoryService.deleteCategory(cat);
			response.setMessageResponseObj(
					new MessageResponse(CodesAndMessages.NO_ERRORS_CODE, CodesAndMessages.NO_ERRORS_MESSAGE));
			log.info("[NTG_LOG_START] 200 OK, update Category request succeeded [NTG_LOG_END]");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApplicationException e) {
			log.info("[NTG_LOG_START] 400, update Category request failed with error: ("
					+ Utils.buildErrorMessage(e.getStatus()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.buildErrorMessage(e.getStatus()), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			log.error("[NTG_LOG_START] 500, update Category request failed with error: ("
					+ Utils.internalServerError(ex.getMessage()).getMessage() + ") [NTG_LOG_END]");
			return new ResponseEntity<StatusResponse>(Utils.internalServerError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@ApiOperation(value = "select one category   ", nickname = "show one category")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Category.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(path = "/selectOne", method = RequestMethod.POST)
	public Category selectOneCategory(@RequestBody String id) {
		// System.out.println(id);
		return categoryService.getOneCategory(Long.parseLong(id));
	}
	
	@ApiOperation(value = "get all components in a category   ", nickname = "show all components in one category  ")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Category.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	
	@RequestMapping(path = "/Category/{id}", method = RequestMethod.GET)
	public List<Component> getAllComponents(@PathVariable Long id) {
		System.out.println(id);
		return categoryService.getAllComponents(id);
		
	}
	
	
}