package com.reconecta.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    // Abre a documentação assim que acessa a raiz "/"
    @GetMapping("/")
    public String home() {
        return "redirect:/swagger-ui/index.html";
    }
}

// endpoint simples para checagem de saúde
@RestController
class HealthController {

    @GetMapping("/healthz")
    public String health() {
        return "{\"status\":\"ok\"}";
    }
}
