import java.util.Random;
import java.util.Scanner;

/**
 * Manages the quiz logic for a given category of math questions.
 * Displays questions, checks answers, and tracks scores.
 */
public class MathQuiz {
    private QuestionBank questionBank;
    private int category;
    private int score;
    private int questionsAsked;
    private Random random;
    private Scanner scanner;

    /**
     * Constructs a MathQuiz for a specific category.
     *
     * @param questionBank the QuestionBank containing all questions
     * @param category     the category to quiz on
     * @param scanner      the Scanner for user input
     */
    public MathQuiz(QuestionBank questionBank, int category, Scanner scanner) {
        this.questionBank = questionBank;
        this.category = category;
        this.scanner = scanner;
        this.random = new Random();
        this.score = 0;
        this.questionsAsked = 0;
    }

    /**
     * Runs the quiz for this category.
     * Asks up to 5 questions, allows user to skip after each.
     */
    public void startQuiz() {
        System.out.println("\n=== " + questionBank.getCategoryName(category) + " ===\n");

        int maxQuestions = 5;
        int categorySize = questionBank.getCategorySize(category);

        while (questionsAsked < maxQuestions) {
            // Get random question
            int randomIndex = random.nextInt(categorySize);
            Question question = questionBank.getQuestion(category, randomIndex);

            // Display question
            System.out.println("Question " + (questionsAsked + 1) + " of " + maxQuestions + ":");
            System.out.println(question.getQuestionText());
            System.out.print("Your answer: ");
            System.out.flush();

            String userAnswer = scanner.nextLine().trim();

            // Check answer
            if (question.isCorrect(userAnswer)) {
                System.out.println("✓ Correct! You earned 1 point.");
                score++;
            } else {
                System.out.println("✗ Incorrect. The correct answer is: " + question.getAnswer());
            }

            System.out.println("Explanation: " + question.getExplanation());
            questionsAsked++;

            // Ask to continue (except after last question)
            if (questionsAsked < maxQuestions) {
                System.out.print("\nContinue to next question? (yes/no): ");
                System.out.flush();
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("no")) {
                    break;
                }
                System.out.println();
            }
        }

        displayScore();
    }

    /**
     * Displays the final quiz score.
     */
    private void displayScore() {
        System.out.println("\n========== FINAL SCORE ==========");
        System.out.println("You answered " + score + " out of " + questionsAsked + " questions correctly!");
        if (questionsAsked > 0) {
            double percentage = (score * 100.0) / questionsAsked;
            System.out.printf("Percentage: %.1f%%\n", percentage);
        }
        System.out.println("=================================\n");
    }

    /**
     * Gets the score from this quiz.
     *
     * @return the number of correct answers
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets the number of questions asked in this quiz.
     *
     * @return the count of questions
     */
    public int getQuestionsAsked() {
        return questionsAsked;
    }
}
