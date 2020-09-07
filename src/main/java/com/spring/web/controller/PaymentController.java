package com.spring.web.controller;

import com.spring.database.domain.Payment;
import com.spring.database.domain.Reservation;
import com.spring.database.dto.ReservationDto;
import com.spring.service.interfaces.PaymentService;
import com.spring.service.interfaces.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    private final ReservationService reservationService;
    private final PaymentService paymentService;

    public PaymentController(ReservationService reservationService, PaymentService paymentService) {
        this.reservationService = reservationService;
        this.paymentService = paymentService;
    }

    @GetMapping(path = "/payment/{reservationId}")
    public String paymentPage(Model model,
                              @PathVariable("reservationId") Long reservationId) {
        Reservation found = reservationService.findById(reservationId);
        ReservationDto foundDto = reservationService.getReservationDtoInfo(found);

        model.addAttribute("reservation", foundDto);
        return "checkout";
    }

    @PostMapping(path = "/payment")
    public String payReservation(@RequestParam Long reservationId) {
        Reservation found = reservationService.findById(reservationId);
        ReservationDto foundDto = reservationService.getReservationDtoInfo(found);
        Payment payment = new Payment();
        payment.setReservation(found);
        payment.setFinalPrice(foundDto.getTotalPrice());
        payment.setDescription("User " + found.getUser().getEmail() + " payed room" + found.getRoom().getName());

        paymentService.save(payment);

        return "redirect:/profile";
    }

}
