package com.cybrilla.demo.bank.controller;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybrilla.demo.bank.entity.Account;
import com.cybrilla.demo.bank.entity.Customer;
import com.cybrilla.demo.bank.entity.Payee;
import com.cybrilla.demo.bank.model.PayeeDetailsResponse;
import com.cybrilla.demo.bank.model.PayeeDto;
import com.cybrilla.demo.bank.model.UserAccountDto;
import com.cybrilla.demo.bank.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController("customer")
@RequestMapping("/v1/api")
public class CustomerController {

	@Autowired
	CustomerService customerservice;
	
	@ApiOperation(value = "Manage customer status")
	@ApiResponses(value = {
		        @ApiResponse(code = 500, message = "Server error"),
		         @ApiResponse(code = 404, message = "Service not found"),
		        @ApiResponse(code = 200, message = "Success",
		            response = Account.class) })
	@RequestMapping(method = RequestMethod.POST, value = "/customer/status", produces = {"application/json"})
	public ResponseEntity<Customer> manageCustomerStatus
	                                 (@RequestParam String identifier, @RequestParam String status) {
			
		customerservice.manageCustomerStatus( identifier, status);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.add("Custom-Header", "Manage account status");
	    return new ResponseEntity<>(responseHeaders, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Manage Payee")
	@ApiResponses(value = {
		        @ApiResponse(code = 500, message = "Server error"),
		         @ApiResponse(code = 404, message = "Service not found"),
		        @ApiResponse(code = 200, message = "Success",
		            response = PayeeDetailsResponse.class) })
	@RequestMapping(method = RequestMethod.POST, value = "/customer/payee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PayeeDetailsResponse> managePayee
	                                 (@RequestBody PayeeDto payee, @RequestParam String accountIdentifier ) {
			
		PayeeDetailsResponse respone = customerservice.managePayee(payee,accountIdentifier);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.add("Custom-Header", "Add account details");
	    return new ResponseEntity<>(respone, responseHeaders, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Manage fund")
	@ApiResponses(value = {
		        @ApiResponse(code = 500, message = "Server error"),
		         @ApiResponse(code = 404, message = "Service not found"),
		        @ApiResponse(code = 200, message = "Success",
		            response = PayeeDetailsResponse.class) })
	@RequestMapping(method = RequestMethod.POST, value = "/customer/fund", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PayeeDetailsResponse> manageFund
	                                 (@RequestParam Long  accountNumber, @RequestParam BigDecimal  amount,
	                                		 @RequestParam String accountIdentifier) {
			
		PayeeDetailsResponse respone = customerservice.fundTransfer(accountNumber, amount, accountIdentifier);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.add("Custom-Header", "Add account details");
	    return new ResponseEntity<>(respone, responseHeaders, HttpStatus.OK);
		
	}
}
