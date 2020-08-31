package com.spring.database.dao.impl;

import com.spring.database.dao.common.BaseDaoImpl;
import com.spring.database.dao.interfaces.ReservationDao;
import com.spring.database.domain.Reservation;
import com.spring.database.enums.ReservationStatus;
import org.hibernate.Session;

import java.util.List;

public class ReservationDaoImp extends BaseDaoImpl<Reservation> implements ReservationDao {
    @Override
    public List<Reservation> getByReservationStatus(ReservationStatus reservationStatus) {
        Session session = getSessionFactory().getCurrentSession();

        return session.createQuery("select r from Reservation r where r.status =: reservStatus", Reservation.class)
                .setParameter("reservStatus", reservationStatus.toString())
                .list();
    }
}
