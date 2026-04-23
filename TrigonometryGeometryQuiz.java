import java.util.Random;
import java.util.Scanner;

/**
 * TrigonometryGeometryQuiz manages all trigonometry and geometry questions.
 * Uses 2D array structure where each row contains [question, answer,
 * explanation].
 */
public class TrigonometryGeometryQuiz {
    private String[][] quizData; // 2D array: [question_index][0=q, 1=a, 2=explanation]
    private int score;
    private int questionsAsked;
    private Random random;

    /**
     * Constructs TrigonometryGeometryQuiz and initializes all questions.
     */
    public TrigonometryGeometryQuiz() {
        this.random = new Random();
        this.score = 0;
        this.questionsAsked = 0;
        initializeQuestions();
    }

    /**
     * Initializes the 2D array with all geometry questions, answers, and
     * explanations.
     */
    private void initializeQuestions() {
        quizData = new String[10][3]; // 10 questions, 3 columns (Q, A, E)

        quizData[0][0] = "What is the area of a rectangle with length 8 and width 5?";
        quizData[0][1] = "40";
        quizData[0][2] = "Area = length × width = 8 × 5 = 40 square units";

        quizData[1][0] = "What is the circumference of a circle with radius 3?";
        quizData[1][1] = "6π";
        quizData[1][2] = "Circumference = 2πr = 2π(3) = 6π";

        quizData[2][0] = "Find the area of a triangle with base 10 and height 6.";
        quizData[2][1] = "30";
        quizData[2][2] = "Area = (1/2) × base × height = (1/2) × 10 × 6 = 30 square units";

        quizData[3][0] = "What is the Pythagorean theorem?";
        quizData[3][1] = "a² + b² = c²";
        quizData[3][2] = "For a right triangle: a² + b² = c², where c is the hypotenuse";

        quizData[4][0] = "If a right triangle has legs of 3 and 4, what is the hypotenuse?";
        quizData[4][1] = "5";
        quizData[4][2] = "c² = 3² + 4² = 9 + 16 = 25 → c = 5";

        quizData[5][0] = "What is sin(90°)?";
        quizData[5][1] = "1";
        quizData[5][2] = "sin(90°) = 1 by definition of the sine function";

        quizData[6][0] = "What is the volume of a cube with side length 4?";
        quizData[6][1] = "64";
        quizData[6][2] = "Volume = side³ = 4³ = 64 cubic units";

        quizData[7][0] = "What is cos(0°)?";
        quizData[7][1] = "1";
        quizData[7][2] = "cos(0°) = 1 by definition of the cosine function";

        quizData[8][0] = "What is the sum of angles in a triangle?";
        quizData[8][1] = "180°";
        quizData[8][2] = "The sum of interior angles in any triangle is always 180°";

        quizData[9][0] = "What is the area of a circle with radius 5?";
        quizData[9][1] = "25π";
        quizData[9][2] = "Area = πr² = π(5)² = 25π square units";
    }

    /**
     * Runs the trigonometry and geometry quiz.
     *
     * @param scanner the Scanner for user input
     */
    public void runQuiz(Scanner scanner) {
        System.out.println("\n=== Trigonometry and Geometry ===\n");
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
