package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.Account;

import com.example.demo.repository.UserRepository;
import com.example.demo.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(

            @RequestParam String username,

            @RequestParam String password,

            Model model) {

        User user =
                userRepository.findByUsernameAndPassword(
                        username,
                        password
                );

        if(user != null) {

            return "redirect:/home";
        }

        model.addAttribute(
                "error",
                "Invalid Username or Password"
        );

        return "login";
    }

    @GetMapping("/home")
    public String home() {

        return "home";
    }

    @GetMapping("/accounts-page")
    public String accounts(Model model) {

        List<Account> accounts =
                accountRepository.findAll();

        model.addAttribute("accounts", accounts);

        return "accounts";
    }

}
