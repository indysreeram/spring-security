package com.sreeram.springcloud.couponservice.services;

import com.sreeram.springcloud.couponservice.model.User;
import com.sreeram.springcloud.couponservice.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    UserRepo userRepo;

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
