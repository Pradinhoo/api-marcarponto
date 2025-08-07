package com.pradocode.pontos.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pontos")
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    public Ponto() {}

    public Ponto(LocalDateTime dataHora, Usuario usuario) {
        this.dataHora = dataHora;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
