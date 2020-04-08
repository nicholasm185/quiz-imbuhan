package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.NoSuchFileException;
import java.util.Objects;
import java.util.ResourceBundle;

public class mainMenuController implements Initializable {

    @FXML private Button muatPertanyaan;
    @FXML private Button mulai;
    @FXML private Button tentangKami;
    @FXML private Button bantuan;
    @FXML private AnchorPane rootPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void klikMuatPertanyaan(){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Pilih folder berisi pertanyaan");
        Stage stage = (Stage) rootPane.getScene().getWindow();

        File file = directoryChooser.showDialog(stage);

        Main.questionpath = file.getAbsolutePath();

        Main.numQuestions = Objects.requireNonNull(file.list()).length;

    }

    public void klikMulai(ActionEvent event){
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("gameScreen.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void klikTentangKami(ActionEvent event){
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("tentangKamiScreen.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void klikBantuan(ActionEvent event){
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("bantuanScreen.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
