package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class tentangKamiController implements Initializable {

    @FXML private ImageView nmhPic;
    @FXML private AnchorPane tentangPane;
    @FXML private Button kembali;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void klikKembali(ActionEvent event){
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            tentangPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
