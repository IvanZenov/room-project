package com.spring.database.dao.interfaces;

import com.spring.database.dao.common.BaseDao;
import com.spring.database.domain.Reservation;
import com.spring.database.domain.Room;
import com.spring.database.domain.User;
import com.spring.database.enums.ReservationStatus;

import java.sql.Date;
import java.util.List;

public interface ReservationDao extends BaseDao<Reservation> {

    List<Reservation> getByReservationStatus(ReservationStatus reservationStatus);

    void saveReservation(Room room, User user, Date arrivalDate, Date checkoutDate);

}
