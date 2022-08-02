package fpt.aptech.sales.repository;

import fpt.aptech.sales.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepositoy extends CrudRepository<Product, Long> {

}
