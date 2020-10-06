package com.intellect.mongo.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.intellect.mongo.controller.PatientController;
import com.intellect.mongo.dto.ExceptionDto;
import com.intellect.mongo.exception.ServiceException;

@RestControllerAdvice(assignableTypes = { PatientController.class})
public class ControllerExceptionHandler {
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ExceptionDto> serviceExceptionHandler(Exception e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto(e.getMessage()));
	}
}

