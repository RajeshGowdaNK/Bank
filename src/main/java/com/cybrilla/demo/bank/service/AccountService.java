package com.cybrilla.demo.bank.service;

import java.util.UUID;

import com.cybrilla.demo.bank.entity.Account;
import com.cybrilla.demo.bank.model.AccountSummaryResponse;
import com.cybrilla.demo.bank.model.UserAccountDto;

public interface AccountService {
	
	public AccountSummaryResponse getAccountSummary(String identifier);
	
	public Account addAccountDetails(UserAccountDto account);

	public AccountSummaryResponse manageAccountDetails(UserAccountDto userAccountDto, String identifier);
	
}
