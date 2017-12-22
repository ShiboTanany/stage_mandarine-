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
 * @author: hyang <A HREF="mailto:stageem-dev@ntgclarity.com">Stage Development Team</A>
 * @version Revision: 1.0 Date: 10/05/16 10:55 AM
 * @see [String]
 * @see [URL]
 * @see [Class name#method name]
 */

package com.ntgclarity.mandarine.dto;

import java.io.Serializable;

public class MailDTO implements Serializable {

	private static final long serialVersionUID = -8215324735095489652L;

	private String mailFrom;

	private String mailTo;

	private String cc;

	private String bcc;

	private String sentBody;

	private String subject;

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getSentBody() {
		return sentBody;
	}

	public void setSentBody(String sentBody) {
		this.sentBody = sentBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}