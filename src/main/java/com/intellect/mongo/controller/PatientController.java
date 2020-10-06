package com.intellect.mongo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.mongo.dto.PatientDto;
import com.intellect.mongo.exception.ServiceException;
import com.intellect.mongo.service.PatientService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/patient")
public class PatientController {

	@Autowired
	PatientService patientService;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping(value = "")
	public ResponseEntity<PatientDto> addNewPatient(@RequestBody PatientDto patientDto) throws ServiceException {
		logger.info("Adding New Patient");
		return ResponseEntity.status(HttpStatus.OK).body(patientService.addPatient(patientDto));
	}

	@GetMapping(value = "")
	public ResponseEntity<List<PatientDto>> getAllPatients() {
		logger.info("Fetching All Patient Records");
		return ResponseEntity.status(HttpStatus.OK).body(patientService.fetchAllPatients());
	}

	@GetMapping(value = "/{patientId}")
	public ResponseEntity<PatientDto> getPatient(@PathVariable String patientId) throws ServiceException {
		logger.info("Getting Patient with ID: {}.", patientId);
		return ResponseEntity.status(HttpStatus.OK).body(patientService.getPatient(patientId));
	}

	@PutMapping(value = "")
	public ResponseEntity<PatientDto> editPatient(@RequestBody PatientDto patientDto) throws ServiceException {
		return ResponseEntity.status(HttpStatus.OK).body(patientService.updatePatient(patientDto));
	}

	@DeleteMapping(value = "{patientId}")
	public ResponseEntity<List<PatientDto>> removePatient(@PathVariable String patientId) throws ServiceException {
		return ResponseEntity.status(HttpStatus.OK).body(patientService.deletePatient(patientId));
	}
}
