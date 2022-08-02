package fpt.aptech.accountmangerproduct.repository;

import fpt.aptech.accountmangerproduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceBetween(int from, int to);
    List<Product> findAllByProductnameLike(String name);
}
