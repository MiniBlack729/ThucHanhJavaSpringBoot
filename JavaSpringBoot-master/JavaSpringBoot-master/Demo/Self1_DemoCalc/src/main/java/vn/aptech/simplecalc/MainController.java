/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.simplecalc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author havy5
 */
@Controller
public class MainController {
    @GetMapping("/")
    public String hello(Model model) {
        return "hello";
    }

    @GetMapping("/show-add")
    public String showAdd(Model model) {
        return "add";
    }

    @PostMapping("/add")
    public String processAdd(Model model, @RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = num1 + num2;
        model.addAttribute("result", result);
        return "result";
    }
}
