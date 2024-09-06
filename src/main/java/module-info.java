module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires junit;
    requires jdk.xml.dom;
    requires java.desktop;

    opens com.calculator.main to javafx.fxml;
    exports com.calculator.main;
    exports com.calculator.controller;
    opens com.calculator.controller to javafx.fxml;
}