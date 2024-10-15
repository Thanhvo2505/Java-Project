package vn.uth.k22.controller.Admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String getAllUser(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("users", users);
        
        return "/admin/user/show";
    }
}



