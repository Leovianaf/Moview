package br.ufrpe.moview.gui;

import br.ufrpe.moview.beans.Filme;
import br.ufrpe.moview.beans.Genero;
import br.ufrpe.moview.exception.ObjetoInvalidoException;
import br.ufrpe.moview.exception.ObjetoJaExisteException;
import br.ufrpe.moview.negocio.ControladorFilme;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class TelaAdicionarFilmeController {
    // Atributos elementos gráficos
    @FXML private TextField txtNome;
    @FXML private TextField txtGenero;
    @FXML private TextField txtSinopse;
    @FXML private DatePicker dataSelect;
    @FXML private Button btnVoltar;
    @FXML private Button btnAdicionar;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();

    public void AdicionarNovoFilme(ActionEvent event) throws IOException, ObjetoJaExisteException, ObjetoInvalidoException {
        // Adicionar novo Filme
        ControladorFilme controladorFilme = ControladorFilme.getInstancia();
        String nome = txtNome.getText();
        String generoString = txtGenero.getText();
        Genero genero = Genero.valueOf(generoString);
        LocalDate data = dataSelect.getValue();
        String sinopse = txtSinopse.getText();

        Filme filme = new Filme(nome, genero, sinopse, data);
        controladorFilme.adicionarFilme(filme);

        // Zerar os TxtFields
        txtNome.setText(null);
        txtGenero.setText(null);
        txtSinopse.setText(null);
        dataSelect.setValue(null);
    }

    // Ir para Tela Principal do ADM
    public void TrocarTelaPrincipalAdm(ActionEvent event) throws IOException {
        controladorCenas.TrocarTelaPrincipalAdm(event);
    }
}
