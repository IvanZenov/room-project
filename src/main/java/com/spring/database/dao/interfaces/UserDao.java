package com.spring.database.dao.interfaces;

import com.spring.database.dao.common.BaseDao;
import com.spring.database.domain.User;
import com.spring.database.enums.Role;

import java.util.List;

public interface UserDao extends BaseDao<User> {
    List<User> getByRole(Role role);

    User getUserByEmail(String email);
}
