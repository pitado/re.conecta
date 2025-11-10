package com.reconecta.api.web.clientes;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin(origins = "*") // libera o acesso do HTML estático
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
    public ResponseEntity<?> criar(@Valid @RequestBody Cliente novo) {
        if (repo.existsByEmailIgnoreCase(novo.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("E-mail já cadastrado");
        }
        Cliente salvo = repo.save(novo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
