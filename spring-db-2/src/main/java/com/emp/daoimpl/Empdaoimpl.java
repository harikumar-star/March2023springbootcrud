package com.emp.daoimpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.emp.dao.EmployeeDao;
import com.emp.model.Employee;
import com.emp.service.Services;

@Repository
@Qualifier("c1")
public class Empdaoimpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	Services ser;

	int count = 1;

	@Override
	public Employee addemp(Employee emp) {

		System.out.println("Add Emp");
		// em_validate,user_register
		String sql = "insert into user_register (empid,name,designation,experience,age,status) values (customers_seq.NEXTVAL,?,?,?,?,?)";
		// String sql1 = "insert into emp_validate (name) values (?)";
		String name = emp.getName();
		System.out.println("Name getting from empName" + name);

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
			int count = jdbcTemplate.update(sql, new Object[] { emp.getName(), emp.getDesignation(),
					emp.getExperience(), emp.getAge(), emp.getStatus() });
			// Writing to File

			try {
				String age = emp.getAge();
				String name1 = emp.getName();
				String desig = emp.getDesignation();
				String exp = emp.getExperience();
				String age1 = emp.getAge();
				String stat = emp.getStatus();
				System.out.println("Before file store");
				String fileOut = "E:\\Hari.txt"; // read this from properti file
				BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut, true));
				/*
				 * writer.append(' '); writer.append(age + "" + name1);
				 */
				// writer.append(' ');
				writer.newLine();
				writer.write(age + ' ' + name1 + ' ' + desig + ' ' + exp + ' ' + age1 + ' ' + stat); // adding space

				writer.close();
				System.out.println("after file store");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			return null;

		}
		return null;

	}

	@Override
	public List<Employee> list() {

		String sql = "SELECT * FROM user_register";
		List<Employee> listContact = jdbcTemplate.query(sql, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println("Before");

				// System.out.println("POJO----------"+pojos.getT1()+"----"+pojos.getT2());
				Employee p = new Employee();
				p.setEmpid(rs.getString(1));

				p.setName(rs.getString(2));
				p.setDesignation(rs.getString(3));
				p.setExperience(rs.getString(4));
				p.setAge(rs.getString(5));
				p.setStatus(rs.getString(6));
				return p;
			}

		});
		return listContact;

	}

	@Override
	public Employee getemp(String empid) {

		String sql = "SELECT * FROM user_register WHERE empid=" + empid;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Employee p = new Employee();
					p.setEmpid(rs.getString(1));
					p.setName(rs.getString(2));
					p.setDesignation(rs.getString(3));
					p.setExperience(rs.getString(4));
					p.setAge(rs.getString(5));
					p.setStatus(rs.getString(6));
					return p;
				}
				return null;

				// return null;
			}

		});
	}

	@Override
	public int UpdateEmp(Employee emp) {

		String empid = emp.getEmpid();

		String update = "update user_register set name=?, designation=?, experience=?, age=?, status=? where empid=?";
		int count = jdbcTemplate.update(update, emp.getName(), emp.getDesignation(), emp.getExperience(), emp.getAge(),
				emp.getStatus(), emp.getEmpid());

		return count;
	}

	@Override
	public int deletall() {
		String sql = "delete from user_register";
		int count = jdbcTemplate.update(sql);

		return count;
	}

	@Override
	public String deletebyid(String empid) {

		String sql = "delete from user_register where empid=?";
		int count = jdbcTemplate.update(sql, empid);

		String counts = ser.inttostring(count);

		return counts;
	}

}
