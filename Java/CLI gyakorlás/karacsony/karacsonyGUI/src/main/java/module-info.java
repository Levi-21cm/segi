module hu.katolikuskeri.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires karacsonyCLI;

    opens hu.katolikuskeri.gui to javafx.fxml;
    exports hu.katolikuskeri.gui;
}
