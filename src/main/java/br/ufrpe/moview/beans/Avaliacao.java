package br.ufrpe.moview.beans;

import java.time.LocalDateTime;

public class Avaliacao {
    // Atributos
    private Usuario usuario;
    private Filme filme;
    private String comentario;
    private double nota;
    private LocalDateTime dataAvaliacao;

    // Construtor
    public Avaliacao(Usuario usuario, Filme filme, String comentario, double nota) {
        this.usuario = usuario;
        this.filme = filme;
        this.comentario = comentario;
        this.nota = nota;
        this.dataAvaliacao = LocalDateTime.now();
    }

    // Getters e Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
}
