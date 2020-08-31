package com.spring.database.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Embeddable
public class Address {
    @Column (name = "city", nullable = false)
    private String city;

    @Column (name = "street", nullable = false)
    private String street;

    @Column (name = "streetNumber", nullable = false)
    private String numberOfStreet;
}
