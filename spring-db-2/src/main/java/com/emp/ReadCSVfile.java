package com.emp;

import java.util.ArrayList;
import java.util.List;

import java.io.*;

public class ReadCSVfile {
	public static void main(String[] args) {
		String line = "";
		String splitBy = ",";
		
		//List<ArrayList> al = new ArrayList<();
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader("E:\\output.csv"));
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] employee = line.split(splitBy); // use comma as separator
				System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1]
						+ ", Designation=" + employee[2] + ", Contact=" + employee[3] + ", Salary= " + employee[4]
						+ ", City= " + employee[5] + "]");
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
