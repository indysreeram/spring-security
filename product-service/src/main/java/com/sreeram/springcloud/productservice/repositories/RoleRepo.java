package com.sreeram.springcloud.productservice.repositories;

import com.sreeram.springcloud.productservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
}
