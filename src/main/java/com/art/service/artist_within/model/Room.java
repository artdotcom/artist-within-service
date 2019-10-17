package com.art.service.artist_within.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Room {
    @Id
    private String name;
    //Base64?
    private String backgroundImage;

    //Comma separated values
    private String regions;
}
