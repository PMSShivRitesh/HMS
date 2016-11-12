package com.airwire.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airwire.hms.entity.Role;

public interface RoleDao extends JpaRepository<Role, String> {

}
