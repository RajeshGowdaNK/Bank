package com.cybrilla.demo.bank.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

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
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "identifier")
	private String identifier;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="aadhar_number")
	private String aadharNumber;
	
	@Column(name="pan_number")
	private String panNumber;
	
	@Column(name="current_address")
	private String currentAddress;
	
	@Column(name="permanent_address")
	private String permanentAddress;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	@Column(name="zip_code")
	private Integer zipCode;
	
	@Column(name="status")
	private String status;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private Set<Account> account;
	
	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;
}
