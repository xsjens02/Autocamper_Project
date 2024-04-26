module com.example.autocamper_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.autocamper_project to javafx.fxml;
    exports com.example.autocamper_project;
    exports com.example.autocamper_project.Model;
    opens com.example.autocamper_project.Model to javafx.fxml;
    exports com.example.autocamper_project.Persistence;
    opens com.example.autocamper_project.Persistence to javafx.fxml;
    exports com.example.autocamper_project.Controller;
    opens com.example.autocamper_project.Controller to javafx.fxml;
}