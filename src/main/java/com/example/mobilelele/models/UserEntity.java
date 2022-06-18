package com.example.mobilelele.models;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column
    private String email;

    @Column
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRole> roles = new ArrayList<>();

    @Column(name = "image_url")
    private String imageUrl;


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

    public UserEntity() {

    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
}
