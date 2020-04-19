package com.agnieszkadev.skatersapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexConroller {

    @RequestMapping
    public String indexPage() {
        return "index";
    }
}
