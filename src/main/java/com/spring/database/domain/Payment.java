package com.spring.database.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "payment")
public class Payment extends BaseEntity {

    @Column(name = "money")
    private double finalPrice;

    @Column (name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

}
