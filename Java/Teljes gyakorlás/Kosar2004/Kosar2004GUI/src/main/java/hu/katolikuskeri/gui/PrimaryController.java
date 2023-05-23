package hu.katolikuskeri.gui;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import hu.katolikuskeri.cli.Eredmeny;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PrimaryController implements Initializable {

    @FXML
    private TextField hazaiPont_TF;

    @FXML
    private TextField hazai_FT;

    @FXML
    private TextField helyszin_TF;

    @FXML
    private TextField idegenPont_TF;

    @FXML
    private TextField idegen_TF;

    @FXML
    private TextField idopont_TF;

    @FXML
    private ListView<Eredmeny> lista;

    @FXML
    void adat_modositas(MouseEvent event) {
        int index = lista.getSelectionModel().getSelectedIndex();
        Eredmeny kivalasztott = lista.getItems().get(index);
        if (helyszin_TF.getText().equals("")){
            Alert hiba = new Alert(Alert.AlertType.ERROR);
            hiba.setTitle("Hiba");
            hiba.setHeaderText("Nem lehet üres a helyszín");

            hiba.showAndWait();

        }else {
            kivalasztott.setHelyszín(helyszin_TF.getText());
            lista.refresh();
        }
    }
    @FXML
    void kj(MouseEvent event) {
        int index = lista.getSelectionModel().getSelectedIndex();
        Eredmeny kivalasztott = lista.getItems().get(index);

        hazai_FT.setText(kivalasztott.getHaza());
        //fuvardatum_DP.setValue(LocalDate.from(LocalTime.of(kivalasztott.getIndulas().getHour(), kivalasztott.getIndulas().getMinute())));
        idegen_TF.setText(kivalasztott.getIdegen());
        hazaiPont_TF.setText(String.valueOf(kivalasztott.getHazai_pont()));
        idegenPont_TF.setText(String.valueOf(kivalasztott.getIdegen_pont()));
        helyszin_TF.setText(kivalasztott.getHelyszín());
        idopont_TF.setText(String.valueOf(kivalasztott.getIdegen_pont()));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        for (Eredmeny elem: App.eredmenyek){
            lista.getItems().add(elem);
        }
    }
}
