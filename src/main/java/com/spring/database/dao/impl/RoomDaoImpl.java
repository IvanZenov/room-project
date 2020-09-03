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
    public List<Room> findRoomWithParameter(String city) {
        Session session = getSessionFactory().getCurrentSession();


        return session.createQuery("select r from Room r where r.address.city LIKE '%"+city +"%'", Room.class)
                .list();
    }
}
