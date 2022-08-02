package fpt.aptech.day1_sales.repository;

import fpt.aptech.day1_sales.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
