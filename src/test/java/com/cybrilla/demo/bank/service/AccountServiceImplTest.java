package com.cybrilla.demo.bank.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import com.cybrilla.demo.bank.entity.Account;
import com.cybrilla.demo.bank.entity.Customer;
import com.cybrilla.demo.bank.model.AccountSummaryResponse;
import com.cybrilla.demo.bank.model.UserAccountDto;
import com.cybrilla.demo.bank.repo.AccountRepository;
import com.cybrilla.demo.bank.repo.CustomerRepository;
import com.cybrilla.demo.bank.serviceImpl.AccountServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class AccountServiceImplTest {

	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	@Mock
	AccountRepository accountRepo;
	
	@Mock
	CustomerRepository customerRepo;
	
	@Test
	void testGetAccountSummary() {
		
		final String identifier = "test";
		
		Customer customer = new Customer();
		customer.setCustomerName("test");
		
		Account acc=new Account();
		acc.setAccountNumber(123L);
		acc.setCustomer(customer);
		
		AccountSummaryResponse expected = new AccountSummaryResponse();
		expected.setAccountNumber(123L);
		
		BigDecimal num=new BigDecimal("0"); 
		
		expected.setCurrentBalance(num);
		expected.setCustomerName("test");
		
		Mockito.when(accountRepo.findByIdentifier(identifier)).thenReturn(Optional.of(acc));
		AccountSummaryResponse actual = accountServiceImpl.getAccountSummary(identifier);
	
		assertEquals(actual, expected);
	}
	
	@Test
	void testAddAccountDetails() {
		
		Account acc=new Account();
		acc.setAccountNumber(123L);
		
		Customer customer = new Customer();
		customer.setCustomerName("test");
		customer.setIdentifier("test");
		
		acc.setCustomer(customer);
		
		Mockito.when(customerRepo.save(Mockito.any(Customer.class))).thenReturn(customer);
		Mockito.when(accountRepo.save(Mockito.any(Account.class))).thenReturn(acc);
		
		
		UserAccountDto userAccountDto = new UserAccountDto();	
		userAccountDto.setCustomerName("test");
		userAccountDto.setAccountNumber("123L");
		
		Account actual = accountServiceImpl.addAccountDetails(userAccountDto);
		
		assertEquals(actual, acc);
		
	}
	
	@Test
	void testManageAccountDetails() {
		
		UserAccountDto userAccountDto = new UserAccountDto();	
		userAccountDto.setCustomerName("test");
		userAccountDto.setAccountNumber("123L");
		
		final String identifier = "test";
		
		AccountSummaryResponse accountSummary = new AccountSummaryResponse();
		accountSummary.setAccountNumber(123L);
		accountSummary.setCustomerName("test");
		BigDecimal num=new BigDecimal("0"); 
		accountSummary.setCurrentBalance(num);
		
		Account acc=new Account();
		acc.setAccountNumber(123L);
		
		Customer customer = new Customer();
		customer.setCustomerName("test");
		customer.setIdentifier("test");		
		acc.setCustomer(customer);
		
		Mockito.when(customerRepo.findByIdentifier(identifier)).thenReturn(Optional.of(customer));
		
		Mockito.when(accountRepo.save(Mockito.any(Account.class))).thenReturn(acc);
				
		AccountSummaryResponse actual = accountServiceImpl.manageAccountDetails(userAccountDto, identifier);
				
		assertEquals(actual, accountSummary);
	}
}
