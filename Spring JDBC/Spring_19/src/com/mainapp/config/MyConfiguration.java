package com.mainapp.config;

import java.beans.BeanProperty;
import java.net.DatagramSocket;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.mainapp"})
@PropertySource("classpath:config.properties")
public class MyConfiguration {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource con = new DriverManagerDataSource();
		
		con.setUrl(environment.getProperty("db.url"));
		con.setUsername(environment.getProperty("db.username"));
		con.setPassword(environment.getProperty("db.password"));
		con.setDriverClassName(environment.getProperty("db.driver"));
		
		return con;
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	
}

