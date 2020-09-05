package com.spring.service.impl;

import com.spring.database.dao.interfaces.RoomDao;
import com.spring.database.domain.Room;
import com.spring.service.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    private final RoomDao roomDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public void save(Room room) {
        roomDao.save(room);
    }

    @Override
    public List<Room> findAll() {
        return roomDao.findAll();
    }

    @Override
    public Room findById(Long id) {
        return roomDao.findById(id);
    }

    @Override
    public void delete(String stringId) {
        Long id = Long.valueOf(stringId);
        roomDao.delete(id);
    }

    @Override
    public List<Room> findWithParameter(String city) {
        if (city==null){
            return roomDao.findAll();
        }
        else {
            return roomDao.findRoomWithParameter(city);
        }
    }

}
