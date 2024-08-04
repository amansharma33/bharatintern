import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {

    // Question class to hold question text and answer
    static class Question {
        String questionText;
        String answer;

        Question(String questionText, String answer) {
            this.questionText = questionText;
            this.answer = answer;
        }

        boolean checkAnswer(String userAnswer) {
            return this.answer.equalsIgnoreCase(userAnswer.trim());
        }
    }

    // List to hold questions
    private static final List<Question> QUESTIONS = new ArrayList<>();

    static {
        // Adding some questions to the list
        QUESTIONS.add(new Question("What is the capital of France?", "Paris"));
        QUESTIONS.add(new Question("What is 2 + 2?", "4"));
        QUESTIONS.add(new Question("Who wrote 'To Kill a Mockingbird'?", "Harper Lee"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Quiz App!");

        // Iterate through the list of questions
        for (Question question : QUESTIONS) {
            System.out.println(question.questionText);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            // Check the user's answer
            if (question.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + question.answer);
            }
            System.out.println(); // Blank line for readability
        }

        // Print the final score
        System.out.println("Quiz Over! Your score is: " + score + "/" + QUESTIONS.size());
        scanner.close();
    }
}
