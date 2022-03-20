package com.cybrilla.demo.bank.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybrilla.demo.bank.entity.Account;
import com.cybrilla.demo.bank.entity.Customer;
import com.cybrilla.demo.bank.entity.Payee;
import com.cybrilla.demo.bank.entity.Transaction;
import com.cybrilla.demo.bank.exception.CustomerNotFoundException;
import com.cybrilla.demo.bank.model.PayeeDetailsResponse;
import com.cybrilla.demo.bank.model.PayeeDto;
import com.cybrilla.demo.bank.repo.AccountRepository;
import com.cybrilla.demo.bank.repo.CustomerRepository;
import com.cybrilla.demo.bank.repo.PayeeRepository;
import com.cybrilla.demo.bank.repo.TransactionRepository;
import com.cybrilla.demo.bank.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Rajesh NK
 *
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PayeeRepository payeeRepository;

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private TransactionRepository transactionRepo;;

	/**
	 * Manage customer Status
	 * 
	 * @param identifier and status
	 * @return
	 */
	public void manageCustomerStatus(String identifier, String status) {

		log.info("CustomerServiceImpl: manageCustomerStatus started with request Param: {} ", identifier);

		Optional<Customer> customer = customerRepository.findByCustomers(identifier, "A");

		if (customer.isPresent()) {
			Customer customerObj = customer.get();
			customerObj.setStatus(status);
			customerRepository.save(customerObj);
			log.info("CustomerServiceImpl manageCustomerStatus ended");
		} else {
			throw new CustomerNotFoundException("Customer Not found exception");
		}
	}

	/**
	 * Manage payee details
	 * 
	 * @param payee details and account identifier
	 * @return
	 */
	@Override
	public PayeeDetailsResponse managePayee(PayeeDto payee, String accountIdentifier) {

		log.info("CustomerServiceImpl: managePayee started");
		try {

			Optional<Account> account = accountRepo.findByIdentifier(accountIdentifier);

			log.info("CustomerServiceImpl: managePayee account details successfully fecthed");

			if (account.isEmpty()) {
				throw new CustomerNotFoundException("Exception occured while adding payee details");
			}
			Optional<Payee> payeObj = payeeRepository.findByAccountNumber(payee.getAccountNumber());

			log.info("CustomerServiceImpl: managePayee payee details successfully fecthed");

			if (payeObj.isPresent()) {
				throw new CustomerNotFoundException("Payee account details already exists");

			}
			Payee payees = new Payee();

			payees.setAccountNumber(payee.getAccountNumber());
			payees.setBankName(payee.getBankName());
			payees.setCreatedOn(LocalDateTime.now());
			payees.setNickName(payee.getNickName());
			payees.setIfscCode(payee.getIfscCode());
			payees.setStatus(true);

			if (account.isPresent()) {
				Account acct = account.get();
				payees.setAccount(acct);
			}

			PayeeDetailsResponse resp = new PayeeDetailsResponse();

			resp.setMessage("Payee added successfully , please wait for sometime to activate");

			payeeRepository.save(payees);
			log.info("CustomerServiceImpl: managePayee ended");
			return resp;
		} catch (Exception e) {
			throw new CustomerNotFoundException("Exception occured while adding payee details");
		}
	}

	/**
	 * fundTransfer for payee
	 * 
	 * @param accountNumber and amount to transfer, identifier
	 * @return
	 */
	@Override
	public PayeeDetailsResponse fundTransfer(Long accountNumber, BigDecimal amt, String accountIdentifier) {

		log.info("CustomerServiceImpl: fundTransfer started");

		Optional<Payee> payeObj = payeeRepository.findByAccountNumber(accountNumber);

		Optional<Account> account = accountRepo.findByIdentifier(accountIdentifier);

		Transaction transaction = new Transaction();

		if (!payeObj.isPresent()) {
			throw new CustomerNotFoundException("Exception occured while transfering amount to payee");
		}

		long first14 = (long) (Math.random() * 100000000000000L);

		long transactionId = 5200000000000000L + first14;

		if (account.isPresent()) {
			Account acc = account.get();
			Payee payee = payeObj.get();
			BigDecimal balance = acc.getCurrentBalance();

			if (acc.getCurrentBalance().compareTo(amt) == 1) {
				balance = balance.subtract(amt);
				transaction.setAccount(acc);
				transaction.setAmount(amt);
				transaction.setCreatedOn(LocalDateTime.now());
				transaction.setTransactionId(transactionId);
				transaction.setAccountNumber(payee.getAccountNumber());
				accountRepo.updateAccountBalance(balance, acc.getAccountNumber());
				log.info("Balance successfully updated...");
				log.info("Balance after deposit: " + balance);
				transactionRepo.save(transaction);
				log.info("Transaction details updated for account number : {}", acc.getAccountNumber());
			} else {
				System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
			}
		}

		PayeeDetailsResponse payeeDetailResp = new PayeeDetailsResponse();
		payeeDetailResp.setMessage("Deposit done");
		return payeeDetailResp;
	}

}
