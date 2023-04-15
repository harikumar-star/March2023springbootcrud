package com.emp.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.io.FilterInputStream;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.emp.dao.EmployeeDao;
import com.emp.dao.EmployeeDao2;
import com.emp.model.Employee;
import com.emp.service.Services;
import com.opencsv.CSVWriter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

@Controller
@PropertySource("classpath:filesdetails.properties")
public class EmployeeController2 {

	@Autowired
	@Qualifier("c2")
	EmployeeDao2 dao;

	@Autowired
	@Qualifier("c1")
	EmployeeDao dao1;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${file.path}")
	private String filepath;

	BufferedReader b = null;
	String line[] = null;

	@RequestMapping(value = "jsppageto2", method = RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request) {
		String value = request.getParameter("value");
		System.out.println("Value--------------" + value);
		if (value.equalsIgnoreCase("emplogin")) {
			return new ModelAndView("empfiles/emp_index");
		} else if (value.equalsIgnoreCase("specificrecord")) {
			return new ModelAndView("findempbyid");
		}

		return null;

	}

	@RequestMapping(value = "checkempname", method = RequestMethod.GET)
	public ModelAndView checkempname(Model m, HttpServletRequest request, HttpSession session) {

		ModelAndView model = new ModelAndView();

		String empname = request.getParameter("empname");
		Employee emp = dao.empcheck(empname);

		System.out.println(emp + "------------printing the object");
		// String name = emp.getName();

		System.out.println("empname------>" + empname);
		if (emp == null) {
			System.out.println(empname + "------emp in controller2");
			m.addAttribute("msg", "No Record Found");
			model.setViewName("empfiles/emp_index");
		} else {
			session.setAttribute("user", empname);
			model.setViewName("empfiles/emp_home");
		}

		return model;
	}

	@RequestMapping(value = "downloadCSV", method = RequestMethod.GET)
	public void downloadCSV(HttpServletResponse response) throws IOException {

		String fileOut = "E:\\books.csv";
		BufferedWriter b = new BufferedWriter(new FileWriter(fileOut));

		String csvFileName = "books.csv";

		response.setContentType("text/csv");

		// creates mock data
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
		response.setHeader(headerKey, headerValue);

		Employee book1 = new Employee();
		book1.setName("hari");
		book1.setDesignation("it");
		book1.setExperience("23");
		book1.setAge("32");
		book1.setStatus("dd");

		book1.getName();
		book1.getDesignation();
		book1.getExperience();
		book1.getAge();
		book1.getStatus();

		List<Employee> listBooks = Arrays.asList(book1);

		// uses the Super CSV API to generate CSV data from the model data
		CsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		String[] header = { "Name", "Designation", "Experience", "Age", "Status" };

		csvWriter.writeHeader(header);

		for (Employee aBook : listBooks) {
			csvWriter.write(aBook, header);

		}

		csvWriter.close();
	}

