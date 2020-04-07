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

    Question(){
        try {
            List<String> allLines = Files.readAllLines(Paths.get("./src/assets/question.txt"));
            this.answer = allLines.get(4);
            this.question = allLines.get(0);
            this.answers.add(allLines.get(1));
            this.answers.add(allLines.get(2));
            this.answers.add(allLines.get(3));
            this.answers.add(allLines.get(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
