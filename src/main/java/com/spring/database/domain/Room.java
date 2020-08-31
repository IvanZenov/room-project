package com.spring.database.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name = "room")
public class Room extends BaseEntity {

    @Column(name = "image_url")
    private String imageUrl;

    @Column (name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @Column (name = "places")
    private int places;

    @Column (name = "price_per_night")
    private double pricePerNight;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations = new ArrayList<>();

}
