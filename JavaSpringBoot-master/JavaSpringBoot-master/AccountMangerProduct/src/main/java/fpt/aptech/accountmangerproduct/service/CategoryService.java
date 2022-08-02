package fpt.aptech.accountmangerproduct.service;

import fpt.aptech.accountmangerproduct.model.Category;
import fpt.aptech.accountmangerproduct.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){ return categoryRepository.findAll(); }

    public Optional<Category> finaById(Long catId){ return categoryRepository.findById(catId); }

    public void deleteCate(Long catId){ categoryRepository.deleteById(catId);}

    public void save(Category category){ categoryRepository.save(category);}
}
