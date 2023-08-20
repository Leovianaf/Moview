package br.ufrpe.moview.negocio;

import br.ufrpe.moview.beans.Filme;
import br.ufrpe.moview.beans.Genero;
import br.ufrpe.moview.dados.IRepositorioGenerico;
import br.ufrpe.moview.dados.RepositorioGenerico;
import br.ufrpe.moview.exception.ObjetoInvalidoException;
import br.ufrpe.moview.exception.ObjetoJaExisteException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ControladorFilme {
    private final IRepositorioGenerico<Filme> repositorioFilmes;
    private static ControladorFilme instancia;

    // Controlador
    public ControladorFilme() {
        this.repositorioFilmes = new RepositorioGenerico<>();
    }

    // Pega a instância do controlador
    public static ControladorFilme getInstancia() {
        if (instancia == null) {
            instancia = new ControladorFilme();
        }
        return instancia;
    }

    // CRUD
    public void adicionarFilme(Filme filme) throws ObjetoInvalidoException, ObjetoJaExisteException {
        if (filme != null){
            if(!filme.getNome().isEmpty() && filme.getGenero() != null && !filme.getSinopse().isEmpty() && filme.getDataDeLancamento() != null){
                repositorioFilmes.adicionar(filme);
            }
        }
        else{
            throw new ObjetoInvalidoException();
        }
    }

    public List<Filme> listarFilmes() {
        return repositorioFilmes.listar();
    }

    public void removerFilme(Filme filme) throws ObjetoInvalidoException {
        if (filme != null){
            repositorioFilmes.remover(filme);
        }
        else{
            throw new ObjetoInvalidoException();
        }
    }

    public void editarFilme(Filme filme, Filme novo) throws ObjetoInvalidoException, ObjetoJaExisteException {
        if(!listarFilmes().contains(novo)){
            if (filme != null && novo != null){
                if(!novo.getNome().isEmpty() && novo.getGenero() != null && !novo.getSinopse().isEmpty() && novo.getDataDeLancamento() != null &&  novo.getNotaCriticos() != 0 && novo.getNotaPublico() != 0){
                    repositorioFilmes.editar(filme, novo);
                }
            }
            else {
                throw new ObjetoInvalidoException(filme);
            }
        }
        else{
            throw new ObjetoJaExisteException(novo);
        }
    }

    // Buscar um filme passando ele como parâmetro
    public List<Filme> buscarFilme(Object T) throws ObjetoInvalidoException {
        List<Filme> filmes = this.listarFilmes();
        if (T instanceof String palavra) {
            if (palavra.isBlank()) {
                return filmes;
            }
            else {
                List<Filme> resultados = new ArrayList<>();
                for (Filme filme : filmes) {
                    String[] palavras = filme.getNome().split("\\s+");
                    for (String p : palavras) {
                        if(p.equalsIgnoreCase(palavra)) {
                            resultados.add(filme);
                            break;
                        }
                    }
                }
                return resultados;
            }
        }
        else if (T instanceof Genero tipo) {
            List<Filme> resultados = new ArrayList<>();
            for (Filme filme : filmes) {
                if (filme.getGenero().equals(tipo)) {
                    resultados.add(filme);
                }
            }
            return resultados;
        }
        else {
            throw new ObjetoInvalidoException();
        }
    }

    // Busca os filmes com as melhores notas dos usuários Padrão
    public List<Filme> buscarMelhoresPublico() {
        List<Filme> filmes = ControladorFilme.getInstancia().listarFilmes();
        filmes.sort(new Comparator<Filme>() {
            @Override
            public int compare(Filme filme1, Filme filme2) {
                Double nota1 = filme1.getNotaPublico();
                Double nota2 = filme2.getNotaPublico();

                if (nota1 == null && nota2 == null) {
                    return 0;
                } else if (nota1 == null) {
                    return 1;
                } else if (nota2 == null) {
                    return -1;
                } else {
                    return Double.compare(nota2, nota1);
                }
            }
        });
        return filmes;
    }

    // Busca os filmes com as melhores notas dos usuários Críticos
    public List<Filme> buscarMelhoresCritico() {
        List<Filme> filmes = ControladorFilme.getInstancia().listarFilmes();
        filmes.sort(new Comparator<Filme>() {
            @Override
            public int compare(Filme filme1, Filme filme2) {
                Double nota1 = filme1.getNotaCriticos();
                Double nota2 = filme2.getNotaCriticos();

                if (nota1 == null && nota2 == null) {
                    return 0;
                } else if (nota1 == null) {
                    return 1;
                } else if (nota2 == null) {
                    return -1;
                } else {
                    return Double.compare(nota2, nota1);
                }
            }
        });
        return filmes;
    }
}
