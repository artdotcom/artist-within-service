package com.art.service.artist_within.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RegionResponse {
    private String name;
    private String shape;
    private List<Integer> coords;
    private List<ItemCategory> allowedCategories;
}
