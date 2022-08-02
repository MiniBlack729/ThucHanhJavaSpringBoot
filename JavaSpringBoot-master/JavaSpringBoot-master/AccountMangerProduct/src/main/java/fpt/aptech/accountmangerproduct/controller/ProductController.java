package fpt.aptech.accountmangerproduct.controller;

import fpt.aptech.accountmangerproduct.model.Product;
import fpt.aptech.accountmangerproduct.service.CategoryService;
import fpt.aptech.accountmangerproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    CategoryService categoryService;

    //show all Product
    @GetMapping("/showAllProduct")
    public String viewProductPage(Model model){
        model.addAttribute("productList", productService.showAllProduct());
        return "showAllProduct";
    }

    //create product
    @GetMapping("/createProduct")
    public String createProduct(Model model){
        model.addAttribute("catList", categoryService.findAll());//get data from select tag to insert into catList
        model.addAttribute("product", new Product());
        return "createProduct";
    }

    //update product
    @GetMapping("/updateProduct/{id}")
    public String updateProduct(Model model, @PathVariable("id") Long id){
        model.addAttribute("catList", categoryService.findAll());
        model.addAttribute("product", productService.getProductById(id));
        return "updateProduct";
    }

    //Save Insert or Update Product
    @PostMapping("/saveProduct")
    public String saveProduct(Model model, @ModelAttribute("product") Product product){
        productService.InsertOrUpdate(product);
        return "redirect:/showAllProduct";
    }

    //delete product by id
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return "redirect:/showAllProduct"; //redirect de refresh update lai data moi
    }
}
