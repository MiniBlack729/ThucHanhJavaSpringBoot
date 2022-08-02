package fpt.aptech.universityapp.controller;

import fpt.aptech.universityapp.model.Employee;
import fpt.aptech.universityapp.service.departmentService;
import fpt.aptech.universityapp.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private departmentService departmentService;
    @Autowired
    private employeeService employeeService;
    @GetMapping("/")
    public String index(Model model){
        List<Employee>employees=employeeService.findAll();
        model.addAttribute("employees",employees);
        return "index";
    }
    @RequestMapping("/create")
    public String create(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        model.addAttribute("department",departmentService.findAll());
        return "create";
    }
    @RequestMapping("/save")
    public String save(@Validated @ModelAttribute("employee")Employee employee, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("department",departmentService.findAll());
            return "/create";
        }
        employeeService.save(employee);
        return "redirect:/";
    }
}
