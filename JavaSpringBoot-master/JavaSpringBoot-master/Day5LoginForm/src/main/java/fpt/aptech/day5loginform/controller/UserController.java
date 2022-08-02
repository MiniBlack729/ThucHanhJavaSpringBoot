package fpt.aptech.day5loginform.controller;

import fpt.aptech.day5loginform.model.User;
import fpt.aptech.day5loginform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        //model.addAttribute("list", userService.showAll());
        return "index";
    }

    @GetMapping("/login")
    public String viewLoginPage(){
        return "/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "register";
    }

    //register new user process | Create | Update
//    use BCryptPasswordEncoder to encode the user’s password so the password itself it not stored in database
//    (for better security) – only the hash value of the password is stored.
    @PostMapping("add_register")
    public String addRegister(@ModelAttribute("user") User user){
        //ma hoa password truoc khi save to db
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userService.InsertOrUpdate(user);
        return "redirect:/showAll";
    }

    //show All
    @GetMapping("/showAll")
    public String viewAllUsersPage(Model model){
        model.addAttribute("list", userService.showAll());
        return "showAll";
    }

    //delete by id
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteByID(id);
        return "redirect:/showAll";
    }
}
