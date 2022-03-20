package com.cybrilla.demo.bank.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cybrilla.demo.bank.entity.Account;
import com.cybrilla.demo.bank.entity.Customer;

/**
 * 
 * @author Rajesh NK
 *
 */
@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer,Long> {

	Optional<Customer> findByIdentifier(String identifier);

	@Query("select c from Customer c where c.identifier=:identifier and c.status=:status")
	Optional<Customer> findByCustomers(@Param("identifier") String identifier,
			@Param("status")  String status);

}
