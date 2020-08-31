package com.spring.database.domain;

import com.spring.database.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name = "reservation")
public class Reservation extends BaseEntity {

    @OneToOne(mappedBy = "reservation")
    private Payment payment;

    @Column(name = "arrival")
    private LocalDateTime arrivalDate;

    @Column (name = "checkout")
    private LocalDateTime checkoutDate;

    @Column (name = "status")
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "user_id")
    private User user;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "room_id")
    private Room room;
}
