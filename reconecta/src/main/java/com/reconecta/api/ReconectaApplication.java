package com.reconecta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.reconecta")
public class ReconectaApplication {
  public static void main(String[] args) {
    SpringApplication.run(ReconectaApplication.class, args);
  }
}
