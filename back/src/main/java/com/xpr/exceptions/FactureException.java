package com.xpr.exceptions;

public class FactureException extends Exception {
	
	public FactureException(String message, Throwable cause) {
		super(message, cause);
		
	}
	
	public FactureException(String message) {
		super(message);
		
	}


}
