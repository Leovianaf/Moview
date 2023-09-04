package br.ufrpe.moview.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Filme {
    // Atributos
    private String nome;
    private Genero genero;
    private String sinopse;
    private LocalDate dataDeLancamento;
    private double notaPublico;
    private double notaCriticos;

    // Lista de avaliações do público
    private List<Avaliacao> avaliacoesPublico = new ArrayList<>();

    // Lista de avaliações dos críticos
    private List<Avaliacao> avaliacoesCriticos = new ArrayList<>();

    // Construtor
    public Filme(String nome, Genero genero, String sinopse, LocalDate dataDeLancamento) {
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
        this.dataDeLancamento = dataDeLancamento;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public double getNotaCriticos() {
        return notaCriticos;
    }

    public void setNotaCriticos(double notaCriticos) {
        this.notaCriticos = notaCriticos;
    }

    public double getNotaPublico() {
        return notaPublico;
    }

    public void setNotaPublico(double notaPublico) {
        this.notaPublico = notaPublico;
    }

    public List<Avaliacao> getAvaliacoesPublico() {
        return avaliacoesPublico;
    }

    public void setAvaliacoesPublico(List<Avaliacao> avaliacoesPublico) {
        this.avaliacoesPublico = avaliacoesPublico;
    }

    public List<Avaliacao> getAvaliacoesCriticos() {
        return avaliacoesCriticos;
    }

    public void setAvaliacoesCriticos(List<Avaliacao> avaliacoesCriticos) {
        this.avaliacoesCriticos = avaliacoesCriticos;
    }
}
