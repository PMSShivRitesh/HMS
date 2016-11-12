package com.airwire.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airwire.hms.entity.PatientHistory;

public interface PatientHistoryDao extends JpaRepository<PatientHistory, String> {

}
