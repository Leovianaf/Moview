module br.ufrpe.moview {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens br.ufrpe.moview to javafx.fxml;
    opens br.ufrpe.moview.gui to javafx.fxml;
    exports br.ufrpe.moview;
    exports br.ufrpe.moview.gui;
}