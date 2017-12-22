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
 * @author: StageemDeveloper <A HREF="mailto:stageem-dev@ntgclarity.com">Stage Development Team</A>
 * @version Revision: 1.0 Date: 12/05/16 10:22 AM
 * @see [String]
 * @see [URL]
 * @see [Class name#method name]
 */
package com.ntgclarity.mandarine.dto;

import java.io.Serializable;

public class IdValueDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4243590728220022663L;

	private Long id;

	/**
	 * eg. name
	 */
	private Object value;

	/**
	 * @param id
	 * @param value
	 */
	public IdValueDTO(Long id, Object value) {
		super();
		this.id = id;
		this.value = value;
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

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IdValueDTO [id=" + id + ", value=" + value + "]";
	}

}
