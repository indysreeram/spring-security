package com.sreeram.springcloud.productservice.service;

import com.sreeram.springcloud.productservice.model.User;
import com.sreeram.springcloud.productservice.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepo.findByEmail(username);
        if (user == null) {
            throw  new UsernameNotFoundException("User not Found for email "+ username);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),
                user.getRoles());
    }
    }

