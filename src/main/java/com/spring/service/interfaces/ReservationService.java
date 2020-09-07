package com.spring.service.interfaces;

import com.spring.database.domain.Reservation;
import com.spring.database.domain.Room;
import com.spring.database.domain.User;
import com.spring.database.dto.ReservationDto;

import java.util.List;

public interface ReservationService {
    void save(Reservation reservation);

    void createReservation(Room room, User user, String arrivalDate, String checkoutDate);

    List<Reservation> findAll();

    void update(Reservation reservation);

    Reservation findById(Long id);

    ReservationDto getReservationDtoInfo(Reservation reservation);

}
