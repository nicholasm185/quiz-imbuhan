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

    @FXML public Button benar;
    @FXML public Button salah;
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
        this.question = new Question(Main.questionNumber);
        questionLabel.setText(this.question.getQuestion());
        if(this.question.getType() == 1){
            List<String> ansList = this.question.getAnswers();
            Collections.shuffle(ansList);

            ch1.setText(ansList.get(0));
            ch2.setText(ansList.get(1));
            ch3.setText(ansList.get(2));
            ch4.setText(ansList.get(3));

            ch1.setVisible(true);
            ch2.setVisible(true);
            ch3.setVisible(true);
            ch4.setVisible(true);

            ch1.setDisable(false);
            ch2.setDisable(false);
            ch3.setDisable(false);
            ch4.setDisable(false);
        } else if (this.question.getType() == 2){
            benar.setVisible(true);
            benar.setDisable(false);
            salah.setVisible(true);
            salah.setDisable(false);
        }
        Main.questionNumber += 1;

    }

    public void klikKembali(ActionEvent event){
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            gamePane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToNext(){
        if (Main.questionNumber <= Main.numQuestions){
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("gameScreen.fxml"));
                gamePane.getChildren().setAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            try {
                Main.questionNumber = 1;
                AnchorPane pane = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
                gamePane.getChildren().setAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void klikch2(){
        if (ch2.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
        }else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

    public void klikch3(){
        if (ch3.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
        }else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

    public void klikch4(){
        if (ch4.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
        }else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

    public void klikch1(){
        if (ch1.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
        }else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

    public void klikBenar(){
        if(this.question.getAnswer().equals("benar")){
            System.out.println("correct answer");
        }else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

    public void klikSalah(){
        if(this.question.getAnswer().equals("salah")){
            System.out.println("correct answer");
        } else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

}
