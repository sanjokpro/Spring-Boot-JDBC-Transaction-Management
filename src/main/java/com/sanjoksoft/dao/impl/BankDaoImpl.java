package com.sanjoksoft.dao.impl;

import com.sanjoksoft.dao.BankDao;
import com.sanjoksoft.dao.exception.InsufficientAccountBalanceException;
import com.sanjoksoft.dao.mapper.AccountRowMapper;
import com.sanjoksoft.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class BankDaoImpl implements BankDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void withdraw(Account fromAccount,Double amount) throws Exception {

        Account accountFromDb = getAccountFromDb(fromAccount.getAccountNumber());

        Double accountBalance = accountFromDb.getAccountBalance() - amount;
        if (accountFromDb.getAccountBalance() >= amount) {
            String SQL = "UPDATE icici_bank SET account_balance=? WHERE account_no=?";
            int update = getJdbcTemplate().update(SQL, accountBalance,
                    fromAccount.getAccountNumber());
            if (update > 0) {
                log.info("Amount Rs:" + amount
                        + " is deducted from Account No:"
                        + fromAccount.getAccountNumber());
            }
        } else {
            throw new InsufficientAccountBalanceException("Insufficient account balance");
        }
    }

    @Override
    public void deposit(Account toAccount, Double amount) throws Exception {
        Account accountFromDb = getAccountFromDb(toAccount.getAccountNumber());
        Double accountBalance = accountFromDb.getAccountBalance() + amount;
        String SQL = "UPDATE icici_bank SET account_balance=? WHERE account_no=?";
        int update = getJdbcTemplate().update(SQL, accountBalance, toAccount.getAccountNumber());
        if (update > 0) {
            log.info("Amount Rs:" + amount + " is deposited in Account No:" + toAccount.getAccountNumber());
        }
    }

    private Account getAccountFromDb(Long accountNumber) throws Exception {
        try {
            String SQL = "SELECT * FROM icici_bank WHERE account_no = ?";
            Account account = getJdbcTemplate().queryForObject(SQL, new AccountRowMapper(), accountNumber);
            return account;
        } catch (EmptyResultDataAccessException e) {
            throw new Exception("sorry, यो खाता नम्बर  छैन");
        }
    }

}
