package fpt.aptech.accountmangerproduct.service;

import fpt.aptech.accountmangerproduct.model.Product;
import fpt.aptech.accountmangerproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    //show all product
    public List<Product> showAllProduct() { return (List<Product>) productRepo.findAll(); }

    //insert or update
    public void InsertOrUpdate(Product product) { productRepo.save(product); }

    //search product by id
    public Product getProductById(Long proId) {return productRepo.findById(proId).get(); }

    //delete product by id
    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }

    //search price
    public List<Product> findByPrice(int from, int to){
        return productRepo.findAllByPriceBetween(from, to);
    }

    //search name
    public  List<Product> findByName(String name) {return productRepo.findAllByProductnameLike(name); }
}
