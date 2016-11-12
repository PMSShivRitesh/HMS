package com.airwire.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airwire.hms.entity.Employee;

	
public interface EmployeeDao extends JpaRepository<Employee, String> {
	Employee findByLoginName(String username);
}
