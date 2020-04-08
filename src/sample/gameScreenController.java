package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class gameScreenController implements Initializable {

    @FXML private ProgressBar progressBar;
    @FXML private Button benar;
    @FXML private Button salah;
    @FXML private TextField jawaban;
    @FXML private Button ajukanJawaban;
    @FXML private Button op1;
    @FXML private Button op2;
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
        try {
            this.question = new Question(Main.questionno.get(Main.questionNumber));
            System.out.println(Main.questionno.get(Main.questionNumber));
            this.progressBar.setProgress((float)Main.questionNumber/(float)Main.numQuestions);
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
            } else if (this.question.getType() == 3){
                jawaban.setVisible(true);
                jawaban.setDisable(false);
                ajukanJawaban.setVisible(true);
                ajukanJawaban.setDisable(false);
            } else if (this.question.getType() == 4){
                List<String> ansList = this.question.getAnswers();
                Collections.shuffle(ansList);

                op1.setText(ansList.get(0));
                op2.setText(ansList.get(1));

                op1.setVisible(true);
                op1.setDisable(false);
                op2.setVisible(true);
                op2.setDisable(false);
            }
            Main.questionNumber += 1;
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Soal-soal tidak ditemukan!");
            alert.setContentText("Mohon untuk memilih folder berisi soal-soal");

            alert.showAndWait();

            try{
                AnchorPane pane = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
                gamePane.getChildren().setAll(pane);
            }catch (IOException ex) {
                ex.printStackTrace();
            }

        }


    }

    public void klikKembali(ActionEvent event){
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            gamePane.getChildren().setAll(pane);
            Main.questionNumber -= 1;
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
                AnchorPane pane = FXMLLoader.load(getClass().getResource("hasilScreen.fxml"));
                gamePane.getChildren().setAll(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void klikch2(){
        if (ch2.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
            Main.jawabanBenar += 1;
        }else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

    public void klikch3(){
        if (ch3.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
            Main.jawabanBenar += 1;
        }else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

    public void klikch4(){
        if (ch4.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
            Main.jawabanBenar += 1;
        }else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

    public void klikch1(){
        if (ch1.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
            Main.jawabanBenar += 1;
        }else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

    public void klikBenar(){
        if(this.question.getAnswer().equals("benar")){
            System.out.println("correct answer");
            Main.jawabanBenar += 1;
        }else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

    public void klikSalah(){
        if(this.question.getAnswer().equals("salah")){
            System.out.println("correct answer");
            Main.jawabanBenar += 1;
        } else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

    public void klikAjukanJawaban(){
        if(this.jawaban.getText().replaceAll("\\s+","").equals(this.question.getAnswer())){
            System.out.println("correct answer");
            Main.jawabanBenar += 1;
        } else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

    public void klikop1(){
        if (this.op1.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
            Main.jawabanBenar += 1;
        }else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

    public void klikop2(){
        if (this.op2.getText().equals(this.question.getAnswer())){
            System.out.println("correct answer");
            Main.jawabanBenar += 1;
        }else {
            System.out.println("wrong answer");
        }
        goToNext();
    }

}
