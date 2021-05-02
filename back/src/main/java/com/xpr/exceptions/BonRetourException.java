package com.xpr.exceptions;

public class BonRetourException extends Exception {
	
	public BonRetourException(String message, Throwable cause) {
		super(message, cause);
		
	}
	
	public BonRetourException(String message) {
		super(message);
		
	}

}
