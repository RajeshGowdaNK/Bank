package com.cybrilla.demo.bank.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Rajesh NK
 *
 */
@Entity
@Table(name="BankEmployee")
@Data
public class BankEmployee {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Integer id;
	 
	 @Column(name = "first_name")
	 private String firstName;
	 
	 @Column(name = "last_name")
	 private String lastName;
	 
	 @Column(name = "employee_id")
	 private String employeeId;
	 
	 @Column(name = "created_on")
	 private LocalDateTime createdOn;

	 @Column(name = "updated_on")
	 private LocalDateTime updatedOn;
	 
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
}
