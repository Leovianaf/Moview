package br.ufrpe.moview.dados;

import br.ufrpe.moview.exception.ObjetoInvalidoException;
import br.ufrpe.moview.exception.ObjetoJaExisteException;

import java.util.List;

public interface IRepositorioGenerico<T> {
    void adicionar(T objeto) throws ObjetoJaExisteException;

    List<T> listar();
    void remover(T objeto) throws ObjetoInvalidoException;
    void editar(T objeto, T novo) throws ObjetoInvalidoException;
}
