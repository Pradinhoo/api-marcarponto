package com.pradocode.pontos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Funcao funcao;
    private Boolean emAtividade;

    public Usuario() {}

    public Usuario(String nome, String cpf, Funcao funcao) {
        this.nome = nome;
        this.cpf = cpf;
        this.funcao = funcao;
        this.emAtividade = true;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public Boolean getEmAtividade() {
        return emAtividade;
    }

    public void desativarUsuario() {
        this.emAtividade = false;
    }

    public void ativarUsuario() {
        this.emAtividade = true;
    }
}
