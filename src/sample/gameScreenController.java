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
import java.util.*;

public class gameScreenController implements Initializable {

    @FXML private AnchorPane gamePane;
    @FXML private Button kembali;
    @FXML private Button ch1;
    @FXML private Button ch2;
    @FXML private Button ch3;
    @FXML private Button ch4;
    @FXML private Label questionLabel;

    @FXML private Question question;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.question = new Question();
        List<String> ansList = this.question.getAnswers();
        Collections.shuffle(ansList);

        ch1.setText(ansList.get(0));
        ch2.setText(ansList.get(1));
        ch3.setText(ansList.get(2));
        ch4.setText(ansList.get(3));

        questionLabel.setText(this.question.getQuestion());

    }

    public void klikKembali(ActionEvent event){
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            gamePane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void klikch2(){
        if (ch2.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
        }else {
            System.out.println("wrong answer");
        }
    }
    public void klikch3(){
        if (ch3.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
        }else {
            System.out.println("wrong answer");
        }
    }
    public void klikch4(){
        if (ch4.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
        }else {
            System.out.println("wrong answer");
        }
    }
    public void klikch1(){
        if (ch1.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
        }else {
            System.out.println("wrong answer");
        }
    }

}
