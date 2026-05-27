package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public List<Account> getAllAccounts() {

        return accountRepository.findAll();
    }

    @PostMapping
    public Account createAccount(
            @RequestBody Account account) {

        return accountRepository.save(account);
    }

    @GetMapping("/{id}")
    public Account getAccountById(
            @PathVariable int id) {

        return accountRepository.findById(id)
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Account updateAccount(

            @PathVariable int id,

            @RequestBody Account updatedAccount) {

        Account account =
                accountRepository.findById(id)
                        .orElse(null);

        if(account != null) {

            account.setAccountNumber(
                    updatedAccount.getAccountNumber());

            account.setCustomerName(
                    updatedAccount.getCustomerName());

            account.setBalance(
                    updatedAccount.getBalance());

            account.setAccountType(
                    updatedAccount.getAccountType());

            return accountRepository.save(account);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(
            @PathVariable int id) {

        accountRepository.deleteById(id);

        return "Account Deleted Successfully";
    }
}
