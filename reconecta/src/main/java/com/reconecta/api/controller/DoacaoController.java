package com.reconecta.api.controller;

import com.reconecta.api.model.Doacao;
import com.reconecta.api.service.DoacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doacoes")
public class DoacaoController {

    private final DoacaoService service;

    public DoacaoController(DoacaoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Doacao> criar(@Valid @RequestBody Doacao d){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(d));
    }

    @GetMapping
    public List<Doacao> listar(){ return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Doacao> buscar(@PathVariable Long id){
        return service.buscar(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doacao> atualizar(@PathVariable Long id, @Valid @RequestBody Doacao d){
        return service.atualizar(id, d).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
