package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(path = "/")
    public String showAllRoomPage() {
        return "redirect:/rooms";
    }

}
