package com.spring.database.dao.impl;

import com.spring.database.dao.common.BaseDaoImpl;
import com.spring.database.dao.interfaces.RoomDao;
import com.spring.database.domain.Address;
import com.spring.database.domain.Room;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomDaoImpl extends BaseDaoImpl<Room> implements RoomDao {

    @Override
    public List<Room> findRoomWithParameter(Address address, int minPlaces, int maxPlaces,
                                            double minPrice, double maxPrice) {
        Session session = getSessionFactory().getCurrentSession();

        return session.createQuery("select r from Room r where (r.places between :minPlace AND :maxPlaces) " +
                "AND (r.pricePerNight between :minPrice AND :maxPrice)", Room.class).list();
    }
}
