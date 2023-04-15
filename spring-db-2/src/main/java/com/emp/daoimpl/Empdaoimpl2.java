package com.emp.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;


import com.emp.dao.EmployeeDao2;
import com.emp.model.Employee;
@Component
@Qualifier("c2")
public class Empdaoimpl2 implements EmployeeDao2 {

	@Autowired
	private JdbcTemplate jdbcTemplate;



	public Employee empcheck(String name) {

		
		try {
			Employee tutorial = jdbcTemplate.queryForObject("SELECT * FROM user_register WHERE name=?",
					BeanPropertyRowMapper.newInstance(Employee.class), name);
			String id = tutorial.getName();
			// System.out.println(p.getUserid());
			if (id.equalsIgnoreCase(name)) {
				System.out.println("data already");
				return tutorial;
			}

		} catch (EmptyResultDataAccessException e) {

			// return null;
			System.out.println("Not found");
			
			return null;

		}
		return null;

	}
	
	public List<Employee> getlistcsv ()
	{
		
		
		
		return null;
		
	}
	
	
	
	
	
}
