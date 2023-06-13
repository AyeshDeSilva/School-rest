package com.schoolrest.system.exception;

public class ResourseNotFoundException extends RuntimeException {


	public ResourseNotFoundException() {
	}

	public ResourseNotFoundException(String message) {
		super(message);
	}

	public ResourseNotFoundException(Throwable cause) {
		super(cause);
	}

	public ResourseNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourseNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	
}
