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

package com.ntgclarity.mandarine.util;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.LocaleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ntgclarity.mandarine.constants.Constants;
import com.ntgclarity.mandarine.exception.ApplicationException;

public class RequestHeadersUtil {

	private static final Logger logger = LoggerFactory.getLogger(RequestHeadersUtil.class);

	// TODO construct the locale object according to the input locale
	/**
	 * supported locale > (en,fr,...)
	 * 
	 * @return
	 * @throws ApplicationException
	 */
	public static final Locale getLocaleFromHttpRequest() throws ApplicationException {

		// Locale locale = Locale.ENGLISH; //default
		String userLocale = "";// default
		ServletRequestAttributes t = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest req = t.getRequest();

		if (req.getHeader(Constants.localeHTTPHeaderField) != null
				&& !req.getHeader(Constants.localeHTTPHeaderField).equals("")) {

			userLocale = req.getHeader(Constants.localeHTTPHeaderField);
		}

		try {
			return LocaleUtils.toLocale(userLocale);
		} catch (Exception e) {

			logger.warn("Unsupported Locale value " + userLocale);
			return LocaleUtils.toLocale("en");// default
		}
	}
}
