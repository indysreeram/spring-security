package com.sreeram.springcloud.productservice.repositories;

import com.sreeram.springcloud.productservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    public User findByEmail(String email);
}
