package com.ntgclarity.mandarine.endpoint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.entity.Service;
import com.ntgclarity.mandarine.service.ServiceService;
import com.ntgclarity.mandarine.service.componentService;

@TransactionConfiguration(defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContextTest.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class ServiceTester {

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

	//
	@BeforeClass
	public static void setUp() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}
	//

	// ADD Service Test service
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Service.xml")
	public void testAddService() {
		Service service = new Service();
		service.setDeliveryDays(new BigInteger("525"));
		service.setType("test");
		service.setTerminationFees(new BigInteger("87"));
		Service service2 = new Service();
		service2.setDeliveryDays(new BigInteger("525"));
		service2.setType("test");
		service2.setTerminationFees(new BigInteger("87"));
		int currentLength = serviceService.getAllService().size();
		serviceService.addService(service);
		serviceService.addService(service2);
		int x = serviceService.getAllService().size();
		x = x - 2;
		assertEquals(x, currentLength);

	}

	// ADD Service Test controller
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Service.xml")
	public void testAddServiceCOntroller() {

		Service service2 = new Service();
		service2.setDeliveryDays(new BigInteger("525"));
		service2.setType("test");
		service2.setId(new Long("55"));
		service2.setName("dsds");
		service2.setTerminationFees(new BigInteger("87"));

		ResponseEntity com2 = serviceController.addService(service2);
		// System.out.println(com2.getStatusCode().is5xxServerError());

		assert (com2.getStatusCode().is2xxSuccessful());

	}
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Service.xml")
	public void testAddServiceCOntrollerWithoutComponent() {

		Service service2 = new Service();
		service2.setDeliveryDays(new BigInteger("525"));
		service2.setType("test");
		service2.setId(new Long("55"));
		service2.setName("dsds");
		service2.setTerminationFees(new BigInteger("87"));
		
		Component component = new Component();
		component.setName("Test Component");
		component.setNrc(new BigInteger("5"));
		List<Component> lis=new ArrayList<>();
		lis.add(component);
		
		service2.setComponentCollection(lis);

		ResponseEntity com2 = serviceController.addService(service2);
		// System.out.println(com2.getStatusCode().is5xxServerError());

		assert (com2.getStatusCode().is5xxServerError());

	}
	
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Service.xml")
	public void testAddServiceCOntrollerWithoutName() {

		Service service2 = new Service();
		service2.setDeliveryDays(new BigInteger("525"));
		service2.setType("test");
		service2.setId(new Long("55"));
		
		service2.setTerminationFees(new BigInteger("87"));

		ResponseEntity com2 = serviceController.addService(service2);
		// System.out.println(com2.getStatusCode().is5xxServerError());

		assert (com2.getStatusCode().is5xxServerError());

	}
	
	// Edit Service Test Service
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Service.xml")
	public void testEditService() {
		String modifiedName = "New Service b2a";
		Service service2 = new Service();
		service2.setDeliveryDays(new BigInteger("525"));
		service2.setType("test");
		
		service2.setName("dsds");
		service2.setTerminationFees(new BigInteger("87"));
		

		
		Service service = serviceService.addService(service2);
		
		Service service1 = serviceService.getServiceById(service.getId());
		service1.setName(modifiedName);
		Service service4= serviceService.getServiceById(service.getId());
		serviceService.updateService(service1);

		assertEquals(modifiedName, service4.getName());
		
	}
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Service.xml")
	public void testEditServiceController() {
		String modifiedName = "New Sevice b2a";
		Service service2 = new Service();
		service2.setDeliveryDays(new BigInteger("525"));
		service2.setType("test");
		service2.setName("dsds");
		service2.setTerminationFees(new BigInteger("87"));
		Service service = serviceService.addService(service2);
		Service service4= serviceService.getServiceById(service.getId());
        service4.setName("dsdsld ldksldksld sdlksds");
		ResponseEntity com2 = serviceController.updateService(service4);
		assert(com2.getStatusCode().is2xxSuccessful());
		
	}
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Service.xml")
	public void testEditServiceWithoutID() {
		String modifiedName = "New Service b2a";
		Service service2 = new Service();
		service2.setDeliveryDays(new BigInteger("525"));
		service2.setType("test");
		service2.setName("dsds");
		service2.setTerminationFees(new BigInteger("87"));
		//Service service = serviceService.addService(service2);
		//Service service4= serviceService.getServiceById(service.getId());
        service2.setName("dsdsld ldksldksld sdlksds");
		ResponseEntity com2 = serviceController.updateService(service2);
		assert(com2.getStatusCode().is5xxServerError());
		
	}
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Service.xml")
	public void testDeleteServiceService() {
		String modifiedName = "New Service b2a";
		Service service2 = new Service();
		service2.setDeliveryDays(new BigInteger("525"));
		service2.setType("test");
		service2.setName("dsds");
		service2.setTerminationFees(new BigInteger("87"));
		serviceService.addService(service2);
		int currentLength = serviceService.getAllService().size();
		
		
		serviceService.delete(service2);
		int x = serviceService.getAllService().size();
		
		
		assertEquals(x,-- currentLength);
		
        
		
	}
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Service.xml")
	public void testDeleteServiceController() {
		String modifiedName = "New Service b2a";
		Service service2 = new Service();
		service2.setDeliveryDays(new BigInteger("525"));
		service2.setType("test");
		service2.setName("dsds");
		service2.setTerminationFees(new BigInteger("87"));
		serviceService.addService(service2);
	
		
		
		ResponseEntity com2 = serviceController.deleteService(service2.getId());
		
		assert(com2.getStatusCode().is2xxSuccessful());
		
        
		
	}
	
	@Test
	@Transactional
	@DatabaseSetup("/datasets/Service.xml")
	public void testDeleteWithoutId() {
		String modifiedName = "New Service b2a";
		Service service2 = new Service();
		service2.setDeliveryDays(new BigInteger("525"));
		service2.setType("test");
		service2.setName("dsds");
		service2.setTerminationFees(new BigInteger("87"));
		
		ResponseEntity com2 = serviceController.deleteService(service2.getId());
		
		assert(com2.getStatusCode().is5xxServerError());

	}
	
	
	@Test(expected= org.springframework.orm.jpa.JpaSystemException.class)
	@Transactional
	@DatabaseSetup("/datasets/Service.xml")
	public void testDeleteWithComponent() {
		String modifiedName = "New Service b2a";
		Service service2 = new Service();
		service2.setDeliveryDays(new BigInteger("525"));
		service2.setType("test");
		service2.setName("dsds");
		service2.setTerminationFees(new BigInteger("87"));
		
		Component component = new Component();
		component.setName("Test Component");
		component.setNrc(new BigInteger("5"));
		List<Component> lis=new ArrayList<>();
		lis.add(component);
		int x=componentService.getAllComponent().size();
		component=componentService.addComponent(component);
		
		service2.setComponentCollection(lis);
		serviceService.addService(service2);
		ResponseEntity com2 = serviceController.deleteService(service2.getId());
		int y=componentService.getAllComponent().size();
//		componentService.getOneComponent(component.getId());
		//assert(com2.getStatusCode().is2xxSuccessful());
	

	}
	
	
	


	
}
