package com.agnieszkadev.skatersapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login-form";
    }

    @GetMapping("/showMyAccessDeniedPage")
    public String showMyAccessDeniedPage() {
        return "access-denied";
    }
}
