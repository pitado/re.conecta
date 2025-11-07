package com.reconecta.api.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
public class RootController {

  @GetMapping("/healthz")
  public Map<String, Object> health() {
    return Map.of(
        "status", "UP",
        "service", "re.conecta",
        "time", Instant.now().toString()
    );
  }
}
