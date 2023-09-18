package br.ufrpe.moview.gui;

import br.ufrpe.moview.beans.*;
import br.ufrpe.moview.exception.ObjetoInvalidoException;
import br.ufrpe.moview.exception.ObjetoJaExisteException;
import br.ufrpe.moview.negocio.ControladorAvaliacao;
import br.ufrpe.moview.negocio.ControladorFilme;
import br.ufrpe.moview.negocio.ControladorUsuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaCadastro.fxml")));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ObjetoJaExisteException, ObjetoInvalidoException {

        ControladorUsuario controladorUsuario = ControladorUsuario.getInstancia();
        ControladorFilme controladorFilme = ControladorFilme.getInstancia();
        ControladorAvaliacao controladorAvaliacao = ControladorAvaliacao.getInstancia();

        Usuario admin = new Usuario("Administrador", "admin", "admin");
        admin.setTipo(TipoDeConta.ADMIN);
        controladorUsuario.adicionarUsuario(admin);

        Usuario padrao = new Usuario("Padrão", "p", "p");
        padrao.setTipo(TipoDeConta.PADRAO);
        controladorUsuario.adicionarUsuario(padrao);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/yyyy");
        Filme harrypotter = new Filme("Harry Potter", Genero.FANTASIA, "Menino bruxo brabo", LocalDate.parse("23/11/2001",formato));
        Filme interstellar = new Filme("Interstellar", Genero.FICCAO_CIENTIFICA, "Filme ruim no espaço", LocalDate.parse("6/11/2014",formato));
        Filme internet = new Filme("Internet: O Filme", Genero.COMEDIA, "Filme com vários youtubers aprontando", LocalDate.parse("23/02/2017",formato));
        controladorFilme.adicionarFilme(harrypotter);
        controladorFilme.adicionarFilme(interstellar);
        controladorFilme.adicionarFilme(internet);

        Avaliacao avaliacao1 = new Avaliacao(admin, harrypotter, "Brabo", 4);
        Avaliacao avaliacao2 = new Avaliacao(admin, interstellar, "Superestimado", 3);
        Avaliacao avaliacao3 = new Avaliacao(admin, internet, "Horrível!", 1);
        controladorAvaliacao.adicionarAvaliacao(avaliacao1);
        controladorAvaliacao.adicionarAvaliacao(avaliacao2);
        controladorAvaliacao.adicionarAvaliacao(avaliacao3);

        Application.launch(args);//<---------------------
    }
}
