package com.ntgclarity.mandarine.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;


import com.ntgclarity.mandarine.entity.Attribute;
import com.ntgclarity.mandarine.entity.AttributeValue;
import com.ntgclarity.mandarine.entity.AttributeValueList;
import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.entity.Orders;
import com.ntgclarity.mandarine.entity.Service;

public class CategoryDTO implements Serializable {
	private Long id;
	private String name;
	private String type;
	public CategoryDTO(Category cat){
		this.id=cat.getId();
		this.name=cat.getName();
		this.type=cat.getType();		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
}