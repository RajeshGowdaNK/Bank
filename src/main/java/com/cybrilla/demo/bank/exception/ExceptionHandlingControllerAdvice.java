package com.cybrilla.demo.bank.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cybrilla.demo.bank.model.ErrorResponse;
import com.cybrilla.demo.bank.util.AccountConstantUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * The Exception Handling Controller Advice class.
 *
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlingControllerAdvice extends ResponseEntityExceptionHandler {

	
	/**
	 * The application name
	 */
	@Value("${spring.application.name}")
	private String applicationName;
	
	
	/**
	 * This method handles all the exception related to not found
	 * @param ex exception
	 * @return error response
	 */
	@ExceptionHandler(value= {
			CustomerNotFoundException.class
	})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> handleNotFoundException(
			final Exception ex){
		final String responseMessage = String.format("%s", ex.getMessage());
		log.error("{}", ex.getMessage());
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setErrorMessage(responseMessage);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		
	}
	

	/**
	 * This method handles all the exception related to bad request
	 * @param ex exception
	 * @return error response
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleBadRequestException(
			final Exception ex){
		final String responseMessage = String.format(AccountConstantUtil.BAD_REQUEST_EXCEPTION_MSG + "%s", ex.getMessage());
		log.error(AccountConstantUtil.BAD_REQUEST_EXCEPTION_MSG + "{}", ex.getMessage());
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setErrorMessage(responseMessage);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		
	}
	
	/**
	 * This method handles all the exception related to internal server
	 * @param ex exception
	 * @return error response
	 */
	@ExceptionHandler(value= {
			AccountFailedException.class
	})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorResponse> handleInternalServerErrorException(
			final Exception ex){
		final String responseMessage = String.format(AccountConstantUtil.INTERNAL_SERVER_ERROR_EXCEPTION_MSG + "%s", ex.getMessage());
		log.error(AccountConstantUtil.INTERNAL_SERVER_ERROR_EXCEPTION_MSG + "{}", ex.getMessage());
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setErrorMessage(responseMessage);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	/**
	 * This method handles all the exception related to conflict server
	 * @param ex exception
	 * @return error response
	 */
	
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<ErrorResponse> handleConflictException(
			final Exception ex){
		final String responseMessage = String.format(AccountConstantUtil.CONFLICT_MSG + "%s", ex.getMessage());
		log.error(AccountConstantUtil.CONFLICT_MSG + "{}", ex.getMessage());
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.CONFLICT.value());
		errorResponse.setErrorMessage(responseMessage);
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
		
	}

	
	
}
