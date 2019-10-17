package com.art.service.artist_within.repository;

import com.art.service.artist_within.model.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends CrudRepository<Asset, Long> {
}
