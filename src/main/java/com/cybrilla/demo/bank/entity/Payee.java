package com.cybrilla.demo.bank.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "payee")
public class Payee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "payee_name")
    private String payeeName;

	@Column(name = "nick_name")
	private String nickName;
	
	@Column(name="account_number")
	private Long accountNumber;

	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="ifsc_code")
	private String ifscCode;
	
	@Column(name="currency")
	private String currency;

	@Column(name="status")
	private boolean status;
	
	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;
	
	@ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;
}
