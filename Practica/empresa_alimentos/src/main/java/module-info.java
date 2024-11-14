module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.model to javafx.fxml;
    opens co.edu.uniquindio.poo.app to javafx.fxml;

    exports co.edu.uniquindio.poo.model;
    exports co.edu.uniquindio.poo.app;
}
