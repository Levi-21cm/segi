package hu.katolikuskeri.taxifuvarok.gui;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import hu.katolikuskeri.taxifuvarok.cli.Fuvar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FoAblakController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField borravalo_TF;

    @FXML
    private ChoiceBox<String> fizetesimod_ChoiceBox;

    @FXML
    private DatePicker fuvardatum_DP;

    @FXML
    private TextField fuvaridopontja_TF;

    @FXML
    private TextField fuvaridotartam_TF;

    @FXML
    private ListView<Fuvar> tablazat_ListView;

    @FXML
    private TextField tavolsag_TF;

    @FXML
    private TextField taxiID_TF;

    @FXML
    private TextField viteldij_TF;

    @FXML
    private void kivalasztas(MouseEvent event) {
        int index = tablazat_ListView.getSelectionModel().getSelectedIndex();
        Fuvar kivalasztott = tablazat_ListView.getItems().get(index);

        taxiID_TF.setText(kivalasztott.getTaxi_id());
        //fuvardatum_DP.setValue(LocalDate.from(LocalTime.of(kivalasztott.getIndulas().getHour(), kivalasztott.getIndulas().getMinute())));
        fuvaridopontja_TF.setText(String.valueOf(LocalTime.of(kivalasztott.getIndulas().getHour(),kivalasztott.getIndulas().getMinute())));
        fuvaridotartam_TF.setText(String.valueOf(kivalasztott.getIdotartam()));
        tavolsag_TF.setText(String.valueOf(kivalasztott.getTavolsag()));
        viteldij_TF.setText(String.valueOf(kivalasztott.getViteldij()));
        borravalo_TF.setText(String.valueOf(kivalasztott.getBorravalo()));
        fizetesimod_ChoiceBox.setValue(kivalasztott.getFizetes_modja());


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fizetesimod_ChoiceBox.getItems().add("bankkártyás");
        fizetesimod_ChoiceBox.getItems().add("készpénz");

        for (Fuvar elem : App.fuvarozas) {
            tablazat_ListView.getItems().add(elem);
        }
    }
}
