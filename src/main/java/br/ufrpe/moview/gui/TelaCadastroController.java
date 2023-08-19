package br.ufrpe.moview.gui;

import br.ufrpe.moview.beans.Usuario;
import br.ufrpe.moview.exception.CamposNaoPreenchidosException;
import br.ufrpe.moview.exception.ObjetoInvalidoException;
import br.ufrpe.moview.exception.ObjetoJaExisteException;
import br.ufrpe.moview.negocio.ControladorUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML private Label lblErro;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();

    public void initialize() {
        // Configurar ouvintes de foco para cada campo
        txtNome.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Campo recebeu foco
                lblErro.setText(""); // Limpar a mensagem de erro
            }
        });

        txtLogin.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Campo recebeu foco
                lblErro.setText(""); // Limpar a mensagem de erro
            }
        });

        txtSenha.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Campo recebeu foco
                lblErro.setText(""); // Limpar a mensagem de erro
            }
        });
    }

    public void CadastrarNovoUsuario(ActionEvent event) throws IOException, ObjetoJaExisteException, ObjetoInvalidoException, CamposNaoPreenchidosException {

        try {
            // Cadastrar novo usuario
            ControladorUsuario controladorUsuario = ControladorUsuario.getInstancia();
            String nome = txtNome.getText();
            String login = txtLogin.getText();
            String senha = txtSenha.getText();

            if (nome.isEmpty() || login.isEmpty() || senha.isEmpty()) {
                throw new CamposNaoPreenchidosException("Por favor, preencha todos os campos.");
            }

            Usuario usuario = new Usuario(nome, login, senha);
            controladorUsuario.adicionarUsuario(usuario);

            // Confirmar Cadastro
            controladorCenas.TrocarTelaCadastroRealizado(event);
        } catch (CamposNaoPreenchidosException e) {
            this.lblErro.setText("Erro: " + e.getMessage());
        } catch (IOException | ObjetoJaExisteException | ObjetoInvalidoException e) {
            // Tratar outras exceções aqui, se necessário
        }
    }
}
