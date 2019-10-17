package com.art.service.artist_within.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssetResponse {
    Long key;
    String imagePath;
    String altText;
    String url;
    ItemCategory itemCategory;
}
