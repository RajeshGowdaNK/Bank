package com.cybrilla.demo.bank.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybrilla.demo.bank.entity.Account;
import com.cybrilla.demo.bank.model.AccountSummaryResponse;
import com.cybrilla.demo.bank.model.UserAccountDto;
import com.cybrilla.demo.bank.service.AccountService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController("account")
@RequestMapping("/v1/api")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@ApiOperation(value = "Account Summary")
	@ApiResponses(value = {
		        @ApiResponse(code = 500, message = "Server error"),
		         @ApiResponse(code = 404, message = "Service not found"),
		        @ApiResponse(code = 200, message = "Successful retrieval",
		            response = AccountSummaryResponse.class, responseContainer = "List") })
	@RequestMapping(method = RequestMethod.GET, value = "/account", produces = {"application/json"})
	public ResponseEntity<AccountSummaryResponse> getAccountSummary
	                                 (@RequestParam(required=true) String identifier ) {
		
		
		AccountSummaryResponse resp = accountService.getAccountSummary(identifier);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.add("Custom-Header", "Fetch Account Details");
	    return new ResponseEntity<>(resp, responseHeaders, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Add new Account")
	@ApiResponses(value = {
		        @ApiResponse(code = 500, message = "Server error"),
		         @ApiResponse(code = 404, message = "Service not found"),
		        @ApiResponse(code = 200, message = "Success",
		            response = Account.class) })
	@RequestMapping(method = RequestMethod.POST, value = "/account", produces = {"application/json"})
	public ResponseEntity<Account> addAccountDetails
	                                 (@RequestBody UserAccountDto userAccountDto ) {
			
		Account resp = accountService.addAccountDetails(userAccountDto);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.add("Custom-Header", "Add account details");
	    return new ResponseEntity<>(resp, responseHeaders, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Manage customer account")
	@ApiResponses(value = {
		        @ApiResponse(code = 500, message = "Server error"),
		         @ApiResponse(code = 404, message = "Service not found"),
		        @ApiResponse(code = 200, message = "Success",
		            response = Account.class) })
	@RequestMapping(method = RequestMethod.POST, value = "/account/manage", produces = {"application/json"})
	public ResponseEntity<AccountSummaryResponse> manageCustomerAccount
	                                 (@RequestBody UserAccountDto userAccountDto,
	                                		 @RequestParam String identifier) {
			
		AccountSummaryResponse resp = accountService.manageAccountDetails(userAccountDto, identifier);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.add("Custom-Header", "Manage account details");
	    return new ResponseEntity<>(resp, responseHeaders, HttpStatus.OK);
		
	}
	
	
	
	
}
