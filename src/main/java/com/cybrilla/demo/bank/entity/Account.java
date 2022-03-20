package com.cybrilla.demo.bank.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cybrilla.demo.bank.util.AccountType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Rajesh NK
 *
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "identifier")
	private String identifier;

	@Column(name = "account_number")
    private Long accountNumber;

	@Column(name = "current_balance")
	private BigDecimal currentBalance = BigDecimal.ZERO;
	
	@Column(name="account_type")
	private AccountType accountType;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="currency")
	private String currency;

	@Column(name="status")
	private String status;
	
	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "account")
	@JsonManagedReference
	private Set<Payee> payee;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonManagedReference
    @JoinColumn(name="customer_id")
    private Customer customer;
	 
}