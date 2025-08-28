package com.letskraack.v1.controller;


import com.letskraack.v1.classes.TrackRequest;
import com.letskraack.v1.classes.TrackResponse;
import com.letskraack.v1.services.TrackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tracks")
public class TrackController {
    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping
    public TrackResponse create(@RequestBody TrackRequest trackRequest){
        return trackService.createTrack(trackRequest);
    }

    @GetMapping
    public List<TrackResponse> findAll(){
        return trackService.getAllTracks();
    }

    @GetMapping("/id/{id}")
    public TrackResponse getOneById(@PathVariable Long id){
        return trackService.getTrackById(id);
    }

    @GetMapping("/{slug}")
    public TrackResponse getOneBySlug(@PathVariable String slug){
        return trackService.getTrackBySlug(slug);
    }

    @PutMapping("/{id}")
    public TrackResponse update(@PathVariable Long id, @RequestBody TrackRequest trackRequest){
        return trackService.updateTrack(id, trackRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        trackService.deleteTrackById(id);
    }
}
