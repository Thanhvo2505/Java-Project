package vn.uth.k22.controller.client;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vn.uth.k22.domain.Pod;
import vn.uth.k22.domain.User;
import vn.uth.k22.domain.dto.RegisterDTO;
import vn.uth.k22.service.PodService;
import vn.uth.k22.service.UserService;


@Controller
public class ClientController {
    private final PodService podService;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
  

    public ClientController(PodService podService, BCryptPasswordEncoder passwordEncoder,  UserService userService) {
        this.podService = podService;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<Pod> pods = this.podService.getAllPod();
        System.out.println(pods);
        model.addAttribute("pods", pods);
        return "/client/homepage/show";
      
    }


    // form đăng kí
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/register";
    }
    // gửi form đăng kí
    @PostMapping("/register")
    public String postHandleRegister(@ModelAttribute("registerUser") RegisterDTO  registerUser) {
        if (registerUser != null) {
            // System.out.println("Received first name: " + registerUser.getFirstName());
        } else {
            // System.out.println("Register user is null");
        }
        User user = this.userService.registerDTOtoUser(registerUser);
        this.userService.saveUser(user);
        return "client/auth/login";
    }

    @GetMapping("/login")
    public String getFomrLoginPage() {
       
        return "client/auth/login";
    }
}
