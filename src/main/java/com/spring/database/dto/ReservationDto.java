package com.spring.database.dto;

import com.spring.database.domain.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ReservationDto {
    private Long id;
    private Room room;
    private int totalDay;
    private Date arrivalDate;
    private Date checkoutDate;
    private double totalPrice;
}
