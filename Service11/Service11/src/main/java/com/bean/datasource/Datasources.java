package com.bean.datasource;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Datasources {

	
	@Bean(name = "h22")
	@ConfigurationProperties("spring.datasource")
	@Primary
	public javax.sql.DataSource dataSourceh2(){
	    return DataSourceBuilder.create().build();
	}
	
	
	@Bean(name = "jdbctemplate1")
	 public JdbcTemplate jdbcTemplate1(@Qualifier("h22") DataSource h2) {
	  return new JdbcTemplate(h2);
	 }

}
