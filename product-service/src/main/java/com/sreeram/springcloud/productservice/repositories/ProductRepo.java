package com.sreeram.springcloud.productservice.repositories;

import com.sreeram.springcloud.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
