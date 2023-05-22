module hu.katolikuskeri.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires TotoCLI;

    opens hu.katolikuskeri.gui to javafx.fxml;
    exports hu.katolikuskeri.gui;
}
