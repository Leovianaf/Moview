package br.ufrpe.moview.gui;

import br.ufrpe.moview.beans.Filme;
import br.ufrpe.moview.negocio.ControladorSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class TelaFilmeController {
    // Atributos elementos gráficos
    @FXML private Label lblData;
    @FXML private Label lblNome;
    @FXML private Label lblGenero;
    @FXML private Label lblNotaP;
    @FXML private Label lblNotaC;
    @FXML private TextArea txaSinopse;
    @FXML private Button btnEscreverAvaliacao;
    @FXML private Button btnVoltar;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();
    ControladorSessao sessao = ControladorSessao.getInstancia();

    @FXML
    private void initialize() throws IOException {
        ExibirFilme();
    }

    public void ExibirFilme()throws IOException {
        // Exibe as informações do Filme Escolhido
        Filme filmeEscolhido = sessao.getFilmeTemp();

        String nome = filmeEscolhido.getNome();
        String genero = filmeEscolhido.getGenero().toString();
        String sinopse = filmeEscolhido.getSinopse();
        String notaP = Double.toString(filmeEscolhido.getNotaPublico());
        String notaC = Double.toString(filmeEscolhido.getNotaCriticos());
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String dataFormatada = formato.format(filmeEscolhido.getDataDeLancamento());

        lblNome.setText(nome);
        lblGenero.setText(genero);
        txaSinopse.setText(sinopse);
        lblNotaP.setText(notaP);
        lblNotaC.setText(notaC);
        lblData.setText(dataFormatada);
    }

    // Volta pra Tela de Pesquisa de Filmes
    public void TrocarTelaPesquisaFilme(ActionEvent event) throws IOException {
        controladorCenas.TrocarPesquisaFilme(event);
    }

    // Vai pra tela de Submeter Avaliação
    public void TrocarEscreverAvaliacao(ActionEvent event) throws IOException {
        controladorCenas.TrocarEscreverAvaliacao(event);
    }

}
