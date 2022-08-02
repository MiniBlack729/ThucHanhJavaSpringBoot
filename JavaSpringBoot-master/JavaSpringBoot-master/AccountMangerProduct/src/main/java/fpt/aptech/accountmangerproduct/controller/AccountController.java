package fpt.aptech.accountmangerproduct.controller;

import fpt.aptech.accountmangerproduct.model.User;
import fpt.aptech.accountmangerproduct.model.UserInRole;
import fpt.aptech.accountmangerproduct.service.RoleService;
import fpt.aptech.accountmangerproduct.service.UserInRoleService;
import fpt.aptech.accountmangerproduct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserInRoleService userInRoleService;


    @GetMapping("/")
    public String viewIndex(){
        return "index";
    }

    @GetMapping("/showAll")
    public String viewAllAccount(Model model){
        model.addAttribute("roleList", userInRoleService.findAllUserRole());
        model.addAttribute("list", userService.findAllUser());
        return "showAll";
    }

    @GetMapping("/login")
    public String viewLoginPage(){
        return "/login";
    }

    //Access denied 403
    @GetMapping("/page403")
    public String Page403() { return "/page403"; }

    //REGISTER FOR ONLY USER
    @GetMapping("/register")
    public String showRegistrationUserForm(Model model){
        model.addAttribute("user", new User()); //save data in input field into variable "user"
        return "register";
    }

    //CREATE ACCOUNT FOR ONLY ADMIN AND MANAGER
    @GetMapping("/createAdmin")
    public String showCreateAdminForm(Model model){
        model.addAttribute("role", roleService.findAll());
        model.addAttribute("user", new User()); //save data in input field into variable "user"
        return "createAdmin";
    }

    //create an account
    @PostMapping("/add_account")
    public String addRegister(@ModelAttribute("user") User user, @RequestParam("userRole") Long roleId){
        //ma hoa password truoc khi save to db
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userService.SaveOrUpdate(user);
        //add role for account
        UserInRole userInRole = new UserInRole(user.getId(), roleId);
        userInRoleService.SaveOrUpdateRole(userInRole);
        return "redirect:/showAll"; //redirect de refresh update lai data moi
    }

    //delete an account (only Admin, Manager)
    @GetMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable("id") Long userId){
        userInRoleService.deleteUserRoleByUserId(userId);
        userService.deleteUserById(userId);
        return "redirect:/showAll";
    }
}
