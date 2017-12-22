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

package com.ntgclarity.mandarine.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="msisdn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="imsi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="impi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="impu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="smsc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="allowedDevices" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "msisdn", "imsi", "impi", "impu", "username", "password", "smsc", "code", "allowedDevices" })
@XmlRootElement(name = "subscriber")
public class Subscriber {

	@XmlElement(required = true)
	protected String msisdn;
	@XmlElement(required = true)
	protected String imsi;
	@XmlElement(required = true)
	protected String impi;
	@XmlElement(required = true)
	protected String impu;
	protected String username;
	protected String password;
	protected String smsc;
	protected String code;
	protected String allowedDevices;

	public Subscriber() {
	}

	public Subscriber(String msisdn, String imsi, String impi, String impu, String username, String password,
			String smsc) {
		this.msisdn = msisdn;
		this.imsi = imsi;
		this.impi = impi;
		this.impu = impu;
		this.username = username;
		this.password = password;
		this.smsc = smsc;
	}
	
	public Subscriber(String msisdn, String imsi, String impi, String impu, String username, String password,
			String smsc, String code) {
		this.msisdn = msisdn;
		this.imsi = imsi;
		this.impi = impi;
		this.impu = impu;
		this.username = username;
		this.password = password;
		this.smsc = smsc;
		this.code = code;
	}


	/**
	 * Gets the value of the msisdn property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * Sets the value of the msisdn property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMsisdn(String value) {
		this.msisdn = value;
	}

	/**
	 * Gets the value of the imsi property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getImsi() {
		return imsi;
	}

	/**
	 * Sets the value of the imsi property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setImsi(String value) {
		this.imsi = value;
	}

	/**
	 * Gets the value of the impi property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getImpi() {
		return impi;
	}

	/**
	 * Sets the value of the impi property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setImpi(String value) {
		this.impi = value;
	}

	/**
	 * Gets the value of the impu property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getImpu() {
		return impu;
	}

	/**
	 * Sets the value of the impu property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setImpu(String value) {
		this.impu = value;
	}

	/**
	 * Gets the value of the username property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the value of the username property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUsername(String value) {
		this.username = value;
	}

	/**
	 * Gets the value of the password property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the value of the password property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Gets the value of the smsc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSmsc() {
		return smsc;
	}

	/**
	 * Sets the value of the smsc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSmsc(String value) {
		this.smsc = value;
	}

	/**
	 * Gets the value of the subcorder property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */

	/**
	 * Gets the value of the code property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the value of the code property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCode(String value) {
		this.code = value;
	}

	public String getAllowedDevices() {
		return allowedDevices;
	}

	public void setAllowedDevices(String allowedDevices) {
		this.allowedDevices = allowedDevices;
	}

	@Override
	public String toString() {
		return "Subscriber [msisdn=" + msisdn + ", imsi=" + imsi + ", impi=" + impi + ", impu=" + impu + ", username="
				+ username + ", password=" + password + ", smsc=" + smsc + ", code=" + code + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscriber other = (Subscriber) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (impi == null) {
			if (other.impi != null)
				return false;
		} else if (!impi.equals(other.impi))
			return false;
		if (impu == null) {
			if (other.impu != null)
				return false;
		} else if (!impu.equals(other.impu))
			return false;
		if (imsi == null) {
			if (other.imsi != null)
				return false;
		} else if (!imsi.equals(other.imsi))
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (smsc == null) {
			if (other.smsc != null)
				return false;
		} else if (!smsc.equals(other.smsc))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
