package com.art.service.artist_within.controller;

import com.amazonaws.services.kms.model.NotFoundException;
import com.art.service.artist_within.model.*;
import com.art.service.artist_within.repository.AssetRepository;
import com.art.service.artist_within.repository.RegionRepository;
import com.art.service.artist_within.repository.RoomConfigurationRepository;
import com.art.service.artist_within.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@Slf4j
public class ArtistWithinController {
    @Autowired
    AssetRepository assetRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    RoomConfigurationRepository roomConfigurationRepository;

    @GetMapping(value = "/v1/assets")
    @ResponseBody
    public List<AssetResponse> getAssets() {
        return StreamSupport.stream(assetRepository.findAll().spliterator(), false)
                .map(this::getAssetResponse)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/v1/rooms")
    @ResponseBody
    public List<RoomResponse> getRooms() {
        return StreamSupport.stream(roomRepository.findAll().spliterator(), false).map(this::getRoomResponse).collect(Collectors.toList());
    }

    @PostMapping(value = "/v1/rooms")
    @ResponseBody
    private RoomResponse assignRegions(@RequestBody HashMap<String, String> roomMap) {
        RoomConfiguration roomConfiguration = roomConfigurationRepository.findByConfig(mapToConfigString(roomMap));
        if(roomConfiguration == null) {
            throw new NotFoundException("Invalid room configuration");
        }

        Room room = roomRepository.findByName("defaultRoom");
        RoomResponse roomResponse = getRoomResponse(room);
        roomResponse.setMap(roomMap);
        roomResponse.setBackgroundImage(roomConfiguration.getImageId());
        return roomResponse;
    }

    @GetMapping(value = "image/{id}", produces = {"application/json"})
    public ResponseEntity<byte[]> image(@PathVariable("id") String id) throws IOException {
        Resource resource = new ClassPathResource(String.format("images/Canvas_%s-adjust.png", id));
        byte[] media = IOUtils.toByteArray(resource.getInputStream());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(media);
    }

    private RoomResponse getRoomResponse(Room room) {
        List<RegionResponse> regions = Stream
                .of(room.getRegions().split(","))
                .map(String::trim)
                .map(region -> regionRepository.findByName(region).get(0))
                .map(this::getRegionResponse)
                .collect(Collectors.toList());
        return RoomResponse.builder()
                .name(room.getName())
                .backgroundImage(room.getBackgroundImage())
                .regions(regions)
                .build();
    }

    private RegionResponse getRegionResponse(Region region) {
        List<Integer> coords = Stream
                .of(region.getCoords().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<ItemCategory> categories = Stream
                .of(region.getItemCategories().split(","))
                .map(String::trim)
                .map(ItemCategory::valueOf)
                .collect(Collectors.toList());
        return RegionResponse.builder()
                .name(region.getName())
                .shape(region.getShape())
                .allowedCategories(categories)
                .coords(coords)
                .build();
    }

    private AssetResponse getAssetResponse(Asset asset) {
        return AssetResponse.builder()
                .altText(asset.getAltText())
                .imagePath(asset.getImagePath())
                .key(asset.getKey())
                .url(asset.getUrl())
                .itemCategory(ItemCategory.valueOf(asset.getItemCategory()))
                .build();
    }

    private String mapToConfigString(HashMap<String, String> roomMap) {
        return roomMap
                .entrySet()
                .stream()
                .sorted()
                .map(entry -> String.format("%s:%s", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(","));
    }
}
