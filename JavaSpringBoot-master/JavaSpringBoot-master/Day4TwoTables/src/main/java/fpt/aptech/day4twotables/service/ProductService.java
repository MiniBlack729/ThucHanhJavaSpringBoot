package fpt.aptech.day4twotables.service;

import fpt.aptech.day4twotables.model.Product;
import fpt.aptech.day4twotables.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    //show all product
    public List<Product> showAllProduct() { return (List<Product>) productRepo.findAll(); }

    //insert or update
    public void InsertOrUpdate(Product product) { productRepo.save(product); }

    //search product by id
    public Product getProductById(Long id) {return productRepo.findById(id).get(); }

    //delete product by id
    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }
}
