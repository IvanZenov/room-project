package com.spring.database.domain;

import com.spring.database.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name = "users")
public class User extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column (name = "second_name")
    private String secondName;

    @Column (name = "email", nullable = false, unique = true)
    private String email;

    @Column (name = "password", nullable = false)
    private String password;

    @Column (name = "phone_number")
    private String phoneNumber;

    @Column (name = "status")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column (name = "money")
    private double money;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private Set<Reservation> reservations = new HashSet<>();
}
