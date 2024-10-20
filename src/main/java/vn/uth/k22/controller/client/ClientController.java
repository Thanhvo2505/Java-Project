package vn.uth.k22.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vn.uth.k22.domain.Pod;
import vn.uth.k22.domain.dto.RegisterDTO;
import vn.uth.k22.service.PodService;


@Controller
public class ClientController {
    private final PodService podService;
  

    public ClientController(PodService podService) {
        this.podService = podService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<Pod> pods = this.podService.getAllPod();
        System.out.println(pods);
        model.addAttribute("pods", pods);
        return "/client/homepage/show";
      
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());

        return "client/auth/register";
    }

    @PostMapping("/register")
    public String postHandleRegister(@ModelAttribute("registerUser") RegisterDTO  registerUser) {
        if (registerUser != null) {
            // System.out.println("Received first name: " + registerUser.getFirstName());
        } else {
            // System.out.println("Register user is null");
        }
        return "client/auth/register";
    }
    

}
