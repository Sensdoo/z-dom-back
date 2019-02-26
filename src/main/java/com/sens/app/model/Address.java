package com.sens.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 10)
    private String house;

    @NotBlank
    private int maxEntrance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "street_id", nullable = false)
    @JsonManagedReference
    private Street street;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
//    @JsonManagedReference
    @JsonIgnore
    private Set<Entrance> entrances;

    public Address() {
    }

    public Address(
            @NotBlank @Size(max = 10) String house,
            @NotBlank int maxEntrance, Street street,
            Set<Entrance> entrances) {
        this.house = house;
        this.maxEntrance = maxEntrance;
        this.street = street;
        this.entrances = entrances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getMaxEntrance() {
        return maxEntrance;
    }

    public void setMaxEntrance(int maxEntrance) {
        this.maxEntrance = maxEntrance;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Set<Entrance> getEntrances() {
        return entrances;
    }

    public void setEntrances(Set<Entrance> entrances) {
        this.entrances = entrances;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", house='" + house + '\'' +
                ", maxEntrance=" + maxEntrance +
                ", street=" + street +
                ", entrances=" + entrances +
                '}';
    }
}
