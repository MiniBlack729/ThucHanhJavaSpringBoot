package com.example.day3_showroom.controller;


import com.example.day3_showroom.model.Product;
import com.example.day3_showroom.service.ManuService;
import com.example.day3_showroom.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class ProductController {
    @Autowired
    private ProService proService;
    @Autowired
    private ManuService manuService;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("list",proService.showAll());
        return "index";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("manus",manuService.showAll());
        model.addAttribute("product", new Product());
        return "new";
    }

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute("product") @Valid Product product, BindingResult result){
        if(result.hasErrors()){
            return "new";
        }
        proService.save(product);
        return "redirect:/";
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
    public String update(Model model, @PathVariable("id") Long id) {
        model.addAttribute("manus",manuService.showAll());
        proService.findById(id).ifPresent( b->{
            model.addAttribute("product",b);
        });
        return "new";
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        proService.delete(id);
        return "redirect:/";
    }

}
