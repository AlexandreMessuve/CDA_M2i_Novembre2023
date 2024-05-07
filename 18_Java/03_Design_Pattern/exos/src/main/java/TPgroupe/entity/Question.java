package TPgroupe.entity;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder

public class Question {
    private String question;
    private ArrayList<String> options;
    private int correctOptionIndex;

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctOptionIndex;
    }
}
