package com.airwire.hms.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfigJPA {

	  @Value("${db.driver}")
	  private String DB_DRIVER;
	  
	  @Value("${db.password}")
	  private String DB_PASSWORD;
	  
	  @Value("${db.url}")
	  private String DB_URL;
	  
	  @Value("${db.username}")
	  private String DB_USERNAME;
	
	  @Value("${hibernate.dialect}")
	  private String HIBERNATE_DIALECT;
	  
	  @Value("${hibernate.show_sql}")
	  private String HIBERNATE_SHOW_SQL;
	  
	  @Value("${hibernate.hbm2ddl.auto}")
	  private String HIBERNATE_HBM2DDL_AUTO;
	
	  @Value("${entitymanager.packagesToScan}")
	  private String ENTITYMANAGER_PACKAGES_TO_SCAN;
	  
	  @Bean
	  public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(DB_DRIVER);
	    dataSource.setUrl(DB_URL);
	    dataSource.setUsername(DB_USERNAME);
	    dataSource.setPassword(DB_PASSWORD);
	    return dataSource;
	  }

	  @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	  	localContainerEntityManagerFactoryBean.setDataSource(dataSource());
	  	localContainerEntityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
	  
	    Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
	    hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
	    hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
	    
	    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
	    
	    localContainerEntityManagerFactoryBean.setJpaProperties(hibernateProperties);    
	    localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
	    
	    return localContainerEntityManagerFactoryBean;
	  }

	  @Bean
	  public PlatformTransactionManager transactionManager() {
		  JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		  jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		  return jpaTransactionManager;
	  }
	  
}
