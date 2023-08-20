package br.ufrpe.moview.beans;

public enum Genero {
    ACAO("Ação"),
    AVENTURA("Aventura"),
    COMEDIA("Comédia"),
    CRIME("Crime"),
    DRAMA("Drama"),
    FANTASIA("Fantasia"),
    TERROR("Terror"),
    FICCAO_CIENTIFICA("Ficção Científica"),
    ROMANCE("Romance"),
    SUSPENSE("Suspense"),
    ANIMACAO("Animação"),
    DOCUMENTARIO("Documentário");

    private final String nome;

    private Genero(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
