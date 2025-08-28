package com.letskraack.v1.classes;

import java.time.LocalDate;

public record TrackRequest(
        String slug,
        String title,
        String description,
        boolean isNew,
        boolean isActive
) {}
