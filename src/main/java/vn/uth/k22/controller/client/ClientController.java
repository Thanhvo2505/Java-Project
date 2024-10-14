package vn.uth.k22.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {
    @GetMapping("/")
    public String getHomePage() {
        return "/client/homepage/show";
    }
}
