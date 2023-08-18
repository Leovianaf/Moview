package br.ufrpe.moview.gui;

import br.ufrpe.moview.beans.Usuario;
import br.ufrpe.moview.exception.ObjetoInvalidoException;
import br.ufrpe.moview.exception.ObjetoJaExisteException;
import br.ufrpe.moview.negocio.ControladorUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TelaCadastroController {
    // Atributos elementos gráficos
    @FXML private TextField txtNome;
    @FXML private TextField txtLogin;
    @FXML private PasswordField txtSenha;
    @FXML private Button btnCadastro;
    @FXML private ImageView imagemFilme;
    @FXML private ImageView imagemEstrelas;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();

    public void CadastrarNovoUsuario(ActionEvent event) throws IOException, ObjetoJaExisteException, ObjetoInvalidoException {
        // Cadastrar novo usuario
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstancia();
        String nome = txtNome.getText();
        String senha = txtSenha.getText();
        String login = txtLogin.getText();

        Usuario usuario = new Usuario(nome, login, senha);
        controladorUsuario.adicionarUsuario(usuario);

        // Confirmar Cadastro
        controladorCenas.TrocarTelaCadastroRealizado(event);
    }
}
