package br.com.casadocodigo.loja.conf;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceConfigurationTest {

	@Bean
	@Profile("test")
	public DataSource dataSsource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/fj27_teste?useUnicode=yes&characterEncoding=UTF-8");
		ds.setUsername("root");
		ds.setPassword("caelum");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		return ds;
	}
	
}
