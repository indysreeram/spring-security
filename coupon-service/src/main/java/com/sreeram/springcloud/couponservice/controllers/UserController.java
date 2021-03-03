package com.sreeram.springcloud.couponservice.controllers;

import com.sreeram.springcloud.couponservice.model.User;
import com.sreeram.springcloud.couponservice.repositories.UserRepo;
import com.sreeram.springcloud.couponservice.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    SecurityService securityService;

    @GetMapping("/showReg")
    public String showRegisterationPage(){
        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email,String password){
        final boolean loginResponse = securityService.login(email, password);

        if(loginResponse){
            return "index";
        }
        return "login";
    }

}
