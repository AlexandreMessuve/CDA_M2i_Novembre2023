package TPgroupe.entity;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Scanner;

public class Quiz {
    private UUID id;
    private String difficulte;
    private ArrayList<Question> questions;

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuizz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        for (Question question : questions) {

            question.displayQuestion();
            System.out.print("Votre réponse: ");
            int answer = scanner.nextInt();
            if (question.isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Faux");
            }
            System.out.println();
        }
        System.out.println("Votre score " + score + "/" + questions.size());
    }
}
