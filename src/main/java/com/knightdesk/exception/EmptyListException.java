package com.knightdesk.exception;

public class EmptyListException extends RuntimeException {

	private static final long serialVersionUID = -8821025724985576131L;

	public EmptyListException() {
		super();
	}

	public EmptyListException(String message) {
		super(message);
	}
	
	

}
