package vn.uth.k22.controller.Admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        // return "hello";
    }

    // form create pods
    @GetMapping("/admin/pod/create")
    public String getFormCreatePod(Model model) {
        model.addAttribute("newPod", new Pod());
        return "admin/pod/create";
    }

    @PostMapping("/admin/pod/create")
    public String CreateAPod(@ModelAttribute("newPod") Pod pod) {
        System.out.println(pod);
        this.podService.handleSavPod(pod);
        return "redirect:/admin/pod" ;
    }
    
    // get detail pod
    @GetMapping("/admin/pod/{id}")
    public String getDetailPod(Model model,@PathVariable Long id) {
        Pod currentPod = this.podService.getPodById(id);
        model.addAttribute("pod", currentPod);
        System.out.println(currentPod);
        return "/admin/pod/detail";
    }
    
    
    
}

