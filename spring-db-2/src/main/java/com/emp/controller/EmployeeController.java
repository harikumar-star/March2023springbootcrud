package com.emp.controller;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.emp.dao.EmployeeDao;
import com.emp.model.Employee;
import com.emp.service.Services;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDao dao;

	@RequestMapping("/")
	public ModelAndView firstpage() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "jsppageto", method = RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request) {
		String value = request.getParameter("value");
		System.out.println("Value--------------" + value);
		if (value.equalsIgnoreCase("add")) {
			return new ModelAndView("addemp");
		} else if (value.equalsIgnoreCase("specificrecord")) {
			return new ModelAndView("findempbyid");
		} else if (value.equalsIgnoreCase("home")) {
			return new ModelAndView("index");
		} else if (value.equalsIgnoreCase("deletebyids")) {
			new ModelAndView("deletebyid");
		}

		return null;

	}

	@RequestMapping(value = "addemp", method = RequestMethod.POST)
	public ModelAndView addemp(Model m, @RequestParam("name") String name,
			@RequestParam("designation") String desgination, @RequestParam("experience") String experience,
			@RequestParam("age") String age, Model m2

	) {

		ModelAndView m1 = new ModelAndView();
		m1.setViewName("addemp");
		Employee emp = new Employee();
		emp.setName(name);
		emp.setDesignation(desgination);
		emp.setExperience(experience);
		emp.setAge(age);

		Employee e = dao.addemp(emp);
		System.out.println(e+"------------checking");
		if (e == null) {

			
			

			m2.addAttribute("message", "Insert Success");
		} else {
			m2.addAttribute("message", "Insert Failed");
		}
		// System.out.println(count);

		return m1;

	}

	@RequestMapping(value = "viewempdetails", method = RequestMethod.GET)
	public ModelAndView viewempdetails(ModelAndView model) {
		List<Employee> listContact = dao.list();
		model.addObject("listContact", listContact);
		model.setViewName("viewempdetails");

		return model;

	}

	@RequestMapping(value = "editemp", method = RequestMethod.GET)
	public ModelAndView editemp(HttpServletRequest request) {
		String empid = request.getParameter("empid");

		String check = request.getParameter("check");

		if (check.equalsIgnoreCase("findempbyid")) {
			Employee emp = dao.getemp(empid);
			ModelAndView model = new ModelAndView();

			System.out.println(emp + "------------emp");
			if (emp == null) {
				model.setViewName("index");
				model.addObject("msg", "No record Found for Emp Id");
			} else {

				model.setViewName("findempbyid2");
				model.addObject("contact", emp);
			}

			return model;
		} else {
			Employee emp = dao.getemp(empid);
			ModelAndView model = new ModelAndView("editemp");
			model.addObject("contact", emp);

			return model;
		}

	}

	@RequestMapping(value = "/saveemp", method = RequestMethod.POST)
	public ModelAndView saveemp(@ModelAttribute Employee emp, Model m1) {
		System.out.println("Saveemp");
		ModelAndView m = new ModelAndView();
		m.setViewName("index");
		int count = dao.UpdateEmp(emp);
		if (count > 0) {
			m1.addAttribute("edit", "Edit Success");
			System.out.println("Success edit");
		} else {
			m1.addAttribute("edit", "Edit Failed Pls Check");
			System.out.println("edit failed");
		}
		return m;
	}

	@RequestMapping(value = "deleteall", method = RequestMethod.GET)
	public ModelAndView delete(Model m) {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");

		int count = dao.deletall();
		if (count > 0) {
			m.addAttribute("msg", "Delete Success");
		} else {
			m.addAttribute("msg", "Delete Failed");
		}
		return model;
	}

	@RequestMapping(value = "deletebyid", method = RequestMethod.GET)
	public ModelAndView deletebyid(Model m, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		;
		String empid = request.getParameter("empid");

		String count = dao.deletebyid(empid);

		if (count.equals("no")) {
			m.addAttribute("msg", "DeleteByID Failed");
		} else {
			m.addAttribute("msg", "DeleteByID Success");
		}

		return model;
	}

}
