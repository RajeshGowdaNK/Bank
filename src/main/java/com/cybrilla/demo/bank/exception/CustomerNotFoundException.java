package com.cybrilla.demo.bank.exception;

/**
 * 
 * The Account not found exception
 *
 */
public class CustomerNotFoundException extends RuntimeException {

	
	/**
	 * custom constructor
	 * @param message the message
	 */
	public CustomerNotFoundException(final String message) {
		super(message);
	}
	
	/**
	 * default constructor
	 */
	public CustomerNotFoundException() {
	}
}
