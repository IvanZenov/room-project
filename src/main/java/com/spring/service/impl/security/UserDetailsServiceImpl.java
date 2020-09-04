package com.spring.service.impl.security;

import com.spring.database.dao.interfaces.UserDao;
import com.spring.database.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User doesn't exist");
        }

        //Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        //grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().name()));

        return new UserPrincipal(user);
        //return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}
