package com.reconecta.api.service;

import com.reconecta.api.model.Doacao;
import com.reconecta.api.repository.DoacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoacaoService {
    private final DoacaoRepository repo;

    public DoacaoService(DoacaoRepository repo) { this.repo = repo; }

    public Doacao salvar(Doacao d){ return repo.save(d); }
    public List<Doacao> listar(){ return repo.findAll(); }
    public Optional<Doacao> buscar(Long id){ return repo.findById(id); }
    public Optional<Doacao> atualizar(Long id, Doacao novo){
        return repo.findById(id).map(d -> {
            d.setEletronico(novo.getEletronico());
            d.setEstudante(novo.getEstudante());
            d.setStatus(novo.getStatus());
            d.setData(novo.getData());
            return repo.save(d);
        });
    }
    public void deletar(Long id){ repo.deleteById(id); }
}
