package sample;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class bantuanController implements Initializable {


    @FXML
    private AnchorPane bantuanPane;

    @FXML
    private Button kembali;

    @FXML
    private Button CaraMemilih;

    @FXML
    private Button CaraMenggunakan;

    @FXML
    private Pane caraMenggunakan;

    @FXML
    private Button next;

    @FXML
    private Button prev;

    @FXML
    private ImageView caraMenggunakanImg;

    @FXML
    private Pane membuatSoal;

    @FXML
    private Button next1;

    @FXML
    private Button prev1;

    @FXML
    private ImageView membuatPertanyaanimg;

    @FXML
    private Button Tutup1;

    @FXML
    private Button Tutup;

    private int tracker=1;
    private int maxpicture=0;
    private int caramenggunakanmax=6;
    private int maxmembuatpertanyaan=22;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    caraMenggunakan.setVisible(false);
    }

    public void klikKembali(ActionEvent event){
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            bantuanPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void next(ActionEvent event) throws FileNotFoundException {
        if(caraMenggunakan.isVisible()){
            if(tracker<caramenggunakanmax){
                prev.setDisable(false);
                tracker+=1;
                FileInputStream input= new FileInputStream("src\\tutorial\\caramenggunakan"+tracker+".png");
                Image image=new Image(input);
                caraMenggunakanImg.setImage(image);
                if(tracker==caramenggunakanmax){
                    next.setDisable(true);
                }
            }
        }
        else if(membuatSoal.isVisible()){
            if(tracker<maxmembuatpertanyaan){
                prev.setDisable(false);
                tracker+=1;
                FileInputStream input= new FileInputStream("src\\tutorial\\membuatpertanyaan"+tracker+".png");
                Image image=new Image(input);
                membuatPertanyaanimg.setImage(image);
                if(tracker==maxmembuatpertanyaan){
                    next1.setDisable(true);
                }
            }

        }
    }

    @FXML
    void prev(ActionEvent event) throws FileNotFoundException {
        if(caraMenggunakan.isVisible()){
            if(tracker>1){
                tracker-=1;
                FileInputStream input= new FileInputStream("src\\tutorial\\caramenggunakan"+tracker+".png");
                Image image=new Image(input);
                caraMenggunakanImg.setImage(image);
                if(tracker==1){
                    prev.setDisable(true);
                }
            }
        }
        else if(membuatSoal.isVisible()){
            if(tracker>1){
                tracker-=1;
                FileInputStream input= new FileInputStream("src\\tutorial\\membuatpertanyaan"+tracker+".png");
                Image image=new Image(input);
                membuatPertanyaanimg.setImage(image);
                if(tracker==1){
                    prev1.setDisable(true);
                }
            }

        }
    }


    @FXML
    void tutorialMenggunakan(ActionEvent event) throws FileNotFoundException {
    caraMenggunakan.setVisible(true);
    prev.setDisable(true);
    FileInputStream input= new FileInputStream("src\\tutorial\\caramenggunakan"+tracker+".png");
    Image image=new Image(input);
    caraMenggunakanImg.setImage(image);

    }

    @FXML
    void tutorialMembuatSoal(ActionEvent event) throws FileNotFoundException {
    membuatSoal.setVisible(true);
    prev1.setDisable(true);
    FileInputStream input= new FileInputStream("src\\tutorial\\membuatpertanyaan"+tracker+".png");
    Image image=new Image(input);
    membuatPertanyaanimg.setImage(image);
    }

    @FXML
    void tutup(ActionEvent event) {
        if(caraMenggunakan.isVisible()) {
            caraMenggunakan.setVisible(false);
        }
        else if(membuatSoal.isVisible()){
            membuatSoal.setVisible(false);
        }
    tracker=1;
    }

}
