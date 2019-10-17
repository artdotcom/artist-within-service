package com.art.service.artist_within.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Asset {
    @Id
    @GeneratedValue
    Long key;
    String imagePath;
    String altText;
    String url;
    String itemCategory;
}
