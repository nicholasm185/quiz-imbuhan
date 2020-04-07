package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainMenuController implements Initializable {

    @FXML private Button mulai;
    @FXML private Button tentangKami;
    @FXML private Button bantuan;
    @FXML private AnchorPane rootPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void klikMulai(ActionEvent event){
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("gameScreen.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
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
