module com.example.autocamper_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.autocamper_project to javafx.fxml;
    exports com.example.autocamper_project;
}