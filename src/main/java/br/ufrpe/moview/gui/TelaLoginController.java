package br.ufrpe.moview.gui;

import br.ufrpe.moview.exception.ObjetoInvalidoException;
import br.ufrpe.moview.exception.SenhaIncorretaException;
import br.ufrpe.moview.negocio.ControladorSessao;
import br.ufrpe.moview.negocio.ControladorUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class TelaLoginController {
    // Atributos elementos gráficos
    @FXML private TextField txtSenha;
    @FXML private TextField txtLogin;
    @FXML private Button btnVoltar;
    @FXML private Button btnLogin;
    @FXML private Label lblErro;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();
    ControladorSessao sessao = ControladorSessao.getInstancia();

    // Ir para Tela Inicial
    public void TelaInicial(ActionEvent event) throws IOException, IOException {
        controladorCenas.TrocarTelaInicial(event);
    }

    // Pega os dados informados nas Boxes, chama a função de login, se verdadeira, Passa pra tela Principal
    public void FazerLogin(ActionEvent event) throws IOException, SenhaIncorretaException, ObjetoInvalidoException {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstancia();

        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        if (controladorUsuario.login(login, senha)) {
            String tipoUsuario = sessao.getUsuarioOnline().getTipo().toString();

            if(Objects.equals(tipoUsuario, "ADMIN")) {
                controladorCenas.TrocarTelaPrincipalAdm(event);
            }
            else{
                controladorCenas.TrocarTelaPrincipal(event);
            }
        }
        else {
            lblErro.setText("Usuário não existe ou não encontrado");
        }
    }
}
