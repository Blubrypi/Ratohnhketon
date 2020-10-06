package com.intellect.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.intellect.mongo.model.Patient;

public interface PatientRepository extends MongoRepository<Patient, String> {

}
