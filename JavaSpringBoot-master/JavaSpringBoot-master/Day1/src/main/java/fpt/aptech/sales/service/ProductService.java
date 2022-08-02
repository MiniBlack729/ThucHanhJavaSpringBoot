package fpt.aptech.sales.service;

import fpt.aptech.sales.model.Product;
import fpt.aptech.sales.repository.ProductRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepositoy repo;

    //hàm show all data
    public List<Product> showAll(){
        return (List<Product>) repo.findAll();
    }

    //hàm tìm theo id
    public Product getProductById(Long id){
        return repo.findById(id).get();
    }

    //hàm xóa product
    public void deleleByID(Long id){
        repo.deleteById(id);
    }

    //hàm save or update
    public void SaveOrUpdate(Product product){
        repo.save(product);
    }
}
