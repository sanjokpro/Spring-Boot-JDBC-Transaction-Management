package com.sanjoksoft.dao;

import com.sanjoksoft.model.Account;

public interface BankDao {
	public abstract void deposit(Account toAccount,Double amount)throws Exception;
	public abstract void withdraw(Account fromAccount,Double amount) throws Exception;
}
