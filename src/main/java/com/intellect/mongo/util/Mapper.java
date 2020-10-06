package com.intellect.mongo.util;

import org.modelmapper.ModelMapper;

import com.intellect.mongo.dto.PatientDto;
import com.intellect.mongo.model.Patient;

public class Mapper {

	private ModelMapper modelMapper;
	
	public PatientDto convertEntityToDto(Patient patient)
	{
		return modelMapper.map(patient, PatientDto.class);
	}
	
	public Patient convertDtoToEntity(PatientDto patientDto)
	{
		return modelMapper.map(patientDto, Patient.class);
	}
}
