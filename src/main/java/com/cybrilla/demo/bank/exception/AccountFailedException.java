package com.cybrilla.demo.bank.exception;

public class AccountFailedException extends RuntimeException {

	
	/**
	 * custom constructor
	 * @param message the message
	 */
	public AccountFailedException(final String message) {
		super(message);
	}
	
	/**
	 * default constructor
	 */
	public AccountFailedException() {
	}
}
