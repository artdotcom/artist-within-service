package com.art.service.artist_within.model;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@Builder
public class RoomResponse {
    private String name;
    //Base64?
    private String backgroundImage;

    private List<RegionResponse> regions;

    private HashMap<String, String> map;
}
