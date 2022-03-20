package com.cybrilla.demo.bank.model;

import java.math.BigDecimal;
import java.util.UUID;

import com.cybrilla.demo.bank.util.AccountType;

import lombok.Data;

@Data
public class AccountSummaryResponse {

	
	private String identifier;
	
	private Long accountNumber;

	private BigDecimal currentBalance;

	private AccountType accountType;

	private String bankName;
	
	private String customerName;
	
}
