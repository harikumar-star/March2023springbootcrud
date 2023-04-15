package com.emp.dao;

import java.util.List;

import org.springframework.stereotype.Service;


import com.emp.model.Employee;

@Service
public interface EmployeeDao {

	//admin contracts
	public Employee addemp(Employee emp);
	public List<Employee> list();
	public Employee getemp(String empid);
	public int UpdateEmp(Employee emp);
	public int deletall();
	public String deletebyid(String empid);
	
	
	//emp contracts
	
	
	
	
}
