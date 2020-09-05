package com.spring.web.controller;

import com.spring.database.domain.Reservation;
import com.spring.database.domain.Room;
import com.spring.database.domain.User;
import com.spring.service.impl.security.UserPrincipal;
import com.spring.service.interfaces.ReservationService;
import com.spring.service.interfaces.RoomService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ReservationController {

    private final ReservationService reservationService;

    private final RoomService roomService;


    public ReservationController(ReservationService reservationService, RoomService roomService) {
        this.reservationService = reservationService;
        this.roomService = roomService;
    }

    @PostMapping(value = "/rooms/{roomId}")
    public String roomReserve(@RequestParam("arrivalDate") String arrivalDate,
                              @RequestParam("checkoutDate") String checkoutDate,
                              @PathVariable("roomId") Long id,
                              @AuthenticationPrincipal UserDetails currentUser) {

        Room room = roomService.findById(id);
        UserPrincipal userPrincipal = (UserPrincipal) currentUser;
        User user = userPrincipal.getUser();
        reservationService.createReservation(room,user,arrivalDate,checkoutDate);

        return "redirect:/profile";
    }

    @GetMapping (value = "/admin/reservations")
    public String getUsersReservations(Model model) {
        List<Reservation> reservations = reservationService.findAll();
        model.addAttribute("reservations",reservations);
        return "admin-reservations";
    }

    @PostMapping (value = "/admin/reservations")
    public String changeReservationStatus() {
        return "admin-reservations";
    }
}
