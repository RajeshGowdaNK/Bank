package com.cybrilla.demo.bank.exception;

public class InsufficientAmountException extends RuntimeException {

	
	/**
	 * custom constructor
	 * @param message the message
	 */
	public InsufficientAmountException(final String message) {
		super(message);
	}
	
	/**
	 * default constructor
	 */
	public InsufficientAmountException() {
	}
}