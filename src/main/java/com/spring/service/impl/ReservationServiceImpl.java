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
import java.util.stream.Collectors;

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
        List<Reservation> reservations = room.getReservations();
        final Date arrival = parseDate(arrivalDate);
        final Date checkout = parseDate(checkoutDate);

        if (checkAccessToReserveRoom(reservations, arrival, checkout)) {
            reservationDao.saveReservation(room,user,arrival,checkout);
        }
    }

    @Override
    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }

    @Override
    public void update(Reservation reservation) {
        reservationDao.update(reservation);
    }

    @Override
    public Reservation findById(Long id) {
        return reservationDao.findById(id);
    }

    private boolean checkAccessToReserveRoom(List<Reservation> reservations, Date arrival, Date checkout) {
        List<Reservation> reservationList = reservations
                .stream()
                .filter(reservation -> (isWithinRange(reservation.getArrivalDate(), arrival, checkout)
                        || isWithinRange(reservation.getCheckoutDate(), arrival, checkout)))
                .collect(Collectors.toList());

        return reservationList.isEmpty();
    }

    boolean isWithinRange(Date testDate, Date startDate, Date endDate) {
        return testDate.after(startDate) && testDate.before(endDate);
    }

    private Date parseDate(String date){
        java.util.Date parse = null;
        try {
            parse = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new java.sql.Date(parse.getTime());
    }
}
