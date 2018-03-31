package com.sanjoksoft.service.Impl;

import com.sanjoksoft.dao.BankDao;
import com.sanjoksoft.model.Account;
import com.sanjoksoft.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class BankServiceImpl implements BankService {

    @Autowired
    private BankDao bankDao;

    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    public BankDao getBankDao() {
        return bankDao;
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Throwable.class)
    @Override
    public void transferFund(Account fromAccount, Account toAccount,
                             Double amount) throws Exception {
        log.info("Transferring Rs. " + amount + "from " + fromAccount.getAccountNumber() + " to " + toAccount.getAccountNumber());
        getBankDao().withdraw(fromAccount,  amount);
        getBankDao().deposit(toAccount, amount);
    }
}
