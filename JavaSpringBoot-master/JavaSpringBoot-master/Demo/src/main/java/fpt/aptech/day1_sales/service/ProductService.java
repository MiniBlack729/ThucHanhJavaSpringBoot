package fpt.aptech.day1_sales.service;

import fpt.aptech.day1_sales.model.Product;
import fpt.aptech.day1_sales.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    //ham show data
    public List<Product> showAll(){
        return (List<Product>) repo.findAll();
    }

    //ham tim product theo id
    public Product getProductById(Long id){
        return repo.findById(id).get();
    }

    //ham xoa theo id
    public void delete(Long id) {
        repo.deleteById(id);
    }

    //ham save or update
    public void SaveOrUpdate(Product product){
        repo.save(product);
    }
}
