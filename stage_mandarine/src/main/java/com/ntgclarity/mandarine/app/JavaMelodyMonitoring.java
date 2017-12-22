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

package com.ntgclarity.mandarine.app;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.Parameter;
import net.bull.javamelody.SessionListener;

@Configuration
@ImportResource("classpath:java-melody-spring-context.xml")
@SuppressWarnings({ "javadoc", "deprecation" })
public class JavaMelodyMonitoring implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(new SessionListener());
	}

	@Bean
	public FilterRegistrationBean javaMelody() {
		final FilterRegistrationBean javaMelody = new FilterRegistrationBean();
		javaMelody.setFilter(new MonitoringFilter());
		javaMelody.setAsyncSupported(true);
		javaMelody.setName("javamelody");
		javaMelody.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ASYNC);

		// see the list of parameters:
		// https://github.com/javamelody/javamelody/wiki/UserGuide#6-optional-parameters
		javaMelody.addInitParameter(Parameter.LOG.getCode(), Boolean.toString(true));
		// to add basic auth:
		// javaMelody.addInitParameter(Parameter.AUTHORIZED_USERS.getCode(),
		// "NTG:hggi");
		// to change the default storage directory:
		// javaMelody.addInitParameter(Parameter.STORAGE_DIRECTORY.getCode(),
		// "/tmp/javamelody");

		javaMelody.addUrlPatterns("/*");
		return javaMelody;
	}
}
