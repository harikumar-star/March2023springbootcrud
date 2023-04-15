package com.emp.model;

public class Employee {

	private String empid;
	private String status;

	
	public Employee()
	{
		
	}
	public Employee(String id, String name2, String desing, String exper, String age2, String status2)
	{
		this.empid = id;
		this.name = name2;
		this.designation = desing;
		this.experience = exper;
		this.age = age2;
		this.status = status2;
	}
	public Employee(String name2, String price, String author) {
		this.name = name2;
		this.designation = price;
		this.experience = author;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	private String designation;
	private String experience;
	private String age;
	
	public String toString()
	{
		return empid+""+name+""+designation+""+experience+""+age+""+status
;	}
	
	

}
