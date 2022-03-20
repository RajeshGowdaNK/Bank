package com.cybrilla.demo.bank.model;

import lombok.Data;

@Data
public class PayeeDto {

	private String payeeName;

	private String nickName;

	private Long accountNumber;

	private String bankName;

	private String ifscCode;

	private String currency;

	private boolean status;

}
