package fpt.aptech.day4twotables.controller;

import fpt.aptech.day4twotables.model.Product;
import fpt.aptech.day4twotables.service.ManuService;
import fpt.aptech.day4twotables.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ManuService manuService;

    //VALIDATION
    public Boolean isInterger(String s){
        if (s == null || "".equals(s.replaceAll(" ",""))) {
            return false;
        }
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public String getErrorInterger(BindingResult bindingResult, String fileCheck, String messInteger){
        ObjectError objectError = bindingResult.getFieldError(fileCheck);
        return objectError == null?null: Arrays.asList(objectError.getCodes()).contains("typeMismatch")?messInteger:
                objectError.getDefaultMessage();
    }

    //show All
    @GetMapping("/")
    public String viewIndex(Model model){
        model.addAttribute("manu", manuService.showAll());
        model.addAttribute("list", productService.showAllProduct());
        return "index";
    }

    //create with category
    @GetMapping("/create")//form method post thì dùng RequestMapping, method get thì GetMapping
    public String showNewProduct(Model model){
        Product product = new Product();
        model.addAttribute("manu", manuService.showAll());
        model.addAttribute("product", product);
        return "create";
    }

    //insert or update
    @RequestMapping(value = "/save", method = RequestMethod.POST)//form method post thì dùng RequestMapping, GetMapping chỉ method get
    public String saveProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("ErrorPrice", getErrorInterger(bindingResult, "pro_price", "price must an integer"));
            model.addAttribute("field", bindingResult);
            return "error";
        }
        productService.InsertOrUpdate(product);
        return "redirect:/";
    }

    //update
    @GetMapping("/update/{id}")
    public String updateProduct(Model model, @PathVariable("id") Long id){
        model.addAttribute("manu", manuService.showAll());
        model.addAttribute("product", productService.getProductById(id));
        return "update";
    }

    //delete product by id
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
