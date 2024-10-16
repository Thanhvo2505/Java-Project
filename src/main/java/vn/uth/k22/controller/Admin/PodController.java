package vn.uth.k22.controller.Admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.uth.k22.domain.Pod;
import vn.uth.k22.service.PodService;



@Controller
public class PodController {
    private final PodService podService;

    public PodController(PodService podService) {
        this.podService = podService;
    }

    // admin view all pod
    @GetMapping("/admin/pod")
    public String getAllPodPage(Model model) {
        List<Pod> pods = this.podService.getAllPod();
        model.addAttribute("pods", pods);

        return "admin/pod/show";
    }


    // form create pods
    @GetMapping("/admin/pod/create")
    public String getFormCreatePod() {
        return "admin/pod/create";
    }
    
    
}

