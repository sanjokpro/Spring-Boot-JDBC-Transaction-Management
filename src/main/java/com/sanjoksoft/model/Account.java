package com.sanjoksoft.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

	private Long accountNumber;
	private String accountType;
	private Double accountBalance;
	private String accountHolderName;
}
