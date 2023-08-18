package br.ufrpe.moview.beans;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    // Atributos
    private String nome;
    private List<Filme> filmes = new ArrayList<>();

    // Construtor
    public Lista(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
}
