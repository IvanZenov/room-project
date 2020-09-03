package com.spring.service.interfaces;

import com.spring.database.domain.Address;
import com.spring.database.domain.Room;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;


public interface RoomService {
    void save(Room room);

    List<Room> findAll();

    Room findById(Long id);

    void delete (String id);

    List<Room> findWithParameter(String city);
}
