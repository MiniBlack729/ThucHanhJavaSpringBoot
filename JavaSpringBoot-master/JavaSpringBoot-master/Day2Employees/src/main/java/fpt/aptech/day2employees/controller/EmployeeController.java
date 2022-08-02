package fpt.aptech.day2employees.controller;

import fpt.aptech.day2employees.model.Employee;
import fpt.aptech.day2employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    //show all
    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Employee> employeeList = employeeService.showAll();
        model.addAttribute("list", employeeList);
        return "index";
    }

    //Create
    @GetMapping("/create")
    public String showNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.SaveOrUpdate(employee);
        return "redirect:/";
    }

    //delete employee
    @RequestMapping("delete/{id}")
    public String deleteEmp(@PathVariable("id") Long id){
        employeeService.deleleByID(id);
        return "redirect:/";
    }

    //update
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public ModelAndView updateEmp(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("update");//show trang update
        Employee emp = employeeService.getEmployeeById(id);
        mv.addObject("employee", emp);
        return mv;
    }
}
