package com.example.mobilelele.models;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{


    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Model> models;

    @Column
    private Instant created;

    @Column
    private Instant modified;

    @PrePersist
    public void prePersist() {
        setCreated(Instant.now());
        setModified(Instant.now());
    }

    @PreUpdate
    private void preUpdate() {
        setModified(Instant.now());
    }

    public Brand() {}

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }
}
