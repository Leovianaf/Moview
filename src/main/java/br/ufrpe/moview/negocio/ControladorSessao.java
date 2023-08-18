package br.ufrpe.moview.negocio;

import br.ufrpe.moview.beans.Filme;
import br.ufrpe.moview.beans.Usuario;

public class ControladorSessao {
    private static final ControladorSessao instancia = new ControladorSessao();
    private Usuario usuario;
    private Filme filmeTemp;
    private Usuario usuarioTemp;

    // Pega a instância da sessão
    public static ControladorSessao getInstancia() {
        return instancia;
    }

    // Abre a sessão com o usuário informado
    public void abrirSessao(Usuario usuario) {
        this.usuario = usuario;
    }

    // Retorna o usuário que está logado no sistema
    public Usuario getUsuarioOnline() {
        return usuario;
    }

    // Desloga o usuário do sistema
    public void encerrarSessao() {
        this.usuario = null;
    }

    public Filme getFilmeTemp() {
        return filmeTemp;
    }

    public void setFilmeTemp(Filme filme) {
        this.filmeTemp = filme;
    }

    public Usuario getUsuarioTemp() {
        return usuarioTemp;
    }

    public void setUsuarioTemp(Usuario usuario) {
        this.usuarioTemp = usuario;
    }
}