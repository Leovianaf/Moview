module br.ufrpe.moview {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens br.ufrpe.moview.gui to javafx.fxml;
    opens br.ufrpe.moview.beans to javafx.base;
    exports br.ufrpe.moview.gui;
}