	@RequestMapping(value = "readdatafromfile", method = RequestMethod.GET)
	public ModelAndView readdatafromfile(Model model) {
		String strCurrentLine;
		int count = 0;
		ArrayList<String> a = new ArrayList<String>();
		List<Employee> emps = new ArrayList<Employee>();
		Employee emp1 = new Employee();

		Employee e = new Employee();
		System.out.println("File Reading");
		String str = " Hello I'm your String";

		try {
			// String fileOut = "E:\\Hari.txt";
			String fileOut = filepath;
			System.out.println(fileOut + "----------reading from properties");
			b = new BufferedReader(new FileReader(fileOut));

			while ((strCurrentLine = b.readLine()) != null) {

				System.out.println(strCurrentLine);

			}

		} catch (Exception e1) {
			e1.printStackTrace();

		} finally {
			try {
				if (b != null)
					b.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return null;
	}

	@RequestMapping(value = "writecsv", method = RequestMethod.GET)
	public Employee writecsv(Model model) throws IOException {

		String sql = "SELECT * FROM user_register";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				ResultSetMetaData Mdata = rs.getMetaData();
				Mdata.getColumnName(1);
				// Writing data to a csv file
				String line1[] = { Mdata.getColumnName(1), Mdata.getColumnName(2), Mdata.getColumnName(3),
						Mdata.getColumnName(4), Mdata.getColumnName(5) };
				String data[] = new String[5];
				while (rs.next()) {

					try {

						CSVWriter writer = new CSVWriter(new FileWriter("E:\\output.csv"));
						String line12[] = { "id", "name", "Desing", "Exper", "Age", "Status" };
						// String line2[] = {p.getName(), p.getDesignation(), p.getExperience(),
						// p.getAge(), p.getStatus()};
						data[0] = rs.getString(1);
						data[1] = rs.getString(2);
						data[2] = rs.getString(3);
						data[3] = rs.getString(4);
						data[4] = rs.getString(5);
						writer.writeNext(line12);
						writer.writeNext(data);

						System.out.println("Data Fetched and Written to CSV file!");
						writer.flush();

					}

					catch (Exception e) {
						e.printStackTrace();
					}

					// return p;
				}
				return null;

				// return null;
			}

		});

	}

	@RequestMapping(value = "insertbatch", method = RequestMethod.GET)
	public ModelAndView insertbatch() throws FileNotFoundException {
		System.out.println("Insert Batch");
		List<Employee> books = readBooksFromCSV("E:\\output.csv");
		String sql = "insert into batch_table(empid,name,designation,experience,age,status)values(?,?,?,?,?,?)";
		ArrayList<Object[]> sqlArgs = new ArrayList<>();
		// let's print all the person read from CSV file
		for (Employee b : books) {
			// add in batch
			Object[] edata = { b.getEmpid(), b.getName(), b.getDesignation(), b.getExperience(), b.getAge(),
					b.getStatus() };
			sqlArgs.add(edata);
		}
		jdbcTemplate.batchUpdate(sql, sqlArgs);
		System.out.println("Batch Updated");
		return null;

	}

	//batch Insert method
	private List<Employee> readBooksFromCSV(String fileName) {

		boolean flag = false;
		List<Employee> books = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);

		// create an instance of BufferedReader
		// using try with resource, Java 7 feature to close resources
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

			// read the first line from the text file
			// String line1 = br.readLine();
			String line2 = br.readLine();

			// loop until all lines are read
			while ((line2 = br.readLine()) != null) {

				// use string.split to load a string array with the values from
				// each line of
				// the file, using a comma as the delimiter
				String[] attributes = line2.split(",");

				/*
				 * Employee book = createBook(attributes);
				 * 
				 * // adding book into ArrayList books.add(book);
				 */
				// read next line before looping
				// if end of file reached, line would be null
				Employee book = createBook(attributes);

				line2 = br.readLine();
				String empid = attributes[0];
				String name = attributes[1];
				String designation = attributes[2];
				String age = attributes[3];

				book.setEmpid(empid);
				book.setName(name);
				book.setDesignation(designation);
				book.setAge(age);

				books.add(book);

			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return books;
	}

	// batch insert methods
	private Employee createBook(String[] metadata) {
		String id = metadata[0];
		String name = metadata[1];
		String desing = metadata[2];
		String exper = metadata[3];
		String age = metadata[4];
		String status = metadata[5];

		// create and return book of this metadata
		return new Employee(id, name, desing, exper, age, status);
	}

	@RequestMapping(value = "updatebatch", method = RequestMethod.GET)
	public ModelAndView updatebatch(Model models) {
		System.out.println("update Batch Started");

		Employee emp1 = new Employee();
		emp1.setEmpid("10002");
		emp1.setName("hari");

		Employee emp2 = new Employee();
		emp2.setEmpid("11");
		emp2.setName("ramkumar");

		List<Employee> emplist = new ArrayList<Employee>();
		emplist.add(emp1);
		emplist.add(emp2);

		String sql = "update batch_table set name =? where empid=?";

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {

				// TODO Auto-generated method stub
System.out.println("Inside Setvalues method");
				
				ps.setString(1, emplist.get(i).getName());
				ps.setString(2, emplist.get(i).getEmpid());

			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return emplist.size();
			}
		});

		return null;
	}

}
