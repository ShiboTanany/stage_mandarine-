package com.ntgclarity.mandarine.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import com.ntgclarity.mandarine.entity.Service;

public class OrderDto {

	private Service serviceid;
	private int quantity;
	private String userName;
	private String address;
	private String email;
	private String phone;
	private Map<String, ArrayList<String>> attributes = new HashMap<String, ArrayList<String>>();

	public Service getServiceid() {
		return serviceid;
	}

	public void setServiceid(Service serviceid) {
		this.serviceid = serviceid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Map<String, ArrayList<String>> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, ArrayList<String>> attributes) {
		this.attributes = attributes;
	}

	public void addAttribute(String name, String value) {
		ArrayList<String> values;
		if (!attributes.containsKey(name)) {
			values = new ArrayList<>();
			values.add(value);
			attributes.put(name, values);
		} else {
			values = attributes.get(name);
			values.add(value);
			attributes.put(name, values);
		}
	}

}
