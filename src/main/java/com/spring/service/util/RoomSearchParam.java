package com.spring.service.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomSearchParam {
    private String city;
    private double priceFrom;
    private double priceTo;
    private List<Integer> places;

}
