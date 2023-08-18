package br.ufrpe.moview.negocio;

import br.ufrpe.moview.beans.Avaliacao;
import br.ufrpe.moview.beans.Filme;
import br.ufrpe.moview.beans.Usuario;
import br.ufrpe.moview.dados.IRepositorioGenerico;
import br.ufrpe.moview.dados.RepositorioGenerico;
import br.ufrpe.moview.exception.ObjetoInvalidoException;
import br.ufrpe.moview.exception.ObjetoJaExisteException;

import java.util.ArrayList;
import java.util.List;

public class ControladorAvaliacao {
    private final IRepositorioGenerico<Avaliacao> repositorioAvaliacoes;
    private static ControladorAvaliacao instancia;

    // Controlador
    public ControladorAvaliacao() {
        this.repositorioAvaliacoes = new RepositorioGenerico<>();
    }

    // Pega a instância do controlador
    public static ControladorAvaliacao getInstancia() {
        if (instancia == null) {
            instancia = new ControladorAvaliacao();
        }
        return instancia;
    }

    // CRUD
    public void adicionarAvaliacao(Avaliacao avaliacao) throws ObjetoJaExisteException, ObjetoInvalidoException {
        if (avaliacao != null){
            if(avaliacao.getUsuario() != null && avaliacao.getFilme() != null && avaliacao.getComentario() != null && avaliacao.getNota() != 0 && avaliacao.getDataAvaliacao() != null){
                repositorioAvaliacoes.adicionar(avaliacao);
            }
        }
        else{
            throw new ObjetoInvalidoException();
        }
    }

    public List<Avaliacao> listarAvaliacoes() {
        return repositorioAvaliacoes.listar();
    }

    public void removerAvaliacao(Avaliacao avaliacao) throws ObjetoInvalidoException {
        if (avaliacao != null){
            repositorioAvaliacoes.remover(avaliacao);
        }
        else{
            throw new ObjetoInvalidoException();
        }
    }

    public void editarAvaliacao(Avaliacao avaliacao, Avaliacao nova) throws ObjetoInvalidoException, ObjetoJaExisteException {
        if(!listarAvaliacoes().contains(nova)){
            if (avaliacao != null && nova != null){
                if(nova.getUsuario() != null && nova.getFilme() != null && nova.getComentario() != null && nova.getNota() != 0 && nova.getDataAvaliacao() != null){
                    repositorioAvaliacoes.editar(avaliacao, nova);
                }
            }
            else {
                throw new ObjetoInvalidoException(avaliacao);
            }
        }
        else{
            throw new ObjetoJaExisteException(nova);
        }
    }

    // Buscar uma avaliação passando ela como parâmetro
    public List<Avaliacao> buscarAvaliacoes(Object T) throws ObjetoInvalidoException{
        List<Avaliacao> avaliacoes = this.listarAvaliacoes();
        if (T instanceof Usuario usuario) {
            List<Avaliacao> resultados = new ArrayList<>();
            for (Avaliacao avaliacao : avaliacoes) {
                if (avaliacao.getUsuario().equals(usuario)) {
                    resultados.add(avaliacao);
                }
            }
            return resultados;
        }
        else if (T instanceof Filme filme) {
            List<Avaliacao> resultados = new ArrayList<>();
            for (Avaliacao avaliacao : avaliacoes) {
                if (avaliacao.getFilme().equals(filme)) {
                    resultados.add(avaliacao);
                }
            }
            return resultados;
        }
        else {
            throw new ObjetoInvalidoException();
        }
    }
}
