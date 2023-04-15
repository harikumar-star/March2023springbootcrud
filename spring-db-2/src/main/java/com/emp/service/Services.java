package com.emp.service;

import org.springframework.stereotype.Service;

import com.emp.model.Employee;

@Service
public class Services {

	public String inttostring(int empid) {
		String i = String.valueOf(empid);
		if (i.equals("1")) {
			return "yes";
		} else {
			return "no";
		}

	}

	public static Employee createBook(String[] metadata) {

		String id = metadata[0];
		String name = metadata[1];
		String desing = metadata[2];
		String exper = metadata[3];
		String age = metadata[4];
		String status = metadata[5];

		// create and return book of this metadata
		return new Employee(id,name, desing, exper,age,status);
	}

}
