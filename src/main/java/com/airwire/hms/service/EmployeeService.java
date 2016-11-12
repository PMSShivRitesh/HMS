package com.airwire.hms.service;

import org.springframework.security.core.userdetails.UserDetailsService;

//import org.springframework.security.core.userdetails.UserDetailsService;

import com.airwire.hms.entity.Employee;

public interface EmployeeService extends UserDetailsService{
	
	void saveEmployee(Employee employee);

	void addEmployee(Employee employee);
}
