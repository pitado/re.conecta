// src/main/java/com/reconecta/api/web/HomeController.java
package com.reconecta.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
  @GetMapping("/")
  public String home() {
    // redireciona para o Swagger UI
    return "redirect:/swagger-ui/index.html";
  }
}

// opcional: ping simples em JSON
@RestController
class HealthController {
  @GetMapping("/healthz")
  public String health() {
    return "{\"status\":\"ok\"}";
  }
}
