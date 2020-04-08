package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class hasilController implements Initializable {


    @FXML private Label total;
    @FXML private Label skor;
    @FXML private Button kembali;
    @FXML private AnchorPane hasilPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.total.setText(String.valueOf(Main.numQuestions));
        this.skor.setText(String.valueOf(Main.jawabanBenar));
    }

    public void klikKembali(ActionEvent event){
        try {
            Main.jawabanBenar = 0;
            AnchorPane pane = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            hasilPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
