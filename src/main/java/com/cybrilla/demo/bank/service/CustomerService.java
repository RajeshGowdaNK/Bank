package com.cybrilla.demo.bank.service;

import java.math.BigDecimal;
import java.util.UUID;

import com.cybrilla.demo.bank.entity.Customer;
import com.cybrilla.demo.bank.model.PayeeDetailsResponse;
import com.cybrilla.demo.bank.model.PayeeDto;


public interface CustomerService {

	void manageCustomerStatus(String identifier, String status);

	PayeeDetailsResponse managePayee(PayeeDto payee, String accountIdentifier);

	PayeeDetailsResponse fundTransfer(Long accountNumber, BigDecimal  amount, String accountIdentifier);

}
