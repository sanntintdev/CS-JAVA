package AssignmentOne;
import java.util.*;

// Create a class to represent a multiple-choice question
class Question {
    String question;
    Map<String, String> options;
    String correctAnswer;

    /* 
    I went with a Map for the multiple choices 
    because it lets me pair up options with their corresponding keys.
    */

    Question(String question, Map<String, String> options, String correctAnswer) {
        this.question = question; // THE ACTUAL QUESTION
        this.options = options; // MULTIPLE CHOICES
        this.correctAnswer = correctAnswer; // THE CORRECT ANSWER
    }
}

public class MultipleChoice {
    public static void main(String[] args) {
        // Create a list to store the questions
        List<Question> questions = new ArrayList<>();

        // Add multiple-choice questions with options
        questions.add(new Question(
                "What is 5 + 5?",
                Map.of("A", "5", "B", "10", "C", "15", "D", "20"),
                "B"));

        questions.add(new Question("What is 10 - 3?",
                Map.of("A", "5", "B", "7", "C", "10", "D", "13"),
                "B"));

        questions.add(new Question("What is 3 * 4?",
                Map.of("A", "7", "B", "10", "C", "12", "D", "15"),
                "C"));

        questions.add(new Question("What is 20 / 4?",
                Map.of("A", "2", "B", "4", "C", "5", "D", "6"),
                "C"));

        questions.add(new Question("What is 10 % 3?",
                Map.of("A", "1", "B", "2", "C", "3", "D", "4"),
                "A"));

        // Prompt the user for answers
        Scanner scanner = new Scanner(System.in);
        int correctResponses = 0;

        for (Question question : questions) {
            // Display the question and options
            System.out.println("Question: " + question.question);
            for (Map.Entry<String, String> option : question.options.entrySet()) {
                System.out.println(option.getKey() + ". " + option.getValue());
            }

            // Prompt user for an answer
            System.out.print("Enter your answer (A, B, C, or D): ");

            // Convert the user's answer to uppercase for case-insensitive comparison
            String userAnswer = scanner.next().toUpperCase();

            // Check if the user's answer is correct
            if (userAnswer.equals(question.correctAnswer)) {
                System.out.println("Correct!\n");
                correctResponses++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + question.correctAnswer + "\n");
            }
        }

        // Calculate and display the final score
        int totalQuestions = questions.size();
        double percentage = (double) correctResponses / totalQuestions * 100;

        System.out.println("Your final score: " + correctResponses + " out of " + totalQuestions);
        System.out.println("Percentage: " + percentage + "%");

        // Close the scanner
        scanner.close();
    }
}
