package com.example.accountservice.controller;

import com.example.accountservice.dto.PaymentDto;
import com.example.accountservice.entity.Account;
import com.example.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PostMapping("/debit")
    public String createAccountByClientId(@RequestBody PaymentDto paymentDto) {
        Long clientId = paymentDto.getClientId();
        double amount = paymentDto.getAmount();
        if (accountService.debitAccount(clientId, amount)) {
            return "Payment successful";
        }
        return "Payment failed";
    }

    @GetMapping("/{clientId}")
    public Account getAccountByClientId(@PathVariable Long clientId) {
        return accountService.getAccountByClientId(clientId);
    }

    @GetMapping("/{clientId}/balance")
    public double getAccountBalance(@PathVariable Long clientId) {
        return accountService.getAccountByClientId(clientId).getBalance();
    }

    @PutMapping("/{clientId}/balance")
    public Account updateAccountBalance(@PathVariable Long clientId, @RequestBody double newBalance) {
        return accountService.updateAccountBalance(clientId, newBalance);
    }
}