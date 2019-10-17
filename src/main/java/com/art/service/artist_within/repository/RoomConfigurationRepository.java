package com.art.service.artist_within.repository;

import com.art.service.artist_within.model.RoomConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomConfigurationRepository extends CrudRepository<RoomConfiguration, Long> {
    public RoomConfiguration findByConfig(String config);
}
