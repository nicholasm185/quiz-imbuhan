package sample;

import javafx.scene.control.Alert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Question {

    private List<String> answers = new ArrayList<>();
    private String answer;
    private String question;
    private int type;



    Question(int questionNo) throws IOException{
            List<String> allLines = Files.readAllLines(Paths.get(Main.questionpath+"/question"+questionNo+".txt"));
            this.type = Integer.parseInt(allLines.get(0));
            this.question = allLines.get(1);
            if (this.type == 1){
                this.answer = allLines.get(5);
                this.answers.add(allLines.get(2));
                this.answers.add(allLines.get(3));
                this.answers.add(allLines.get(4));
                this.answers.add(allLines.get(5));
            } else if (this.type == 2 || this.type == 3){
                this.answer = allLines.get(2);
            } else if(this.type == 4){
                this.answers.add(allLines.get(2));
                this.answers.add(allLines.get(3));
                this.answer = allLines.get(3);
            }
    }

    public int getType() {
        return type;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
