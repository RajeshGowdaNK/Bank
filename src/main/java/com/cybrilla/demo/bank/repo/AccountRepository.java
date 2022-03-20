package com.cybrilla.demo.bank.repo;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cybrilla.demo.bank.entity.Account;

/**
 * 
 * @author Rajesh NK
 *
 */
@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account,Long> {

	Optional<Account> findByIdentifier(String identifier);

	@Transactional
	@Modifying
	@Query("update Account ac set ac.currentBalance =:balance where ac.accountNumber=:accNo")
	void updateAccountBalance(@Param("balance") BigDecimal balance, @Param("accNo") Long accNo);

}