package com.intellect.mongo.service;

import java.util.List;

import com.intellect.mongo.dto.PatientDto;
import com.intellect.mongo.exception.ServiceException;

public interface PatientService {

	public PatientDto addPatient(PatientDto newPatientDto) throws ServiceException;

	public List<PatientDto> fetchAllPatients();

	public PatientDto getPatient(String patientId) throws ServiceException;

	public PatientDto updatePatient(PatientDto patientDto) throws ServiceException;

	public List<PatientDto> deletePatient(String patientId) throws ServiceException;
}
