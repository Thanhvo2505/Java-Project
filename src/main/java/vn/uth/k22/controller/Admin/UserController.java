package vn.uth.k22.controller.Admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vn.uth.k22.domain.User;
import vn.uth.k22.service.UserService;




@Controller
public class UserController {
    private final UserService userService; 

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    // admin view all users
    @GetMapping("/admin/user")
    public String getAllUserPage(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("users", users);
        return "/admin/user/show";
    }

    // admin view detail user by id
    @GetMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable("id") long id ) {
        User user = this.userService.getUserById(id);
        // System.out.println(user);
        model.addAttribute("user", user);
        return "/admin/user/detail";
    }

    //admin get form create user
    @GetMapping("/admin/user/create")
    public String getCreateUserFormPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create" ;
    }
    
    // post create user
    @PostMapping("/admin/user/create")
    public String postCreatUser(@ModelAttribute("newUser") User user) {
        User newUser = this.userService.saveUser(user);
        return "redirect:/admin/user/show";
    }
    
    



}



