package com.cybrilla.demo.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybrilla.demo.bank.entity.Account;
import com.cybrilla.demo.bank.entity.Transaction;

/**
 * 
 * @author Rajesh NK
 *
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {


}
