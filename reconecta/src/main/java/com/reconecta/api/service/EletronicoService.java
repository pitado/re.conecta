package com.reconecta.api.service;

import com.reconecta.api.model.Eletronico;
import com.reconecta.api.repository.EletronicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EletronicoService {
    private final EletronicoRepository repo;

    public EletronicoService(EletronicoRepository repo) { this.repo = repo; }

    public Eletronico salvar(Eletronico e){ return repo.save(e); }
    public List<Eletronico> listar(){ return repo.findAll(); }
    public List<Eletronico> listarDisponiveis(){ return repo.findByDisponivelTrue(); }
    public Optional<Eletronico> buscar(Long id){ return repo.findById(id); }
    public Optional<Eletronico> atualizar(Long id, Eletronico novo){
        return repo.findById(id).map(e -> {
            e.setNome(novo.getNome());
            e.setDescricao(novo.getDescricao());
            e.setEstado(novo.getEstado());
            e.setDisponivel(novo.getDisponivel());
            e.setDoador(novo.getDoador());
            return repo.save(e);
        });
    }
    public void deletar(Long id){ repo.deleteById(id); }
}
