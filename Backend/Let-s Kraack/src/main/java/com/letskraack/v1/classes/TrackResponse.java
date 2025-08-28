package com.letskraack.v1.classes;

import java.time.LocalDate;

public record TrackResponse(
        Long id,
        String slug,
        String title,
        String description,
        boolean isNew,
        boolean isActive,
        LocalDate createdAt,
        LocalDate updatedAt
) {}
