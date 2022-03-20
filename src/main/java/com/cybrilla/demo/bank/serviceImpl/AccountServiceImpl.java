package com.cybrilla.demo.bank.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybrilla.demo.bank.entity.Account;
import com.cybrilla.demo.bank.entity.Customer;
import com.cybrilla.demo.bank.exception.AccountFailedException;
import com.cybrilla.demo.bank.exception.CustomerNotFoundException;
import com.cybrilla.demo.bank.model.AccountSummaryResponse;
import com.cybrilla.demo.bank.model.UserAccountDto;
import com.cybrilla.demo.bank.repo.AccountRepository;
import com.cybrilla.demo.bank.repo.CustomerRepository;
import com.cybrilla.demo.bank.service.AccountService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Rajesh NK
 *
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private CustomerRepository customerRepo;

	/**
	 * Get account details for the customer using account identifier
	 * 
	 * @param identifier for account
	 * @return AccountSummaryResponse
	 */
	@Override
	public AccountSummaryResponse getAccountSummary(String identifier) {

		log.info("AccountServiceImpl getAccountSummary started with request Param: {} ", identifier);
		Optional<Account> account = accountRepo.findByIdentifier(identifier);

		AccountSummaryResponse response = new AccountSummaryResponse();

		if (account.isPresent()) {
			Account accountObj = account.get();
			response.setAccountNumber(accountObj.getAccountNumber());
			response.setAccountType(accountObj.getAccountType());
			response.setBankName(accountObj.getBankName());
			response.setCurrentBalance(accountObj.getCurrentBalance());
			response.setCustomerName(accountObj.getCustomer().getCustomerName());
			response.setIdentifier(accountObj.getIdentifier());
			log.info("AccountServiceImpl getAccountSummary ended");
			return response;
		} else {
			throw new CustomerNotFoundException("Account Not found,Invalid details");
		}

	}

	/**
	 * add account details for the customer
	 * 
	 * @param User and Account details for account
	 * @return Account
	 */
	@Override
	public Account addAccountDetails(UserAccountDto userAccountDto) {

		log.info("AccountServiceImpl addAccountDetails started with request Param: {} ", userAccountDto);

		long first14 = (long) (Math.random() * 100000000000000L);

		String random1 = UUID.randomUUID().toString();
		random1 = random1.replaceAll("-", "");
		random1 = random1.substring(0, 16);

		long accountNumber = 5200000000000000L + first14;
		try {

			String random = UUID.randomUUID().toString();
			random = random.replaceAll("-", "");
			random = random.substring(0, 16);

			Account account = new Account();
			account.setAccountNumber(accountNumber);
			account.setAccountType(userAccountDto.getAccountType());
			account.setBankName(userAccountDto.getBankName());
			account.setStatus("A");
			account.setCreatedOn(LocalDateTime.now());
			account.setCurrentBalance(userAccountDto.getCurrentBalance());
			account.setIdentifier(random);

			Customer customer = new Customer();

			customer.setAadharNumber(userAccountDto.getAadharNumber());
			customer.setPanNumber(userAccountDto.getPanNumber());
			customer.setCustomerName(userAccountDto.getCustomerName());
			customer.setEmailId(userAccountDto.getEmailId());
			customer.setMobileNumber(userAccountDto.getMobileNumber());
			customer.setPermanentAddress(userAccountDto.getPermanentAddress());
			customer.setState(userAccountDto.getState());
			customer.setCity(userAccountDto.getCity());
			customer.setZipCode(userAccountDto.getZipCode());
			customer.setCreatedOn(LocalDateTime.now());
			customer.setIdentifier(random1);
			customer.setStatus("A");

			customer = customerRepo.save(customer);
			account.setCustomer(customer);

			Account accnt = accountRepo.save(account);
			log.info("AccountServiceImpl addAccountDetails ended");
			return accnt;
		} catch (Exception ex) {
			throw new AccountFailedException(ex.getMessage());
		}

	}

	/**
	 * manage account details for the customer
	 * 
	 * @param User and Account details for account and identifier
	 * @return AccountSummaryResponse
	 */
	@Override
	public AccountSummaryResponse manageAccountDetails(UserAccountDto userAccountDto, String identifier) {

		log.info("AccountServiceImpl addAccountDetails started");
		try {
			Optional<Customer> customer = customerRepo.findByIdentifier(identifier);

			log.info("AccountServiceImpl addAccountDetails customer details fetched");

			long first14 = (long) (Math.random() * 100000000000000L);

			long accountNumber = 5200000000000000L + first14;

			Account account = new Account();

			AccountSummaryResponse response = new AccountSummaryResponse();

			if (customer.isPresent()) {
				Customer custObj = customer.get();
				account.setAccountNumber(accountNumber);
				account.setAccountType(userAccountDto.getAccountType());
				account.setBankName(userAccountDto.getBankName());
				account.setStatus("A");
				account.setCreatedOn(LocalDateTime.now());

				String random1 = UUID.randomUUID().toString();
				random1 = random1.replaceAll("-", "");
				random1 = random1.substring(0, 16);
				account.setIdentifier(random1);
				account.setCustomer(custObj);
				account = accountRepo.save(account);
			}
			response.setAccountNumber(account.getAccountNumber());
			response.setAccountType(account.getAccountType());
			response.setBankName(account.getBankName());
			response.setCurrentBalance(account.getCurrentBalance());
			response.setCustomerName(account.getCustomer().getCustomerName());
			response.setIdentifier(account.getIdentifier());
			log.info("AccountServiceImpl addAccountDetails ended");
			return response;
		} catch (Exception ex) {
			throw new AccountFailedException(ex.getMessage());
		}

	}

}
