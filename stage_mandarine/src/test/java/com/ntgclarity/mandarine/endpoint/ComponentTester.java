/**
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER. Copyright 1997-2016 NTG Clarity and/or its affiliates. All
* rights reserved. NTG CLARITY is a leader in delivering network, telecom, IT and infrastructure solutions to network
* service providers and medium and large enterprises. www.ntgclarity.com The contents of this file are subject to the
* terms of "NTG Clarity License". You must not use this file except in compliance with the License. You can obtain a
* copy of the License at http://www.ntgclarity.com/ See the License for the specific language governing permissions and
* limitations under the License. Contributor(s): The Initial Developer of the Original Software is NTG Clarity . , Inc.
* Copyright 1997-2016 NTG Clarity. All Rights Reserved. CLASS NAME
* <h4>Description</h4>
* <h4>Notes</h4>
* <h4>References</h4>
* 
 * @author: mandarineDeveloper <A HREF="mailto:hr@ntgclarity.com">mandarine Development Team</A>
* @version Revision: 1.0 Date: 12/10/16 10:22 AM
* @see [String]
* @see [URL]
* @see [Class name#method name]
*/

package com.ntgclarity.mandarine.endpoint;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
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
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.ntgclarity.mandarine.config.ApplicationContextTest;
import com.ntgclarity.mandarine.controller.endpoint.CategoryController;
import com.ntgclarity.mandarine.controller.endpoint.ComponentController;
import com.ntgclarity.mandarine.controller.endpoint.ServiceController;
import com.ntgclarity.mandarine.dto.ServiceDto;
import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.entity.Service;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.model.CategoryAddResponse;
import com.ntgclarity.mandarine.model.ServiceAddResponse;
import com.ntgclarity.mandarine.model.ComponentServices.ComponentAddResponse;
import com.ntgclarity.mandarine.service.CategoryService;
import com.ntgclarity.mandarine.service.ServiceService;
import com.ntgclarity.mandarine.service.componentService;

@TransactionConfiguration(defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContextTest.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class ComponentTester {

	@Autowired
	ComponentController componentController;
	@Autowired
	componentService componentService;
	@Autowired
	CategoryController categoryController;
	@Autowired
	ServiceController serviceController;
	@Autowired
	ServiceService serviceService;

	@BeforeClass
	public static void setUp() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	// ADD Service Test
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Component.xml")
	public void testAddComponentService() {
		Component component = new Component();
		component.setName("Test Component");
		component.setNrc(new BigInteger("5"));
		int currentLength = componentService.getAllComponent().size();
		componentService.addComponent(component);
		int newLength = componentService.getAllComponent().size();
		assertEquals(newLength, currentLength + 1);
	}

	// ADD ControllerTest
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Component.xml")
	public void testAddComponentController() {
		Component component = new Component();
		component.setName("Test Component");
		component.setNrc(new BigInteger("5"));
		ResponseEntity com = componentController.addComponent(component);
		assert (com.getStatusCode().is2xxSuccessful());
	}

	// Edit Service Test
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Component.xml")
	public void testEditComponentService() {
		String modifiedName = "New Component";
		Component component = componentService.addComponent(new Component());
		component.setName(modifiedName);
		componentService.updateComponent(component);
		Component component2 = componentService.getOneComponent(component.getId());
		assertEquals(modifiedName, component2.getName());
	}

	// Edit ControllerTest
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Component.xml")
	public void testEditComponentController() {
		Component component = componentService.addComponent(new Component());
		component.setName("Test Component");
		component.setNrc(new BigInteger("7"));
		ResponseEntity com = componentController.updateComponent(component);
		assert (com.getStatusCode().is2xxSuccessful());
	}

	// Delete Service Test
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Component.xml")
	public void testDeleteComponentService() {
		Component component = componentService.addComponent(new Component());
		int currentLength = componentService.getAllComponent().size();
		componentService.delete(component);
		int newLength = componentService.getAllComponent().size();
		assertEquals(newLength, currentLength - 1);
	}

	// Delete ControllerTest
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Component.xml")
	public void testDeleteComponentController() {
		ResponseEntity com = componentController.addComponent(new Component());
		Long id = ((ComponentAddResponse) com.getBody()).getComponentID();
		ResponseEntity com2 = componentController.deleteComponent(id.intValue(), null);
		assert (com2.getStatusCode().is2xxSuccessful());
	}

	// Delete ControllerTest with not existed ID
	@Test // (expected= ApplicationException.class)
	@Transactional
	@DatabaseSetup("/datasets/Component.xml")
	public void testDeleteNoIdComponentController() {
		ResponseEntity com = componentController.deleteComponent(-1, null);
		assert (com.getStatusCode().is4xxClientError());
	}

	// Delete ControllerTest with Categorey
	@Test // (expected= ApplicationException.class)
	@Transactional
	@DatabaseSetup("/datasets/Component.xml")
	public void testDeleteWithCategoreyComponentController() {
		Category tempcat = new Category();
		tempcat.setName("test");
		tempcat.setType("test");
		ResponseEntity cate = categoryController.addCategory(tempcat);
		Category catObject = ((CategoryAddResponse) cate.getBody()).getCategory();
		Component comp = componentService.addComponent(new Component());
		Collection<Component> componentCollection = new ArrayList<>();
		componentCollection.add(comp);
		catObject.setComponentCollection(componentCollection);
		categoryController.updateCategory(catObject);
		ResponseEntity com = componentController.deleteComponent(comp.getId().intValue(), null);
		assert (com.getStatusCode().is2xxSuccessful());
	}

	// Delete ControllerTest with Service
	@Test // (expected= ApplicationException.class)
	@Transactional
	@DatabaseSetup("/datasets/Component.xml")
	public void testDeleteWithServiceComponentController() {
		Service tempser = new Service();
		tempser.setName("test");
		tempser.setType("test");
		ResponseEntity service = serviceController.addService(tempser);
		ServiceDto serviceObject = ((ServiceAddResponse) service.getBody()).getService();
		Service Obj = serviceService.getServiceById(serviceObject.getId());
		Component comp = componentService.addComponent(new Component());
		int id = comp.getId().intValue();
		Collection<Service> serviceCollection = new ArrayList<>();
		serviceCollection.add(tempser);
		comp.setServiceCollection(serviceCollection);
		componentController.updateComponent(comp);
		ResponseEntity com = componentController.deleteComponent(id, null);
		assert (com.getStatusCode().is4xxClientError());
	}

}