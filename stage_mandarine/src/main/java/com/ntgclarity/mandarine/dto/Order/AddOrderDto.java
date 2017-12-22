package com.ntgclarity.mandarine.dto.Order;

public class AddOrderDto {
	// address: string;
	// email: string;
	// phone: string;
	// userName: string;
	// quantity: number;

	private String userName;
	private String email;
	private String address;
	private String phone;
	private int quantity;
	private ServiceDto serviceDto;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the serviceDto
	 */
	public ServiceDto getServiceDto() {
		return serviceDto;
	}

	/**
	 * @param serviceDto the serviceDto to set
	 */
	public void setServiceDto(ServiceDto serviceDto) {
		this.serviceDto = serviceDto;
	}

}
