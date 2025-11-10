package com.reconecta.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    // Redireciona a raiz "/" para a documentação Swagger
    @GetMapping("/")
    public String home() {
        return "redirect:/swagger-ui/index.html";
    }
}

// Endpoint simples de health (pode remover se já tiver o HealthController)
@RestController
class HealthController {

    @GetMapping("/healthz")
    public String health() {
        return "{\"status\":\"ok\"}";
    }
}
