package com.art.service.artist_within.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Region {
    @Id
    String name;
    String shape;
    String coords;
    String itemCategories;
}
