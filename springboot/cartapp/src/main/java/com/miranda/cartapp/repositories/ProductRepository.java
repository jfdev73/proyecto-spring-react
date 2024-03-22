package com.miranda.cartapp.repositories;

import com.miranda.cartapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long > {
}
