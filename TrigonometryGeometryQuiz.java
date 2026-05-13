import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    /**
     * Constructs TrigonometryGeometryQuiz and initializes all questions.
     */
    public TrigonometryGeometryQuiz() {
        this.score = 0;
        this.questionsAsked = 0;
        initializeQuestions();
    }

    private void initializeQuestions() {
        quizData = new String[15][3]; // 15 questions, 3 columns (Q, A, E)

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
        quizData[6][2] = "Volume = side³ = 4³ = 64 cubic u^nits";

        quizData[7][0] = "What is cos(0°)?";
        quizData[7][1] = "1";
        quizData[7][2] = "cos(0°) = 1 by definition of the cosine function";

        quizData[8][0] = "What is the sum of angles in a triangle?";
        quizData[8][1] = "180°";
        quizData[8][2] = "The sum of interior angles in any triangle is always 180°";

        quizData[9][0] = "Line p is defined by 5x + 6y = 30. Line q is perpendicular to line p in the xy - plane. What is the slope of line q? Answer in fraction form";
        quizData[9][1] = "6/5";
        quizData[9][2] = "We know that if two lines in the xy-plane are perpendicular to each other, the product of their slopes equals −1.Thus,m is slope, (m1)(m2)=−1 Transforming 5x+6y=30 to y=mx+b form, we get 6y=−5x+30. Then divide by 6 to get y=−5/6x+5. Thus, slope =m1=−5/6. So, We know that m1m2=−1 -> -5/6 x m2 = -1 -> dividing with flip the numerator and denominator -> m2 = 6/5";

        quizData[10][0] = "What is the area of a circle with radius 5?";
        quizData[10][1] = "25π";
        quizData[10][2] = "Area = πr² = π(5)² = 25π square units";

        quizData[11][0] = "What is the tangent of 45°?";
        quizData[11][1] = "1";
        quizData[11][2] = "tan(45°) = 1 by definition of the tangent function";

        quizData[12][0] = "What is the area of a parallelogram with base 12 and height 7?";
        quizData[12][1] = "84";
        quizData[12][2] = "Area = base × height = 12 × 7 = 84 square units";

        quizData[13][0] = "What is the sine of 30°?";
        quizData[13][1] = "0.5";
        quizData[13][2] = "sin(30°) = 0.5 by definition of the sine function";

        quizData[14][0] = "What is the volume of a cylinder with radius 3 and height 5?";
        quizData[14][1] = "45π";
        quizData[14][2] = "Volume = πr²h = π(3)²(5) = 45π cubic units";

    }

    /**
     * Initializes the 2D array with all geometry questions, answers, and
     * explanations.
     */

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

        // Shuffle indices so no repeats
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < quizData.length; i++)
            indices.add(i);
        Collections.shuffle(indices);

        while (questionsAsked < maxQuestions) {
            int idx = indices.get(questionsAsked);

            System.out.println("Question " + (questionsAsked + 1) + " of " + maxQuestions + ":");
            System.out.println(quizData[idx][0]);
            System.out.print("Your answer: ");
            System.out.flush();

            String userAnswer = scanner.nextLine().trim();

            if (isCorrect(userAnswer, quizData[idx][1])) {
                System.out.println("✓ Correct! You earned 1 point.");
                score++;
            } else {
                System.out.println("✗ Incorrect. The correct answer is: " + quizData[idx][1]);
            }

            System.out.println("Explanation: " + quizData[idx][2]);
            questionsAsked++;

            if (questionsAsked < maxQuestions) {
                System.out.print("\nContinue to next question? (yes/no): ");
                System.out.flush();
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("no"))
                    break;
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
        return answer
                .toLowerCase()
                .trim()
                .replace(" ", "")
                .replace("²", "^2")
                .replace("³", "^3")
                .replace("⁴", "^4")
                .replace("¹", "^1")
                .replace("**", "^")
                .replace("pi", "π")
                .replace("sqrt", "√")
                .replaceAll("[\\$,£€¥]", "");
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
