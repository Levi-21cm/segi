module hu.katolikuskeri.taxifuvarok.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires taxiFuvarokCLI;

    opens hu.katolikuskeri.taxifuvarok.gui to javafx.fxml;
    exports hu.katolikuskeri.taxifuvarok.gui;
}
