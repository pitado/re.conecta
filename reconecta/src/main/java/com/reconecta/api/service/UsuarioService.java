package com.reconecta.api.service;

import com.reconecta.api.model.Usuario;
import com.reconecta.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) { this.repo = repo; }

    public Usuario salvar(Usuario u){ return repo.save(u); }
    public List<Usuario> listar(){ return repo.findAll(); }
    public Optional<Usuario> buscar(Long id){ return repo.findById(id); }
    public Optional<Usuario> atualizar(Long id, Usuario novo){
        return repo.findById(id).map(u -> {
            u.setNome(novo.getNome());
            u.setEmail(novo.getEmail());
            u.setTipo(novo.getTipo());
            return repo.save(u);
        });
    }
    public void deletar(Long id){ repo.deleteById(id); }
}
