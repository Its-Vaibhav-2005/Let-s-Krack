package com.letskraack.v1.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Tracks")
public class TrackEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean isNew = true;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean isActive = true;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private LocalDate updatedAt;

    // -------------- Getter Setter --------------------
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getSlug() {return slug;}
    public void setSlug(String slug) {this.slug = slug;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public boolean isNew() {return isNew;}
    public void setNew(boolean aNew) {this.isNew = aNew;}

    public boolean isActive() {return isActive;}
    public void setActive(boolean aActive) {this.isActive = aActive;}

    public LocalDate getCreatedAt() {return createdAt;}
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public LocalDate getUpdatedAt() {return updatedAt;}
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDate.now();
    }
}
