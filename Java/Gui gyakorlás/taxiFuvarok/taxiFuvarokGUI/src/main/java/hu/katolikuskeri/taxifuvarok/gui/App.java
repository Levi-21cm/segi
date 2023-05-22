package hu.katolikuskeri.taxifuvarok.gui;

import hu.katolikuskeri.taxifuvarok.cli.Fuvar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    public static ArrayList<Fuvar> fuvarozas = new ArrayList<>();
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        FileChooser megnyitasAblak = new FileChooser();
        megnyitasAblak.setTitle("kérem adja meg az állományt");
        megnyitasAblak.setInitialDirectory(new File("."));


        fuvarozas= Fuvar.beolvas(megnyitasAblak.showOpenDialog(stage).getAbsolutePath());

        scene = new Scene(loadFXML("FoAblak-view"), 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}