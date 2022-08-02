package com.example.day3_showroom.service;

import com.example.day3_showroom.model.Product;
import com.example.day3_showroom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProService {
    @Autowired
    private ProductRepository proPepo;

    public List<Product> showAll(){
        return (List<Product>) proPepo.findAll();
    }

    public void save(Product product){
        proPepo.save(product);
    }

    public Optional<Product> findById(Long id){
        return proPepo.findById(id);
    }

    public void delete(Long id){
        proPepo.deleteById(id);
    }
}
