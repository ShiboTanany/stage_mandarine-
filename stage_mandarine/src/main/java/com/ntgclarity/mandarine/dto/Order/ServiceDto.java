package com.ntgclarity.mandarine.dto.Order;

import java.math.BigInteger;
import java.util.List;

public class ServiceDto {
	// id: number;
	// name: string;
	// type: string;
	// dateCreated: string;
	// isactive: string;
	// terminationFees: string;
	// suspensionFees: string;
	// deliveryFees: string;
	// deliveryDays: string;
	// attributesValue=new Array<Attribute>();
	private Long id;
	private String name;

	private String type;
	private BigInteger isactive;
	private BigInteger terminationFees;

	private BigInteger suspensionFees;

	private BigInteger deliveryFees;

	private BigInteger deliveryDays;

	private List<AttributeDto> attributesValue;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the isactive
	 */
	public BigInteger getIsactive() {
		return isactive;
	}

	/**
	 * @param isactive
	 *            the isactive to set
	 */
	public void setIsactive(BigInteger isactive) {
		this.isactive = isactive;
	}

	/**
	 * @return the terminationFees
	 */
	public BigInteger getTerminationFees() {
		return terminationFees;
	}

	/**
	 * @param terminationFees
	 *            the terminationFees to set
	 */
	public void setTerminationFees(BigInteger terminationFees) {
		this.terminationFees = terminationFees;
	}

	/**
	 * @return the suspensionFees
	 */
	public BigInteger getSuspensionFees() {
		return suspensionFees;
	}

	/**
	 * @param suspensionFees
	 *            the suspensionFees to set
	 */
	public void setSuspensionFees(BigInteger suspensionFees) {
		this.suspensionFees = suspensionFees;
	}

	/**
	 * @return the deliveryFees
	 */
	public BigInteger getDeliveryFees() {
		return deliveryFees;
	}

	/**
	 * @param deliveryFees
	 *            the deliveryFees to set
	 */
	public void setDeliveryFees(BigInteger deliveryFees) {
		this.deliveryFees = deliveryFees;
	}

	/**
	 * @return the deliveryDays
	 */
	public BigInteger getDeliveryDays() {
		return deliveryDays;
	}

	/**
	 * @param deliveryDays
	 *            the deliveryDays to set
	 */
	public void setDeliveryDays(BigInteger deliveryDays) {
		this.deliveryDays = deliveryDays;
	}

	/**
	 * @return the attributesValue
	 */
	public List<AttributeDto> getAttributesValue() {
		return attributesValue;
	}

	/**
	 * @param attributesValue
	 *            the attributesValue to set
	 */
	public void setAttributesValue(List<AttributeDto> attributesValue) {
		this.attributesValue = attributesValue;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
