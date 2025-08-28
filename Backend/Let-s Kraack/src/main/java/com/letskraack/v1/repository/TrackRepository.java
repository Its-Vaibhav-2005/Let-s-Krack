package com.letskraack.v1.repository;

import com.letskraack.v1.entities.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<TrackEntity, Long> {
    Optional<TrackEntity> findBySlug(String slug);
}
