package com.spring.database.dao.interfaces;

import com.spring.database.dao.common.BaseDao;
import com.spring.database.domain.Reservation;
import com.spring.database.enums.ReservationStatus;

import java.util.List;

public interface ReservationDao extends BaseDao<Reservation> {

    List<Reservation> getByReservationStatus(ReservationStatus reservationStatus);

}
