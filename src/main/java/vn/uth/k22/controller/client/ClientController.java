package vn.uth.k22.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.uth.k22.domain.Pod;
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
        model.addAttribute("pods", pods);
        
        return "/client/homepage/show";
    }
}
