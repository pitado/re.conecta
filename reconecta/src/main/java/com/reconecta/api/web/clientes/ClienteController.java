package com.reconecta.api.web.client es;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteRepository repo;

    public ClienteController(ClienteRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Cliente> listar() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente dto) {
        if (dto.getNome() == null || dto.getNome().isBlank()
                || dto.getEmail() == null || dto.getEmail().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        // evita duplicado por email
        repo.findByEmail(dto.getEmail()).ifPresent(c -> {
            throw new RuntimeException("Email já cadastrado");
        });

        Cliente salvo = repo.save(new Cliente(dto.getNome(), dto.getEmail()));
        return ResponseEntity.created(URI.create("/api/v1/clientes/" + salvo.getId()))
                .body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
