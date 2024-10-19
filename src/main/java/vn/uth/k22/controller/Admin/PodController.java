package vn.uth.k22.controller.Admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.uth.k22.domain.Pod;
import vn.uth.k22.service.PodService;
import vn.uth.k22.service.UploadService;




@Controller
public class PodController {
    private final PodService podService;
    private final UploadService uploadService;

    public PodController(PodService podService, UploadService uploadService) {
        this.podService = podService;
        this.uploadService = uploadService;
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
    public String CreateAPodPage(@ModelAttribute("newPod") Pod pod, @RequestParam("podImg") MultipartFile file) {
        String nameImg = this.uploadService.handleSaveUploadFile(file, "pod");
        pod.setImg(nameImg);
        this.podService.handleSavPod(pod);
        return "redirect:/admin/pod" ;
    }

    // get detail pod
    @GetMapping("/admin/pod/{id}")
    public String getDetailPodPage(Model model,@PathVariable Long id) {
        Pod currentPod = this.podService.getPodById(id);
        model.addAttribute("pod", currentPod);
        System.out.println(currentPod);
        return "/admin/pod/detail";
    }

    // get update form
    @GetMapping("/admin/pod/update/{id}")
    public String getUpdatePodFormPage(@PathVariable("id") long id, Model model) {
        Pod pod = this.podService.getPodById(id);
        model.addAttribute("pod", pod);
        return "/admin/pod/update";
    }

    // post handle update pod
    @PostMapping("/admin/pod/update")
    public String postUpdatePod(@ModelAttribute("pod") Pod pod, @RequestParam("imgFileUpdate") MultipartFile ImgFile) {
        Pod currPod = this.podService.getPodById(pod.getId());
        // xử lí
        String nameImgFile = this.uploadService.handleSaveUploadFile(ImgFile, "pod");
        currPod.setName(pod.getName());
        currPod.setLocation(pod.getLocation());
        currPod.setPricePerHour(pod.getPricePerHour());
        currPod.setCapacity(pod.getCapacity());
        currPod.setIsAvailable(pod.getIsAvailable());
        currPod.setDescription(pod.getDescription());
        if(!ImgFile.isEmpty()){
            currPod.setImg(nameImgFile);
        }
        this.podService.handleSavPod(currPod);
        return "redirect:/admin/pod" ;
    }

    // get confirm delete
    @GetMapping("/admin/pod/delete/{id}")
    public String getConfirmDeletePodPag(@PathVariable(value = "id") long id, Model model) {
        Pod currentPod = this.podService.getPodById(id);
        model.addAttribute("pod",currentPod);
        return  "admin/pod/delete";
    }

    @PostMapping("/admin/pod/delete")
    public String postHandleDeletePod(@ModelAttribute("pod") Pod pod) {
        long podId = pod.getId();
        System.out.println("Deleting pod with ID: " + podId); // Kiểm tra ID trước khi xóa
        this.podService.handleDeletePodById(podId);
        return "redirect:/admin/pod";
    }
    
}

