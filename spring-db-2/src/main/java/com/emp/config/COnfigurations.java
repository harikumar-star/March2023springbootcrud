package com.emp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.emp.dao.EmployeeDao2;
import com.emp.daoimpl.Empdaoimpl2;

@Configuration
public class COnfigurations {

	@Bean
	public EmployeeDao2 emp2 ()
	{
		return new Empdaoimpl2();
	}
	
	
}
