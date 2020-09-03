package com.spring.database.dao.impl;

import com.spring.database.dao.common.BaseDaoImpl;
import com.spring.database.dao.interfaces.UserDao;
import com.spring.database.domain.User;
import com.spring.database.enums.Role;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    @Override
    public List<User> getByRole(Role role) {
        Session session = getSessionFactory().getCurrentSession();

        return session.createQuery("select u from User u where u.role =: role", User.class)
                .setParameter("role", role.toString())
                .list();
    }

    @Override
    public User getUserByEmail(String email) {
        Session session = getSessionFactory().getCurrentSession();
        List<User> results = session.createQuery("select u from User u WHERE u.email =: email", User.class)
                .setParameter("email", email)
                .getResultList();

        return !results.isEmpty() ? results.get(0) : null;
    }
}
