package com.cybrilla.demo.bank.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

	
	@JsonProperty("errorCode")
	private Integer errorCode;
	
	@JsonProperty("errorMessage")
	private String errorMessage;
	
	@JsonProperty("errors")
	@Valid
	private List<FieldError> errors = null;

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<FieldError> getError() {
		return errors;
	}

	public void setError(List<FieldError> error) {
		this.errors = error;
	}
	
   public ErrorResponse errors(List<FieldError> errors) {
	  this.errors = errors;
	  return this;
  }
   
   public ErrorResponse addErrorsItem(FieldError errorItem) {
	   if(this.errors == null) {
		   this.errors = new ArrayList<>();
	   }
	   this.errors.add(errorItem);
	return null;   
   }

@Override
public int hashCode() {
	return Objects.hash(errorCode, errorMessage, errors);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ErrorResponse other = (ErrorResponse) obj;
	return Objects.equals(errorCode, other.errorCode) && Objects.equals(errorMessage, other.errorMessage)
			&& Objects.equals(errors, other.errors);
}

@Override
public String toString() {
	return "ErrorResponse [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", errors=" + errors
			+ ", getErrorCode()=" + getErrorCode() + ", getErrorMessage()=" + getErrorMessage() + ", getError()="
			+ getError() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
			+ super.toString() + "]";
}
	

}
