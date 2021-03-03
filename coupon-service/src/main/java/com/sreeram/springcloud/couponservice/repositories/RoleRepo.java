package com.sreeram.springcloud.couponservice.repositories;

import com.sreeram.springcloud.couponservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
}
