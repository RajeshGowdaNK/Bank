package com.cybrilla.demo.bank.model;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.cybrilla.demo.bank.util.AccountType;

import lombok.Data;

@Data
public class UserAccountDto {
	
	private String accountNumber;

	private BigDecimal currentBalance;

	private AccountType accountType;

	private String bankName;
	
	private String customerName;
	
    private String mobileNumber;

	private String emailId;
	
	private String aadharNumber;
	
	private String panNumber;
	
	private String currentAddress;
	
	private String permanentAddress;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private Integer zipCode;

}
