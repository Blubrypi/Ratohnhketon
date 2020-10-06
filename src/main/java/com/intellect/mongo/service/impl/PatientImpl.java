package com.intellect.mongo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.mongo.dto.PatientDto;
import com.intellect.mongo.exception.NoSuchPatientException;
import com.intellect.mongo.exception.PatientAlreadyExistsException;
import com.intellect.mongo.exception.ServiceException;
import com.intellect.mongo.model.Patient;
import com.intellect.mongo.repository.PatientRepository;
import com.intellect.mongo.service.PatientService;

@Service
public class PatientImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;

	private ModelMapper modelMapper = new ModelMapper();

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public PatientDto addPatient(PatientDto newPatientDto) throws ServiceException {
		Patient newPatient = convertDtoToEntity(newPatientDto);
		if (isPatientExists(newPatient))
			throw new PatientAlreadyExistsException("Patient Already Exists");
		return convertEntityToDto(patientRepository.save(newPatient));
	}

	@Override
	public List<PatientDto> fetchAllPatients() {
		List<Patient> patients = patientRepository.findAll();
		List<PatientDto> patientsDto = new ArrayList<>();
		for (Patient patient : patients)
			patientsDto.add(convertEntityToDto(patient));
		return patientsDto;
	}

	@Override
	public PatientDto getPatient(String patientId) throws ServiceException {
		Optional<Patient> patientOptional = patientRepository.findById(patientId);
		if (!patientOptional.isPresent())
			throw new NoSuchPatientException("No Such Patient Exists");
		return convertEntityToDto(patientOptional.get());
	}

	@Override
	public PatientDto updatePatient(PatientDto patientDto) throws ServiceException {
		Optional<Patient> patientOptional = patientRepository.findById(patientDto.getPatientId());
		if (patientOptional.isPresent()) {
			Patient newPatient = convertDtoToEntity(patientDto);
			if (isPatientExists(newPatient))
				throw new PatientAlreadyExistsException("Record Not Updated, no fields changed");
			else {
				logger.info("Updaing Patient with ID:{}", newPatient.getPatientId());
				return convertEntityToDto(patientRepository.save(newPatient));
			}
		} else
			throw new NoSuchPatientException("No Such Patient Exists");
	}

	@Override
	public List<PatientDto> deletePatient(String patientId) throws ServiceException {
		Optional<Patient> patientOptional = patientRepository.findById(patientId);
		if (!patientOptional.isPresent())
			throw new NoSuchPatientException("No Such Patient Exists");
		else {
			patientRepository.deleteById(patientId);
			logger.info("Patient successfully removed");
			List<Patient> patients = patientRepository.findAll();
			List<PatientDto> patientsDto = new ArrayList<>();
			for (Patient patient : patients)
				patientsDto.add(convertEntityToDto(patient));
			return patientsDto;
		}
	}

	private boolean isPatientExists(Patient patient) {
		for (Patient p : patientRepository.findAll()) {
			if (p.getPatientName().equals(patient.getPatientName()) && p.getPatientAge() == patient.getPatientAge()
					&& p.getPatientContactNo().equals(patient.getPatientContactNo()))
				return true;
		}
		return false;
	}

	public PatientDto convertEntityToDto(Patient patient) {
		return modelMapper.map(patient, PatientDto.class);
	}

	public Patient convertDtoToEntity(PatientDto patientDto) {
		return modelMapper.map(patientDto, Patient.class);
	}
}
