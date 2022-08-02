package fpt.aptech.day1_sales.controller;

import fpt.aptech.day1_sales.model.Product;
import fpt.aptech.day1_sales.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listProducts",productService.showAll());
        return "index";
    }

    @GetMapping("/new")
    public String saveProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new";
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(Model model, @ModelAttribute("product") Product product){
        try{
            productService.SaveOrUpdate(product);
        }catch (Exception e) {
            e.fillInStackTrace();
        }
        return "redirect:/";
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
    public String update(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productService.getProductById(id));
        return "new";
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/";
    }

}
