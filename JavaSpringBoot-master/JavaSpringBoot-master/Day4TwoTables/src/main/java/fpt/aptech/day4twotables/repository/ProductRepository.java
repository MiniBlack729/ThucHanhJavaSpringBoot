package fpt.aptech.day4twotables.repository;

import fpt.aptech.day4twotables.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
