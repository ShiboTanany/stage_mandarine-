/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER. Copyright 1997-2016 NTG Clarity and/or its affiliates. All
 * rights reserved. NTG CLARITY is a leader in delivering network, telecom, IT and infrastructure solutions to network
 * service providers and medium and large enterprises. www.ntgclarity.com The contents of this file are subject to the
 * terms of "NTG Clarity License". You must not use this file except in compliance with the License. You can obtain a
 * copy of the License at http://www.ntgclarity.com/ See the License for the specific language governing permissions and
 * limitations under the License. Contributor(s): The Initial Developer of the Original Software is NTG Clarity . , Inc.
 * Copyright 1997-2016 NTG Clarity. All Rights Reserved. CLASS StatusResponse
 * <h4>Description</h4>
 * <h4>Notes</h4>
 * <h4>References</h4>
 * 
 * @author: tali <A HREF="mailto:stageem-dev@ntgclarity.com">Stage Development Team</A>
 * @version Revision: 1.0 Date: Nov 16, 2015 4:14:13 PM
 * @see [String]
 * @see [URL]
 * @see [Class name#method name]
 */

package com.ntgclarity.mandarine.dto;

import java.io.Serializable;

//import com.ntgclarity.services.util.RequestHeadersUtil;


/**
 * @creator Mohamed Alatroush
 * @created on Nov 8, 2015
 */
public class StatusResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7725423465837002562L;

	private String code;
	private String key;
	private String message;
	private String locale;

	public void setLocal(String local) {
		this.locale = local;
	}

	public StatusResponse(String code, String key) {
		super();
		this.code = code;
		this.key = key;
		// this.locale =
		// RequestHeadersUtil.getLocaleFromHttpRequest().toLanguageTag();
	}

	public StatusResponse(String code, String key, String message, String locale) {
		super();
		this.code = code;
		this.key = key;
		this.message = message;
		this.locale = locale;
	}

	public StatusResponse(String code, String key, String message) {
		super();
		this.code = code;
		this.key = key;
		this.message = message;
		// this.locale =
		// RequestHeadersUtil.getLocaleFromHttpRequest().toLanguageTag();
	}

	public StatusResponse() {
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param message
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

}
