package br.ufrpe.moview.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TelaInicialController {
    // atributos elementos gráficos
    @FXML private Button btnLogin;
    @FXML private Button btnCadastro;
    @FXML private AnchorPane bgColorido;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();

    // Ir para Login
    public void TelaLogin(ActionEvent event) throws IOException {
        controladorCenas.TrocarTelaLogin(event);
    }

    // Ir para Cadastro
    public void TelaCadastro(ActionEvent event) throws IOException {
        controladorCenas.TrocarTelaCadastro(event);
    }
}
