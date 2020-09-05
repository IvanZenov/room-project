package com.spring.web.controller;

import com.spring.database.domain.Reservation;
import com.spring.database.domain.User;
import com.spring.service.impl.security.UserPrincipal;
import com.spring.service.interfaces.SecurityService;
import com.spring.service.interfaces.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;

    private final SecurityService securityService;

    public UserController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String createNewUser(User user) {
        userService.save(user);
        securityService.autoLogin(user.getEmail(),user.getPassword());
        return "redirect:/rooms";
    }

    @GetMapping(value = "/profile")
    public String profile(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        //TODO: fix this moment
        /*
        UserPrincipal userPrincipal = (UserPrincipal) currentUser;
        User user = userPrincipal.getUser();
         */
        String email = currentUser.getUsername();
        Set<Reservation> reservations = userService.findUserByEmail(email).getReservations();

        model.addAttribute("reservations", reservations);
        return "profile";
    }
}
