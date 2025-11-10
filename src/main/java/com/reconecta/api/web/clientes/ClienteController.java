package com.reconecta.api.web.clientes;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
  private final ClienteRepository repo;

  public ClienteController(ClienteRepository repo) { this.repo = repo; }

  @GetMapping
  public List<Cliente> listar() { return repo.findAll(); }

  @PostMapping
  public Cliente criar(@RequestBody Cliente c) { return repo.save(c); }
}
