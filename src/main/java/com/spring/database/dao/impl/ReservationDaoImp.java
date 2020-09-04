package com.spring.database.dao.impl;

import com.spring.database.dao.common.BaseDaoImpl;
import com.spring.database.dao.interfaces.ReservationDao;
import com.spring.database.domain.Reservation;
import com.spring.database.domain.Room;
import com.spring.database.domain.User;
import com.spring.database.enums.ReservationStatus;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public class ReservationDaoImp extends BaseDaoImpl<Reservation> implements ReservationDao {


    @Override
    public List<Reservation> getByReservationStatus(ReservationStatus reservationStatus) {
        Session session = getSessionFactory().getCurrentSession();

        return session.createQuery("select r from Reservation r where r.status =: reservStatus", Reservation.class)
                .setParameter("reservStatus", reservationStatus.toString())
                .list();
    }

    @Override
    public void saveReservation(Room room, User user, Date arrivalDate, Date checkoutDate) {
        Reservation reservation = new Reservation();

        reservation.setRoom(room);
        reservation.setUser(user);
        reservation.setArrivalDate(arrivalDate);
        reservation.setCheckoutDate(checkoutDate);
        reservation.setStatus(ReservationStatus.NOT_CONSIDERED);

        Session session = getSessionFactory().getCurrentSession();
        session.save(reservation);

    }

}
