/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.endpoint;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.ntgclarity.mandarine.config.ApplicationContextTest;
import com.ntgclarity.mandarine.controller.endpoint.CategoryController;
import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.service.CategoryService;
import com.ntgclarity.mandarine.service.componentService;

/**
 *
 * @author yasmeen
 */

@TransactionConfiguration(defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContextTest.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class CategoryTester {

	@Autowired
	CategoryService categoryService;
	@Autowired
	CategoryController categoryController;
	@Autowired
	componentService componentService;
	@BeforeClass
	public static void setUp() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	// add category test
	@Test
	@Transactional
	public void testAddCategoryService() {
		Category category = new Category();
		category.setName("Category1");
		category.setType("type1");
		int numberOfCategories = categoryService.getAllCategories().size();
		categoryService.addCategory(category);
		int numberOfCategories2 = categoryService.getAllCategories().size();
		assertEquals(numberOfCategories2, ++numberOfCategories);
	}

	@Test
	@Transactional
	public void testAddCategoryController() {
		Category category = new Category();
		category.setName("Category1");
		category.setType("type1");
		ResponseEntity response = categoryController.addCategory(category);
		assert (response.getStatusCode().is2xxSuccessful());
	}

	@Test
	@Transactional
	public void testEditCategoryService() {
		Category category = new Category();
		category.setName("category1");
		category.setType("type1");
		categoryService.addCategory(category);
		category.setName("edited category");
		categoryService.updateCategory(category);
		Category category2 = categoryService.getOneCategory(category.getId());
		assertEquals("edited category", category2.getName());
	}

	@Test
	@Transactional
	public void testEditCategoryController() {
		Category category = new Category();
		category.setName("category1");
		category.setType("type1");
		categoryService.addCategory(category);
		category.setName("edited category");
		ResponseEntity response = categoryController.updateCategory(category);
		assert (response.getStatusCode().is2xxSuccessful());
	}

	@Test
	@Transactional
	public void testDeleteCategoryService() {
		Category category = new Category();
		category.setName("category1");
		category.setType("type1");
		categoryService.addCategory(category);
		int currentLength = categoryService.getAllCategories().size();
		categoryService.delete(category);
		int newLength = categoryService.getAllCategories().size();
		assertEquals(newLength, currentLength - 1);
	}

	@Test
	@Transactional
	public void testDeleteCategoryController() {
		Category category = new Category();
		category.setName("category1");
		category.setType("type1");
		categoryService.addCategory(category);
		int currentLength = categoryService.getAllCategories().size();
		categoryController.deleteCategory(category.getId(), null);
		int newLength = categoryService.getAllCategories().size();
		assertEquals(newLength, currentLength - 1);
	}
	@Test
	@Transactional
	public void testGetAllComponentsController()
	{
		Category category = new Category();
		Collection<Component> componentList = new ArrayList<>();
		Component component = componentService.addComponent(new Component());
		componentList.add(component);
        category.setName("category1");
		category.setType("type1");
		category.setComponentCollection(componentList);
		categoryService.addCategory(category);
		int newLength = categoryController.getAllComponents(category.getId()).size();
		assertEquals(newLength, 1);
	}

}
