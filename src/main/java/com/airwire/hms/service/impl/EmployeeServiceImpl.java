package com.airwire.hms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.airwire.hms.dao.EmployeeDao;
import com.airwire.hms.entity.Employee;
import com.airwire.hms.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl  implements EmployeeService{	
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.saveAndFlush(employee);
	}
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try
		{
			Employee user = employeeDao.findByLoginName(username);
			Assert.notNull(user);
			return new org.springframework.security.core.userdetails.User(user.getLoginName(),user.getPassword(), true,true,
					true,true, getGrantedAuthorities(user));
		}
		catch(IllegalArgumentException ex){
			throw new UsernameNotFoundException("User does not exist");
		}
	}
	
	@Override
	public void addEmployee(Employee employee) {
		Assert.notNull(employee);
		employee.setPassword(encodePassword(employee.getPassword()));
		employeeDao.saveAndFlush(employee);
	}

	private List<GrantedAuthority> getGrantedAuthorities(Employee user){
		
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
        authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole().getRoleType().toString()));
        
        return authorities;
    }

	private String encodePassword(String rawPassword){
		return passwordEncoder.encode(rawPassword);
	}
}
