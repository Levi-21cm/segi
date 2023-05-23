module hu.katolikuskeri.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires Kosar2004CLI;

    opens hu.katolikuskeri.gui to javafx.fxml;
    exports hu.katolikuskeri.gui;
}
