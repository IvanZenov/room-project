package com.spring.service.impl;

import com.spring.database.dao.interfaces.ReservationDao;
import com.spring.database.domain.Reservation;
import com.spring.database.domain.Room;
import com.spring.database.domain.User;
import com.spring.database.enums.ReservationStatus;
import com.spring.service.interfaces.ReservationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao reservationDao;

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public ReservationServiceImpl(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    @Override
    public void save(Reservation reservation) {
        reservation.setStatus(ReservationStatus.NOT_CONSIDERED);
        reservationDao.save(reservation);
    }

    @Override
    public void createReservation(Room room, User user, String arrivalDate, String checkoutDate) {

        Date arrival = null;
        Date checkout = null;
        try {
            arrival = parseDate(arrivalDate);
            checkout = parseDate(checkoutDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        reservationDao.saveReservation(room,user,arrival,checkout);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }

    private Date parseDate(String date) throws ParseException {
        java.util.Date parse = formatter.parse(date);
        return new java.sql.Date(parse.getTime());
    }
}
