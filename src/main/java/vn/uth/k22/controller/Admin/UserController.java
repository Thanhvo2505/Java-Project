package vn.uth.k22.controller.Admin;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.uth.k22.domain.Role;
import vn.uth.k22.domain.User;
import vn.uth.k22.service.RoleService;
import vn.uth.k22.service.UploadService;
import vn.uth.k22.service.UserService;


@Controller
public class UserController {
    private final UserService userService; 
    private final RoleService roleSerVice;
    private final UploadService uploadService;
    private BCryptPasswordEncoder passwordEncoder;

    public UserController(UserService userService, RoleService roleSerVice, UploadService uploadService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleSerVice = roleSerVice;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
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
    public String postCreatUser(@ModelAttribute("newUser") User user,
    @RequestParam("avatarFile") MultipartFile avatarFile) {
        if(user == null){
            System.out.println("Data User Null");
            return "error";
        }
        String avatar = this.uploadService.handleSaveUploadFile( avatarFile, "avatar");
        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        // set role
        Role role = this.roleSerVice.getRoleByName(user.getRole().getName());
        user.setRole(role);
        // set name avatar
        user.setAvatar(avatar);
        // set hash password
        user.setPassword(hashPassword);

        User newUser = this.userService.saveUser(user);
        return "redirect:/admin/user";
    }

    // get form update user
    @GetMapping("/admin/user/update/{id}")
    public String getFormUpdateUserPage(Model model, @PathVariable("id") long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/update";
    }

    // post update user
    @PostMapping("/admin/user/update")
    public String postMethodName(@ModelAttribute("user") User user,  
    @RequestParam("avatarFileUpdate") MultipartFile avatarFile) {
      
        String avatar = this.uploadService.handleSaveUploadFile(avatarFile, "avatar");
        User currentUser = this.userService.getUserById(user.getId());

        if(currentUser!= null){
            currentUser.setPhone(user.getPhone());
            currentUser.setName(user.getName());
            currentUser.setAddress(user.getAddress());
            currentUser.setIsActive(user.getIsActive());
            currentUser.setAvatar(avatar);      
            this.userService.saveUser(currentUser);
        } 
        return "redirect:/admin/user";
    }
    
    // get confirm delete-soft
    @GetMapping("/admin/user/delete/{id}")
    public String getConfirmDeleteSoftPage(Model model, @PathVariable("id") long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("user", currentUser);
        return "admin/user/delete";
    }

    // post delete
    @PostMapping("/admin/user/delete")
    public String postDeleteUser(@ModelAttribute("user") User user) {
       this.userService.deleteAUser(user.getId());
        return "redirect:/admin/user";
    }
}



