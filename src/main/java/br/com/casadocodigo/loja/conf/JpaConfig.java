package br.com.casadocodigo.loja.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JpaConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean jpa () {
		
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		ds.setUrl("jdbc:mysql://localhost:3306/fj27?useUnicode=yes&characterEncoding=UTF-8");
		ds.setUsername("root");
		ds.setPassword("caelum");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		
		JpaVendorAdapter jpa = new HibernateJpaVendorAdapter();
		
		Properties prop = new Properties();
		
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.connection.charSet", "UTF-8");
		
		emf.setDataSource(ds);
		emf.setJpaVendorAdapter(jpa);
		emf.setJpaProperties(prop);
		
		emf.setPackagesToScan(new String[]{"br.com.casadocodigo.models"});
		
		return emf;
	}
	
	@Bean
	public PlatformTransactionManager manager(EntityManagerFactory emf) {
		
		JpaTransactionManager manager = new JpaTransactionManager();
		
		manager.setEntityManagerFactory(emf);
	
		return manager;
		
	}
	
}
