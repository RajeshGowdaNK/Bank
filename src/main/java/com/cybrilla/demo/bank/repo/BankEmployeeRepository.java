package com.cybrilla.demo.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
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
public interface BankEmployeeRepository extends JpaRepository<Account,Long> {


}
