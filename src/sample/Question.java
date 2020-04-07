package sample;

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



    Question(int questionNo){
        try {
            List<String> allLines = Files.readAllLines(Paths.get("./src/assets/question"+questionNo+".txt"));
            this.type = Integer.parseInt(allLines.get(0));
            this.question = allLines.get(1);
            if (this.type == 1){
                this.answer = allLines.get(5);
                this.answers.add(allLines.get(2));
                this.answers.add(allLines.get(3));
                this.answers.add(allLines.get(4));
                this.answers.add(allLines.get(5));
            }
            if (this.type == 2){
                this.answer = allLines.get(2);
            }

        } catch (IOException e) {
            e.printStackTrace();
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
