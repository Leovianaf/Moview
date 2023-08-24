package br.ufrpe.moview.gui;

import br.ufrpe.moview.beans.Filme;
import br.ufrpe.moview.beans.TipoDeConta;
import br.ufrpe.moview.exception.ObjetoInvalidoException;
import br.ufrpe.moview.negocio.ControladorFilme;
import br.ufrpe.moview.negocio.ControladorSessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class TelaPesquisaFilmeController implements Initializable {
    @FXML private Button btnVoltar;
    @FXML private Button btnFilmeInfo;
    @FXML private Button btnFiltro;
    @FXML private TextField txtfNome;

    @FXML private TableView<Filme> listaFilmesBuscados;
    @FXML private TableColumn<Filme, String> nomeFilme;
    @FXML private TableColumn<Filme, String> genero;
    @FXML private TableColumn<Filme, LocalDate> dataLancamento;
    @FXML private final ObservableList<Filme> items = FXCollections.observableArrayList();

    ControladorCenas controladorCenas = ControladorCenas.getInstance();
    ControladorSessao sessao = ControladorSessao.getInstancia();
    ControladorFilme controladorFilme = ControladorFilme.getInstancia();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List<Filme> resultadoBusca = controladorFilme.listarFilmes();
        items.addAll(resultadoBusca);

        nomeFilme.setCellValueFactory(new PropertyValueFactory<Filme, String>("nome"));
        genero.setCellValueFactory(new PropertyValueFactory<Filme, String>("genero"));
        dataLancamento.setCellValueFactory(new PropertyValueFactory<Filme, LocalDate>("dataDeLancamento"));

        listaFilmesBuscados.setItems(items);
    }

    public void FiltrarPesquisa() throws ObjetoInvalidoException {
        String nomeFilme = txtfNome.getText();

        // Limpa todos os itens da lista
        listaFilmesBuscados.getItems().clear();

        List<Filme> resultadoBusca = controladorFilme.buscarFilme(nomeFilme);
        items.addAll(resultadoBusca);
        listaFilmesBuscados.setItems(items);
    }

    // Pega o objeto selecionado no TableView e usa ele pra ir para suas informações
    public void VerInfoFilme(ActionEvent event) throws ObjetoInvalidoException, IOException {
        TableSelectionModel<Filme> selectionModel = listaFilmesBuscados.getSelectionModel();
        Filme filmeSelecionado = selectionModel.getSelectedItem(); // Obtém o filme selecionado

        if (filmeSelecionado != null) {
            sessao.setFilmeTemp(filmeSelecionado); // Define o filme selecionado como filme temporário
            controladorCenas.TrocarTelaFilme(event); // Navega para a TelaFilme
        }
    }

//    public void VerInfoFilme(ActionEvent event) throws ObjetoInvalidoException, IOException {
//        String nomeFilme = txtfNome.getText();
//
//        List<Filme> resultadoBusca = controladorFilme.buscarFilme(nomeFilme);
//
//        if (!resultadoBusca.isEmpty()) {
//            Filme filmeSelecionado = resultadoBusca.get(0); // Seleciona o primeiro filme da lista
//            sessao.setFilmeTemp(filmeSelecionado); // Define o filme selecionado como filme temporário
//            controladorCenas.TrocarTelaFilme(event); // Navega para a TelaFilme
//        }
//    }

    // Volta pra Tela Principal
    public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
        listaFilmesBuscados.setItems(null);
        String tipoUsuario = sessao.getUsuarioOnline().getTipo().toString();

        if(tipoUsuario == TipoDeConta.ADMIN.toString()) {
            controladorCenas.TrocarTelaPrincipalAdm(event);
        }
        else{
            controladorCenas.TrocarTelaPrincipal(event);
        }
    }
}