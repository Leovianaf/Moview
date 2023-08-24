package br.ufrpe.moview.gui;

import br.ufrpe.moview.beans.Filme;
import br.ufrpe.moview.beans.Genero;
import br.ufrpe.moview.exception.CamposNaoPreenchidosException;
import br.ufrpe.moview.exception.ObjetoInvalidoException;
import br.ufrpe.moview.exception.ObjetoJaExisteException;
import br.ufrpe.moview.negocio.ControladorFilme;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TelaAdicionarFilmeController implements Initializable {
    // Atributos elementos gráficos
    @FXML private TextField txtNome;
    @FXML private ComboBox<Genero> cbGenero = new ComboBox<>();
    @FXML private TextArea txaSinopse;
    @FXML private DatePicker dataSelect;
    @FXML private Label lblErro;
    @FXML private Label lblSucess;
    @FXML private Button btnVoltar;
    @FXML private Button btnAdicionar;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();

    @FXML
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cbGenero.getItems().addAll(Arrays.asList(Genero.values()));
    }

    // Limpa o label de erro
    public void initialize() {
        // Configurar ouvintes de foco para cada campo
        txtNome.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Campo recebeu foco
                lblErro.setText(""); // Limpar a mensagem de erro
                lblSucess.setText(""); // Limpar a mensagem de sucesso
            }
        });

        cbGenero.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Campo recebeu foco
                lblErro.setText(""); // Limpar a mensagem de erro
                lblSucess.setText(""); // Limpar a mensagem de sucesso
            }
        });

        dataSelect.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Campo recebeu foco
                lblErro.setText(""); // Limpar a mensagem de erro
                lblSucess.setText(""); // Limpar a mensagem de sucesso
            }
        });

        txaSinopse.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Campo recebeu foco
                lblErro.setText(""); // Limpar a mensagem de erro
                lblSucess.setText(""); // Limpar a mensagem de sucesso
            }
        });
    }

    public void AdicionarNovoFilme(ActionEvent event) throws IOException, ObjetoJaExisteException, ObjetoInvalidoException {
        try {
            // Adicionar novo Filme
            ControladorFilme controladorFilme = ControladorFilme.getInstancia();
            String nome = txtNome.getText();
            Genero genero = cbGenero.getValue();
            LocalDate data = dataSelect.getValue();
            String sinopse = txaSinopse.getText();

            // Verifica se os Campos da Interface estão vazios
            if (nome.isEmpty() || genero == null || data == null || sinopse.isEmpty()) {
                throw new CamposNaoPreenchidosException("Por favor, preencha todos os campos.");
            }

            Filme filme = new Filme(nome, genero, sinopse, data);
            controladorFilme.adicionarFilme(filme);

            // Zerar os TxtFields
            txtNome.setText(null);
            txaSinopse.setText(null);
            dataSelect.setValue(null);
            cbGenero.setValue(null);

            this.lblSucess.setText("Filme adicionado ao sistema!");
        } catch (CamposNaoPreenchidosException e) {
            this.lblErro.setText("Erro: " + e.getMessage());
        } catch (ObjetoJaExisteException e) {
            this.lblErro.setText("Erro: Este filme já existe no sistema");
        } catch (ObjetoInvalidoException e) {
            this.lblErro.setText("Erro: Este filme é inválido");
        }




    }

//    public Genero obterGeneroPelaString(String generoString) {
//        for (Genero genero : Genero.values()) {
//            if (genero.getNome().equalsIgnoreCase(generoString)) {
//                return genero;
//            }
//        }
//        return null;  // Gênero não encontrado
//    }

    // Volta pra Tela de Pesquisa de Filmes
    public void TrocarTelaPesquisaFilme(ActionEvent event) throws IOException {
        controladorCenas.TrocarPesquisaFilme(event);
    }
}
