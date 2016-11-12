package com.airwire.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airwire.hms.entity.Patient;

public interface PatientDao extends JpaRepository<Patient, String> {

}
