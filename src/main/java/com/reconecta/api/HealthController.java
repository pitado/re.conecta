package com.reconecta.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class HealthController {

    private final DataSource dataSource;

    public HealthController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/healthz")
    public HealthResponse healthz() {
      try (Connection ignored = dataSource.getConnection()) {
        return new HealthResponse("UP");
      } catch (Exception e) {
        return new HealthResponse("DOWN");
      }
    }

    static record HealthResponse(String status) {}
}
