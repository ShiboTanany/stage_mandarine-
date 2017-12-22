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
package com.ntgclarity.mandarine.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ntgclarity.mandarine.security.CORSFilter;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.ntgclarity.mandarine.controller.endpoint","com.ntgclarity.mandarine.service", "com.ntgclarity.mandarine.repository"})
@EnableJpaRepositories(basePackages ="com.ntgclarity.mandarine.repository")
@PropertySource(value = { "classpath:application-test.properties" })
public class ApplicationContextTest {

	@Autowired
	private Environment environment;
	
	@Bean
	public FilterRegistrationBean someFilterRegistration() {

	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(new  CORSFilter() );
	    registration.addUrlPatterns("/*");
	    registration.addInitParameter("paramName", "paramValue");
	    registration.setName("someFilter");
	    registration.setOrder(1);
	    return registration;
	}
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(environment.getRequiredProperty("database.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("database.url"));
		dataSource.setUsername(environment.getRequiredProperty("database.userName"));
		
		dataSource.setPassword(environment.getRequiredProperty("database.password"));
		System.out.println(dataSource.getUsername()+"and the pass word i s"+dataSource.getPassword());
		return dataSource;
	}


	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan(new String[] { "com.ntgclarity.mandarine.entity" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactory.setJpaProperties(additionalProperties());

		return entityManagerFactory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.ddl"));
		properties.setProperty("show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	//	properties.setProperty("format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

}

