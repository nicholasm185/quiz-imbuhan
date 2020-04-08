package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class Main extends Application {

//    untuk menyimpan skor;
    public static int numQuestions = 10;
    public static int questionNumber = 1;
    public static int jawabanBenar = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 640));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        numQuestions = Objects.requireNonNull(new File("./src/assets").list()).length;
        System.out.println("no of questions: " + numQuestions);

        launch(args);
    }
}
