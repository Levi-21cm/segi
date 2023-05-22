module hu.katolikuskeri.ultrabalaton.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires UltrabalatonCLI;

    opens hu.katolikuskeri.ultrabalaton.gui to javafx.fxml;
    exports hu.katolikuskeri.ultrabalaton.gui;
}
