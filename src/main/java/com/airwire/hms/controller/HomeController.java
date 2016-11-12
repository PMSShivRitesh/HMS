package com.airwire.hms.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airwire.hms.dao.EmployeeDao;
import com.airwire.hms.dao.RoleDao;
import com.airwire.hms.entity.Employee;
import com.airwire.hms.entity.Role;
import com.airwire.hms.util.EmploymentType;
import com.airwire.hms.util.RoleType;
import com.airwire.hms.util.UserStatus;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	EmployeeDao employeeDao;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		Role role = new Role();
		role.setRoleType(RoleType.ADMIN);
		role.setCreatedOn(new Date());
		role.setModifiedOn(new Date());
		
		roleDao.saveAndFlush(role);
		
		Employee employee = new Employee();
		employee.setName("Shiv");
		employee.setEmailId("shiv@gmail.com");
		employee.setLoginName("shiv@gmail.com");
		employee.setPassword("shiv123");
		employee.setEmploymentType(EmploymentType.PERMANENT);
		employee.setEmployeeStatus(UserStatus.ACTIVE);
		employee.setCreatedOn(new Date());
		employee.setUid("3764bcb3b4234yc4");
		employee.setRole(role);
		
		employeeDao.saveAndFlush(employee);
		
		return "login/login";
	}
	
	@RequestMapping(value = "dashboard", method = RequestMethod.GET)
	public String login() {
		logger.info("Welcome home! The client locale is {}.");
		return "operator/registerpatient";
	}
	
}
