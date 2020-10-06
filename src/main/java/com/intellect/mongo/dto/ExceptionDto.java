package com.intellect.mongo.dto;

public class ExceptionDto {
	private String message;
	private Throwable cause;

	/**
	 * 
	 */
	public ExceptionDto() {
		super();
	}


	/**
	 * @param message
	 * @param cause
	 */
	public ExceptionDto(String message, Throwable cause) {
		super();
		this.message = message;
		this.cause = cause;
	}

	public ExceptionDto(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the cause
	 */
	public Throwable getCause() {
		return cause;
	}

	/**
	 * @param cause the cause to set
	 */
	public void setCause(Throwable cause) {
		this.cause = cause;
	}

}
