package com.spring.database.dao.interfaces;

import com.spring.database.dao.common.BaseDao;
import com.spring.database.domain.Address;
import com.spring.database.domain.Room;

import java.util.List;

public interface RoomDao extends BaseDao<Room> {
    List<Room> findRoomWithParameter (Address address, int minPlaces, int maxPlaces,
                                      double minPrice, double maxPrice);
}
