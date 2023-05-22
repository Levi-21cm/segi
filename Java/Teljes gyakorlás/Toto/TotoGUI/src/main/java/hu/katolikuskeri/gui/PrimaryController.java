package hu.katolikuskeri.gui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PrimaryController {

    @FXML
    private TextField beker_TF;

    @FXML
    private CheckBox helytelenKarakter_CHECKBOX;

    @FXML
    private CheckBox karakterekszam_CHECKBOX;

    @FXML
    private Button eredmeny_mentese_BUTTON;


    @FXML
    void eredmenyek_menteseFUNCTION(MouseEvent event) {
        ellenorizKaraktereket();
        frissitEredmenyekMenteseGomb();
    }

    private void ellenorizKaraktereket() {
        String input = beker_TF.getText();
        boolean helyesKarakterek = input.matches("[12X]*");

        if (helyesKarakterek) {
            helytelenKarakter_CHECKBOX.setSelected(false);
            helytelenKarakter_CHECKBOX.setText("");
        } else {
            helytelenKarakter_CHECKBOX.setSelected(true);
            helytelenKarakter_CHECKBOX.setText("Helytelen karakterek az eredményekben(" + input.replaceAll("[12X]", "")+")");
        }

        karakterekszam_CHECKBOX.setText("Nem megfelelő a karakterek száma(" + input.length() + ")");
    }

    private void frissitEredmenyekMenteseGomb() {
        boolean hiba = helytelenKarakter_CHECKBOX.isSelected() || !karakterekszam_CHECKBOX.getText().equals("(14)");
        eredmeny_mentese_BUTTON.setDisable(hiba);
    }
}
