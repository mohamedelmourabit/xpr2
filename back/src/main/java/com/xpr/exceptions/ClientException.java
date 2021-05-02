package com.xpr.exceptions;

public class ClientException extends Exception {
	
	public ClientException(String message, Throwable cause) {
		super(message, cause);
		
	}
	
	public ClientException(String message) {
		super(message);
		
	}

}
