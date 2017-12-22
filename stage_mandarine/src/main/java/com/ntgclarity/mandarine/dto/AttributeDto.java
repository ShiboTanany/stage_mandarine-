package com.ntgclarity.mandarine.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AttributeDto implements Serializable {
	private String name;
	private List<String> values = new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	
}
