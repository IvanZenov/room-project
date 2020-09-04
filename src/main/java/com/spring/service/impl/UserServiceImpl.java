package com.spring.service.impl;

import com.spring.database.dao.interfaces.UserDao;
import com.spring.database.domain.User;
import com.spring.database.enums.Role;
import com.spring.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final double DEFAULT_MONEY = 1000.0;
    private static final Role DEFAULT_ROLE = Role.USER;

    private UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional
    public void save(User user) {
        user.setMoney(DEFAULT_MONEY);
        user.setRole(DEFAULT_ROLE);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public List<User> findUsersByRole(Role role) {
        return userDao.getByRole(role);
    }

    @Override
    @Transactional
    public User findUserById (Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public User findUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}
