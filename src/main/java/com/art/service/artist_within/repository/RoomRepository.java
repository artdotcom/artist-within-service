package com.art.service.artist_within.repository;

import com.art.service.artist_within.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    public Room findByName(String name);
}