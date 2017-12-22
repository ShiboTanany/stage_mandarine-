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

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.ntgclarity" })
@EnableAutoConfiguration
@EnableJpaRepositories({ "com.ntgclarity.mandarine.repository" })
@PropertySource(value = { "classpath:application.properties" })
@EnableSpringDataWebSupport
public class JPAConfig {
	@Autowired
	private Environment environment;

	private static final Logger log = LoggerFactory.getLogger(JPAConfig.class);

	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setMinPoolSize(
					Integer.parseInt(environment.getRequiredProperty("spring.datasource.initial-size")));
			dataSource
					.setMaxPoolSize(Integer.parseInt(environment.getRequiredProperty("spring.datasource.max-active")));
			dataSource.setMaxIdleTime(
					Integer.parseInt(environment.getRequiredProperty("spring.datasource.tomcat.max-wait")));
			dataSource.setJdbcUrl(environment.getRequiredProperty("spring.datasource.url"));
			dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
			dataSource.setUser(environment.getRequiredProperty("spring.datasource.username"));
			dataSource.setDriverClass(environment.getRequiredProperty("spring.datasource.driverClassName"));
		} catch (IllegalStateException e) {
			log.error("[NTG_LOG_START] Error creating the main data source with error: (" + e.getMessage()
					+ ") [NTG_LOG_END]");
		} catch (PropertyVetoException e) {
			log.error("[NTG_LOG_START] Error creating the main data source with error: (" + e.getMessage()
					+ ") [NTG_LOG_END]");
		}
		return dataSource;
	}

//	@Bean(name = "flyway", initMethod = "migrate")
//	Flyway flyway() {
//		Flyway flyway = new Flyway();
//		flyway.setBaselineOnMigrate(true);
//		flyway.setDataSource(dataSource());
//		flyway.setValidateOnMigrate(false);
//		flyway.setLocations(environment.getRequiredProperty("flyway.script.location"));
//	//	flyway.set
//		//flyway.setSchemas("MY010");//environment.getRequiredProperty("flyway.schemas"));
//		
//		return flyway;
//
//	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan(new String[] { "com.ntgclarity.mandarine" });
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
		properties.setProperty("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.setProperty("format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.setProperty("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.setProperty("cache.use_second_level_cache",
				environment.getRequiredProperty("hibernate.cache.use_second_level_cache"));
		properties.setProperty("cache.use_query_cache",
				environment.getRequiredProperty("hibernate.cache.use_query_cache"));
		properties.setProperty("org.hibernate.envers.audit_table_suffix",
				environment.getRequiredProperty("hibernate.envers.suffix"));
		//properties.setProperty("hibernate.default_schema", environment.getRequiredProperty("hibernate.default_schema"));
		return properties;
	}
}
