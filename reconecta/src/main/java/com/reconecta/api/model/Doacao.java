package com.reconecta.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "doacoes")
public class Doacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Eletronico eletronico;

    @ManyToOne(optional = false)
    private Usuario estudante;

    @NotBlank
    private String status; // "SOLICITADA","EM_TRIAGEM","ENTREGUE"

    @NotNull
    private LocalDate data;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Eletronico getEletronico() { return eletronico; }
    public void setEletronico(Eletronico eletronico) { this.eletronico = eletronico; }
    public Usuario getEstudante() { return estudante; }
    public void setEstudante(Usuario estudante) { this.estudante = estudante; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
}
