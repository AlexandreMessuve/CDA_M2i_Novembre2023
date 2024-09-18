package com.example.accountservice.service;

import com.example.accountservice.entity.Account;
import com.example.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountByClientId(Long clientId) {
        return accountRepository.findByClientId(clientId);
    }


    @Transactional
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Transactional
    public Account updateAccountBalance(Long clientId, double newBalance) {
        Account account = getAccountByClientId(clientId);
        if (account != null) {
            account.setBalance(newBalance);
            accountRepository.save(account);
        }
        return account;
    }

    public boolean debitAccount(Long clientId, double amount) {
        Account account = getAccountByClientId(clientId);
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);
            return true;
        }
        return false;
    }
}