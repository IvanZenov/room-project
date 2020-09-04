package com.spring.service.interfaces;

import com.spring.database.domain.User;
import com.spring.database.enums.Role;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> findAll();

    List<User> findUsersByRole(Role role);

    User findUserById(Long id);

    User findUserByEmail(String email);

}
