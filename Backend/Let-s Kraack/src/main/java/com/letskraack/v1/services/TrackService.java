package com.letskraack.v1.services;

import com.letskraack.v1.classes.TrackRequest;
import com.letskraack.v1.classes.TrackResponse;

import com.letskraack.v1.entities.TrackEntity;

import com.letskraack.v1.repository.TrackRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {
    private final   TrackRepository trackRepository;
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    private TrackResponse mapToResponse(TrackEntity entity) {
        return new TrackResponse(
                entity.getId(),
                entity.getSlug(),
                entity.getTitle(),
                entity.getDescription(),
                entity.isNew(),
                entity.isActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    // Create New Track
    public TrackResponse createTrack(TrackRequest trackRequest) {
        TrackEntity trackEntity = new TrackEntity();
        trackEntity.setSlug(trackRequest.slug());
        trackEntity.setDescription(trackRequest.description());
        trackEntity.setTitle(trackRequest.title());
        trackEntity.setNew(trackRequest.isNew());
        trackEntity.setActive(trackRequest.isActive());

        TrackEntity result = trackRepository.save(trackEntity);
        return mapToResponse(result);
    }

    // Get All Tracks
    public List<TrackResponse> getAllTracks(){
        return trackRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    // Get Track by Id
    public TrackResponse getTrackById(Long id){
        return trackRepository.findById(id).map(this::mapToResponse).orElseThrow(() -> new RuntimeException("Track not found"));
    }

    // Get Track by slug
    public TrackResponse getTrackBySlug(String slug) {
        return trackRepository.findBySlug(slug).map(this::mapToResponse).orElseThrow(() -> new RuntimeException("Track not found"));
    }

    // Update Track
    public TrackResponse updateTrack(Long id, TrackRequest trackRequest) {
        TrackEntity trackEntity = trackRepository.findById(id).orElseThrow(() -> new RuntimeException("Track not found"));
        trackEntity.setTitle(trackRequest.title());
        trackEntity.setDescription(trackRequest.description());
        trackEntity.setActive(trackRequest.isActive());
        trackEntity.setSlug(trackRequest.slug());
        trackEntity.setNew(trackRequest.isNew());
        TrackEntity result = trackRepository.save(trackEntity);
        return mapToResponse(result);
    }

    // Delete Track
    public void deleteTrackById(Long id){
        trackRepository.deleteById(id);
    }

}
