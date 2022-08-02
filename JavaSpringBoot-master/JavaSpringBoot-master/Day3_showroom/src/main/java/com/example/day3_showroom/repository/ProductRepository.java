package com.example.day3_showroom.repository;

import com.example.day3_showroom.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
