import java.util.Random;
import java.util.Scanner;

/**
 * AdvancedMathQuiz manages all advanced math questions with 2D array structure.
 * Each row contains [question, answer, explanation].
 */
public class AdvancedMathQuiz {
    private String[][] quizData; // 2D array: [question_index][0=q, 1=a, 2=explanation]
    private int score;
    private int questionsAsked;
    private Random random;

    /**
     * Constructs AdvancedMathQuiz and initializes all questions.
     */
    public AdvancedMathQuiz() {
        this.random = new Random();
        this.score = 0;
        this.questionsAsked = 0;
        initializeQuestions();
    }

    /**
     * Initializes the 2D array with all advanced math questions, answers, and
     * explanations.
     */
    private void initializeQuestions() {
        quizData = new String[10][3]; // 10 questions (Answers. Questions. Explanations )
        quizData[0][0] = "Solve: x² + 5x + 6 = 0";
        quizData[0][1] = "x = -2 or x = -3";
        quizData[0][2] = "Factor: (x+2)(x+3)=0 → x=-2 or x=-3";

        quizData[1][0] = "What is the vertex of y = (x-3)² + 2?";
        quizData[1][1] = "(3, 2)";
        quizData[1][2] = "Vertex form is y = a(x-h)² + k. The vertex is (h, k) = (3, 2)";

        quizData[2][0] = "Simplify: √(16x⁴)";
        quizData[2][1] = "4x²";
        quizData[2][2] = "√(16x⁴) = √16 × √(x⁴) = 4 × x² = 4x²";

        quizData[3][0] = "Solve: 2^(x+1) = 8";
        quizData[3][1] = "x = 2";
        quizData[3][2] = "2^(x+1) = 8 → 2^(x+1) = 2³ → x+1 = 3 → x = 2";

        quizData[4][0] = "What is log₂(32)?";
        quizData[4][1] = "5";
        quizData[4][2] = "2⁵ = 32, so log₂(32) = 5";

        quizData[5][0] = "Simplify: (3x²y³)²";
        quizData[5][1] = "9x⁴y⁶";
        quizData[5][2] = "(3x²y³)² = 3² × (x²)² × (y³)² = 9x⁴y⁶";

        quizData[6][0] = "What is the range of f(x) = -x² + 4?";
        quizData[6][1] = "(-∞, 4]";
        quizData[6][2] = "Parabola opens downward with vertex at (0,4). Maximum is 4, goes to -∞.";

        quizData[7][0] = "Solve: |x - 3| = 5";
        quizData[7][1] = "x = 8 or x = -2";
        quizData[7][2] = "|x-3| = 5 → x-3 = 5 or x-3 = -5 → x = 8 or x = -2";

        quizData[8][0] = "Simplify: (x³ + 2x) / x";
        quizData[8][1] = "x² + 2";
        quizData[8][2] = "(x³ + 2x) / x = x³/x + 2x/x = x² + 2";

        quizData[9][0] = "What is the discriminant of x² + 4x + 4?";
        quizData[9][1] = "0";
        quizData[9][2] = "b² - 4ac = 4² - 4(1)(4) = 16 - 16 = 0";
    }

    /**
     * Runs the advanced math quiz.
     *
     * @param scanner the Scanner for user input
     */
    public void runQuiz(Scanner scanner) {
        System.out.println("=== Advanced Math ===");
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
                System.out.print("Continue to next question? (yes/no): ");
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
        System.out.println("========== FINAL SCORE ==========");
        System.out.println("You answered " + score + " out of " + questionsAsked + " correctly!");
        if (questionsAsked > 0) {
            System.out.print("Percentage: ", (score * 100.0) / questionsAsked);
            System.out.print("Keep practicing and you'll improve even more!");
        }
        System.out.println("=================================");
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
