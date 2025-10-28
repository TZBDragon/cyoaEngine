module com.example.cyoaengine {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires json.simple;
    requires com.google.gson;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;


    opens com.example.cyoaengine to javafx.fxml, com.google.gson;
    exports com.example.cyoaengine;
}