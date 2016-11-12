package com.airwire.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airwire.hms.entity.PatientBillTransaction;


public interface PatientBillTransactionDao extends JpaRepository<PatientBillTransaction, String> {
																		
}
