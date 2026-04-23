import java.util.Random;
import java.util.Scanner;

/**
 * ProblemSolvingDataAnalysisQuiz manages all problem-solving and data analysis
 * questions.
 * Uses 2D array structure where each row contains [question, answer,
 * explanation].
 */
public class ProblemSolvingDataAnalysisQuiz {
    private String[][] quizData; // 2D array: [question_index][0=q, 1=a, 2=explanation]
    private int score;
    private int questionsAsked;
    private Random random;

    /**
     * Constructs ProblemSolvingDataAnalysisQuiz and initializes all questions.
     */
    public ProblemSolvingDataAnalysisQuiz() {
        this.random = new Random();
        this.score = 0;
        this.questionsAsked = 0;
        initializeQuestions();
    }

    /**
     * Initializes the 2D array with all problem-solving questions, answers, and
     * explanations.
     */
    private void initializeQuestions() {
        quizData = new String[10][3]; // 10 questions, 3 columns (Q, A, E)

        quizData[0][0] = "A store sells items at $12 each. If they sell 50 items, what is the total revenue?";
        quizData[0][1] = "$600";
        quizData[0][2] = "Total = Price × Quantity = $12 × 50 = $600";

        quizData[1][0] = "The average of 5 numbers is 20. What is their sum?";
        quizData[1][1] = "100";
        quizData[1][2] = "Average = Sum / Count → 20 = Sum / 5 → Sum = 100";

        quizData[2][0] = "A recipe serves 4 people and uses 2 cups of flour. How much flour for 10 people?";
        quizData[2][1] = "5 cups";
        quizData[2][2] = "Scale factor = 10/4 = 2.5. Flour needed = 2 × 2.5 = 5 cups";

        quizData[3][0] = "What percentage is 15 out of 60?";
        quizData[3][1] = "25%";
        quizData[3][2] = "Percentage = (15/60) × 100 = 0.25 × 100 = 25%";

        quizData[4][0] = "If 3 workers complete a job in 8 hours, how long would 4 workers take?";
        quizData[4][1] = "6 hours";
        quizData[4][2] = "Total work = 3 × 8 = 24 worker-hours. With 4 workers: 24/4 = 6 hours";

        quizData[5][0] = "A car travels 150 miles in 3 hours. What is its average speed?";
        quizData[5][1] = "50 mph";
        quizData[5][2] = "Speed = Distance / Time = 150 / 3 = 50 mph";

        quizData[6][0] = "If a population grows from 1000 to 1200, what is the percent increase?";
        quizData[6][1] = "20%";
        quizData[6][2] = "Increase = 1200 - 1000 = 200. Percent = (200/1000) × 100 = 20%";

        quizData[7][0] = "What is the median of: 3, 7, 5, 9, 1?";
        quizData[7][1] = "5";
        quizData[7][2] = "Sort: 1, 3, 5, 7, 9. The middle value is 5.";

        quizData[8][0] = "If a store discounts an item by 25% from $40, what is the new price?";
        quizData[8][1] = "$30";
        quizData[8][2] = "Discount = $40 × 0.25 = $10. New price = $40 - $10 = $30";

        quizData[9][0] = "What is the mode of: 2, 3, 3, 5, 3, 7?";
        quizData[9][1] = "3";
        quizData[9][2] = "The mode is the most frequently occurring value. 3 appears 3 times.";
    }

    /**
     * Runs the problem-solving and data analysis quiz.
     *
     * @param scanner the Scanner for user input
     */
    public void runQuiz(Scanner scanner) {
        System.out.println("\n=== Problem-Solving and Data Analysis ===\n");
        score = 0;
        questionsAsked = 0;

        int maxQuestions = 5;

        while (questionsAsked < maxQuestions) {
            int randomIndex = random.nextInt(quizData.length);

            System.out.println("Question " + (questionsAsked + 1) + " of " + maxQuestions + ":");
            System.out.println(quizData[randomIndex][0]);
            System.out.print("Your answer: ");
            System.out.flush();

            String userAnswer = scanner.nextLine().trim();

            if (isCorrect(userAnswer, quizData[randomIndex][1])) {
                System.out.println("✓ Correct! You earned 1 point.");
                score++;
            } else {
                System.out.println("✗ Incorrect. The correct answer is: " + quizData[randomIndex][1]);
            }

            System.out.println("Explanation: " + quizData[randomIndex][2]);
            questionsAsked++;

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
     * Checks if the user's answer is correct.
     *
     * @param userAnswer    the user's response
     * @param correctAnswer the correct answer
     * @return true if correct, false otherwise
     */
    private boolean isCorrect(String userAnswer, String correctAnswer) {
        return normalizeAnswer(userAnswer).equals(normalizeAnswer(correctAnswer));
    }

    /**
     * Normalizes answers for flexible comparison.
     *
     * @param answer the answer to normalize
     * @return normalized answer
     */
    private String normalizeAnswer(String answer) {
        if (answer == null)
            return "";
        return answer.replace(" ", "").replace("**", "^").replace("$", "")
                .replace("£", "").replace("€", "").replace("¥", "").replace(",", "")
                .toLowerCase().trim();
    }

    /**
     * Displays the quiz score.
     */
    private void displayScore() {
        System.out.println("\n========== FINAL SCORE ==========");
        System.out.println("You answered " + score + " out of " + questionsAsked + " correctly!");
        if (questionsAsked > 0) {
            System.out.printf("Percentage: %.1f%%\n", (score * 100.0) / questionsAsked);
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
     * Gets the total number of questions in this category.
     *
     * @return the number of questions
     */
    public int getTotalQuestions() {
        return quizData.length;
    }
}
