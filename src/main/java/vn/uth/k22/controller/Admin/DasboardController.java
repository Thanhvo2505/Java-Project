package vn.uth.k22.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class DasboardController {
    @GetMapping("/admin")
    public String getDashboard() {
        return "/admin/dashboard/show";
    }
    
}
