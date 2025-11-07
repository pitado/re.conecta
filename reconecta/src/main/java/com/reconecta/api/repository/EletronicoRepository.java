package com.reconecta.api.repository;

import com.reconecta.api.model.Eletronico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EletronicoRepository extends JpaRepository<Eletronico, Long> {
    List<Eletronico> findByDisponivelTrue();
}
