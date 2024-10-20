package vn.uth.k22.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.uth.k22.domain.Pod;
import vn.uth.k22.service.PodService;


@Controller
public class ItemController {
    private final PodService podService;

    public ItemController(PodService podService){
        this.podService = podService;
    }
    
    @GetMapping("/pod/{id}")
    public String getDetailPodPage(Model model, @PathVariable("id") long id) {
        Pod currentPod = this.podService.getPodById(id);
        if(currentPod != null){
            model.addAttribute("pod", currentPod);
            return "client/pod/detail";
        }
        return "hello";
       
    }
}
