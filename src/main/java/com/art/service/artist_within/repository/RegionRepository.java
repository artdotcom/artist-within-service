package com.art.service.artist_within.repository;

import com.art.service.artist_within.model.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends CrudRepository<Region, Long> {
    List<Region> findByName(String name);
}