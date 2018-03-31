package com.sanjoksoft;

import com.sanjoksoft.model.Account;
import com.sanjoksoft.service.BankService;
import com.sanjoksoft.service.Impl.BankServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@Slf4j
public class SpringBootJdbcTransactionManagementApplication {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = SpringApplication
                .run(SpringBootJdbcTransactionManagementApplication.class, args);) {

            BankService bankService = ctx.getBean("bankServiceImpl", BankServiceImpl.class);
            Account fromAccount = new Account();
            fromAccount.setAccountNumber(42100002L);

            Account toAccount = new Account();
            toAccount.setAccountNumber(42100003L);

            bankService.transferFund(fromAccount, toAccount, 1.00);
            log.info("---------------Fund Transfer Successful----------------");
        } catch (Exception e) {
            log.error("TRANSACTION FAILED !  \n " + e.getMessage());
        }

    }
}
