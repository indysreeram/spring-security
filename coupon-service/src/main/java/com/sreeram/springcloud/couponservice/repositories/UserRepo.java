package com.sreeram.springcloud.couponservice.repositories;

import com.sreeram.springcloud.couponservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    public User findByEmail(String email);

}
