/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoBook.controller;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.aptech.demoBook.BookValidator;
import vn.aptech.demoBook.entity.Book;
import vn.aptech.demoBook.service.BookService;

/**
 * @author havy5
 */
@Controller
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private BookValidator bookValidator;

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        if (target.getClass() == Book.class) {
            dataBinder.setValidator(bookValidator);
        }
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("books", service.findAll());
        return "book/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "book/create";
    }

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute("book") @Validated Book book, BindingResult result, final RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "book/create";
        }
        try {
            service.save(book);
        } catch (Exception e) {
            e.fillInStackTrace();
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") int id) {
        service.findById(id).ifPresent(book -> {
            model.addAttribute("book", book);
        });
        return "book/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/";
    }
}
