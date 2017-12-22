package com.ntgclarity.mandarine.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;


import com.ntgclarity.mandarine.entity.Attribute;
import com.ntgclarity.mandarine.entity.AttributeValue;
import com.ntgclarity.mandarine.entity.AttributeValueList;
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.entity.Orders;
import com.ntgclarity.mandarine.entity.Service;

public class ServiceDto implements Serializable {
	private Long id;
	
	private String name;

	private String type;

	private BigInteger isactive;

	private BigInteger terminationFees;

	private BigInteger suspensionFees;

	private BigInteger deliveryFees;

	private BigInteger deliveryDays;

	private Collection<Component> componentCollection = new ArrayList<>();

	private Collection<Attribute> attributeCollection = new ArrayList<>();
	// @OneToMany(mappedBy = "serviceId")
	// private Collection<Category> categoryCollection;

	private Collection<AttributeValue> attributeValueCollection = new ArrayList<>();

	private Collection<Orders> ordersCollection = new ArrayList<>();

	private Collection<AttributeValueList> attributeValueListCollection = new ArrayList<>();

	public ServiceDto(Service service) {
		id=service.getId();
		name = service.getName();
		type = service.getType();
		isactive = service.getIsactive();
		terminationFees = service.getTerminationFees();
		suspensionFees = service.getSuspensionFees();
		deliveryFees = service.getDeliveryFees();
		deliveryDays = service.getDeliveryDays();
		setComponentCollection(service.getComponentCollection());
		setAttributeCollection(service.getAttributeCollection());
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigInteger getIsactive() {
		return isactive;
	}

	public void setIsactive(BigInteger isactive) {
		this.isactive = isactive;
	}

	public BigInteger getTerminationFees() {
		return terminationFees;
	}

	public void setTerminationFees(BigInteger terminationFees) {
		this.terminationFees = terminationFees;
	}

	public BigInteger getSuspensionFees() {
		return suspensionFees;
	}

	public void setSuspensionFees(BigInteger suspensionFees) {
		this.suspensionFees = suspensionFees;
	}

	public BigInteger getDeliveryFees() {
		return deliveryFees;
	}

	public void setDeliveryFees(BigInteger deliveryFees) {
		this.deliveryFees = deliveryFees;
	}

	public BigInteger getDeliveryDays() {
		return deliveryDays;
	}

	public void setDeliveryDays(BigInteger deliveryDays) {
		this.deliveryDays = deliveryDays;
	}

	public Collection<Component> getComponentCollection() {
		return componentCollection;
	}

	public void setComponentCollection(Collection<Component> serviceComponentCollection) {
		if (serviceComponentCollection == null) {
			componentCollection = null;
			return;
		}
		for (Component component : serviceComponentCollection)
	{
			component.setServiceCollection(null);
			component.getCategoryId().setComponentCollection(null);
			componentCollection.add(component);}
	}

	public Collection<Attribute> getAttributeCollection() {
		return attributeCollection;
	}

	public void setAttributeCollection(Collection<Attribute> serviceAttributeCollection) {
		if (serviceAttributeCollection == null) {
			attributeCollection = null;
			return;
		}
		for (Attribute attribute : serviceAttributeCollection)
		{
			
//			attribute.setAttributeValueCollection(null);
			
			for(AttributeValueList attributeValueList:attribute.getAttributeValueListCollection())
			{
				attributeValueList.setAttributeId(null);
				attributeValueList.setServiceid(null);
				
			}
//			attribute.setAttributeValueListCollection(null);
			
//			Collection<AttributeValue> arr= attribute.getAttributeValueCollection();
//			if(arr!=null)
//			for (AttributeValue attributeValue : arr) {
//				
//				attributeValue.setServiceId(null);
//			}
			
//			Collection<AttributeValueList> arr2= attribute.getAttributeValueListCollection();
//			if(arr2!=null)
//			for (AttributeValueList attributeValueList : arr2) {
//				attributeValueList.setServiceid(null);
//			}
			attribute.setServiceId(null);
			attributeCollection.add(attribute);}
	}

	public Collection<AttributeValue> getAttributeValueCollection() {
		return attributeValueCollection;
	}

	public void setAttributeValueCollection(Collection<AttributeValue> serviceAttributeValueCollection) {
		if (serviceAttributeValueCollection == null) {
			attributeValueCollection = null;
			return;
		}
		for (AttributeValue attributeValue : serviceAttributeValueCollection)
			{attributeValue.setServiceId(null);
			attributeValueCollection.add(attributeValue);}
	}

	public Collection<Orders> getOrdersCollection() {
		return ordersCollection;
	}

	public void setOrdersCollection(Collection<Orders> serviceOrdersCollection) {
		if (serviceOrdersCollection == null) {
			ordersCollection = null;
			return;

		}
		for (Orders orders : serviceOrdersCollection)
			{orders.setServiceid(null);
			
			ordersCollection.add(orders);}
	}

	public Collection<AttributeValueList> getAttributeValueListCollection() {
		return attributeValueListCollection;
	}

	public void setAttributeValueListCollection(Collection<AttributeValueList> serviceAttributeValueListCollection) {
		if (serviceAttributeValueListCollection == null) {
			attributeValueListCollection = null;
			return;
		}
		for (AttributeValueList attributeValueList : serviceAttributeValueListCollection) {
			attributeValueList.setServiceid(null);
			attributeValueListCollection.add(attributeValueList);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
