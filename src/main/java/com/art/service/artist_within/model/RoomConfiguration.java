package com.art.service.artist_within.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class RoomConfiguration {
    @Id
    String config;
    String imageId;
}
