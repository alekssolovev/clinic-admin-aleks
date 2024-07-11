package com.springlessons.clinicadmin.controller;

import com.springlessons.clinicadmin.entity.Token;
import com.springlessons.clinicadmin.repository.ApplicationUser;
import com.springlessons.clinicadmin.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.security.auth.login.AccountException;

@Controller
@RequestMapping("/user_account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/user_registration")
    public String registration(ApplicationUser applicationUser) {
        return "user_account/registration";
    }

    @GetMapping("/login")
    public String login() {
        return "user_account/login";
    }

    @PostMapping("/user_registration")
    public String createAccount(ApplicationUser user, Model model) {
        try {
            accountService.registration(user);
            return "redirect:/user_account/login";
        } catch (AccountException e) {
            model.addAttribute("error", e.getMessage());
            return "user_account/registration";
        }
    }

    @ResponseBody
    @PostMapping("/login")
    public Token loginAccount(@RequestParam("application_user_username") String username,
                              @RequestParam("application_user_password") String password) {
        try {
            return accountService.loginAccount(username, password);
        } catch (AccountException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}