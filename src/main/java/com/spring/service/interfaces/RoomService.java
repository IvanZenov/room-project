package com.spring.service.interfaces;

import com.spring.database.domain.Room;

import java.util.List;


public interface RoomService {
    void save(Room room);

    List<Room> findAll();

    Room findById(Long id);

    void delete(String id);

    List<Room> findWithParameter(String city);

    void update(Room room);
}
