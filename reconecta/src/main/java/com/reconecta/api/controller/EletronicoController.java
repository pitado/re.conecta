package com.reconecta.api.controller;

import com.reconecta.api.model.Eletronico;
import com.reconecta.api.service.EletronicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eletronicos")
public class EletronicoController {

    private final EletronicoService service;

    public EletronicoController(EletronicoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Eletronico> criar(@Valid @RequestBody Eletronico e){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(e));
    }

    @GetMapping
    public List<Eletronico> listar(){ return service.listar(); }

    @GetMapping("/disponiveis")
    public List<Eletronico> listarDisponiveis(){ return service.listarDisponiveis(); }

    @GetMapping("/{id}")
    public ResponseEntity<Eletronico> buscar(@PathVariable Long id){
        return service.buscar(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eletronico> atualizar(@PathVariable Long id, @Valid @RequestBody Eletronico e){
        return service.atualizar(id, e).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
