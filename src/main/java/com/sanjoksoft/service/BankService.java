package com.sanjoksoft.service;

import com.sanjoksoft.model.Account;

public interface BankService {
	public abstract void transferFund(Account fromAccount,Account toAccount,Double amount) throws Exception;
}
