package com.cybrilla.demo.bank.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cybrilla.demo.bank.entity.Account;
import com.cybrilla.demo.bank.entity.Payee;

/**
 * 
 * @author Rajesh NK
 *
 */
@Repository
@Transactional
public interface PayeeRepository extends JpaRepository<Payee,Long> {

	Optional<Payee> findByAccountNumber(Long accountNumber);


}