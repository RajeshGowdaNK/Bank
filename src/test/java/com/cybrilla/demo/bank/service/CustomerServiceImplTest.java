package com.cybrilla.demo.bank.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cybrilla.demo.bank.entity.Customer;
import com.cybrilla.demo.bank.repo.AccountRepository;
import com.cybrilla.demo.bank.repo.CustomerRepository;
import com.cybrilla.demo.bank.serviceImpl.AccountServiceImpl;
import com.cybrilla.demo.bank.serviceImpl.CustomerServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	@Mock
	AccountRepository accountRepo;
	
	@Mock
	CustomerRepository customerRepo;
	
	@Test
	void testManageCustomerStatus() {
		
		String identifier = "test";
		
		Customer customer = new Customer();
		customer.setZipCode(123);
		customer.setCountry("India");
		customer.setCurrentAddress("test");
		customer.setEmailId("emailId");
		customer.setState("A");
		Mockito.when(customerRepo.findByCustomers(Mockito.anyString(), Mockito.anyString())).thenReturn(Optional.of(customer));
		customerServiceImpl.manageCustomerStatus(identifier, "A");
	}
	
}
