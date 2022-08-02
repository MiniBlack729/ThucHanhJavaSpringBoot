package fpt.aptech.sales.controller;

import fpt.aptech.sales.model.Product;
import fpt.aptech.sales.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    //định nghĩa route
    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Product> productList = productService.showAll();
        model.addAttribute("list", productList);
        return "index";
    }

    //Annotation RequestMapping(/) xác định phương thức index() sẽ đón nhận các request có HTTP method là GET và URI pattern là /
    //method post để save
    @PostMapping ("/save")
    public String saveProduct(@ModelAttribute("product")Product product){
        productService.SaveOrUpdate(product);//create or update
        return "redirect:/"; //trả về trang index showAll
    }

    //Create
    @GetMapping("/create")
    public String createProduct(Model model){ //iport thư viện Model để add product
        model.addAttribute("product", new Product());//save các value bên form create vào biến product sau đó add new
        return "create"; //trả về trang create để input
    }

    //DELETE
    //lấy value ra, method get
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){//@PathVariable được sử dụng để trích xuất {id} từ đường dẫn URL
        productService.deleleByID(id);
        return "redirect:/"; //trả về trang index showAll
    }
}
