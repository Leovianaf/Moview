package br.ufrpe.moview.gui;

import br.ufrpe.moview.exception.ObjetoInvalidoException;
import br.ufrpe.moview.negocio.ControladorSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class TelaPrincipalAdmController {
    @FXML private Button btnAdicionarFilme;
    @FXML private Button btnCadastrarUsuario;
    @FXML private Button btnPerfil;
    @FXML private Button btnPesquisaFilme;
    @FXML private Button btnPesquisaUsuario;
    @FXML private Button btnPesuisaAvaliacoes;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();
    ControladorSessao sessao = ControladorSessao.getInstancia();

    @FXML
    private void initialize() {
    }

    // Volta pra Tela de Login, Deslogando da sessão
    public void Logoff(ActionEvent event) throws IOException {
        sessao.encerrarSessao();
        controladorCenas.TrocarTelaLogin(event);
    }

    // Ir para Tela de Adcionar um Filme
    public void TrocarTelaAdcionarFilme(ActionEvent event) throws IOException {
        controladorCenas.TrocarTelaAdicionarFilme(event);
    }

    // Ir para Tela de Cadastrar um Usuário
    public void TrocarTelaCadastroADM(ActionEvent event) throws IOException {
        // Fazer essa tela
    }

    // Ir para a tela de Meu Perfil
    public void TrocarTelaPerfil(ActionEvent event) throws IOException {
        controladorCenas.TrocarTelaPerfil(event);
    }

    // Ir para Tela de Pesquisar Filmes
    public void PesquisaFilme(ActionEvent event)throws IOException, ObjetoInvalidoException {
        controladorCenas.TrocarPesquisaFilme(event);
    }

    // Ir para Tela de Pesquisar Usuários
    public void PesquisaUsuario(ActionEvent event)throws IOException, ObjetoInvalidoException {
        controladorCenas.TrocarPesquisaUsuario(event);
    }

    // Ir para Tela de Pesquisar Avaliações
    public void PesquisaAvaliacao(ActionEvent event)throws IOException, ObjetoInvalidoException {
        controladorCenas.TrocarPesquisaAvaliacao(event);
    }
}
