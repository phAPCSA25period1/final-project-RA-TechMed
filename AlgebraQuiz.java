import java.util.Random;
import java.util.Scanner;

/**
 * AlgebraQuiz manages all algebra questions with 2D array structure.
 * Each row contains [question, answer, explanation].
 * Demonstrates encapsulation with private data and public methods.
 */
public class AlgebraQuiz {
    private String[][] quizData; // 2D array: [question_index][0=question, 1=an, 2=explanation]
    private int score;
    private int questionsAsked;
    private Random random;

    /**
     * Constructs AlgebraQuiz and initializes all questions.
     */
    public AlgebraQuiz() {
        this.random = new Random();
        this.score = 0;
        this.questionsAsked = 0;
        initializeQuestions();
    }

    /**
     * Initializes the 2D array with all algebra questions, answers, and
     * explanations.
     */
    private void initializeQuestions() {
        quizData = new String[20][3]; // 20 questions, 3 columns (Q, A, E)

        quizData[0][0] = "The total cost to make 10,000 units of a pen is f(x)=40,000+10,000x. What is the total cost when per unit cost is $1.20?";
        quizData[0][1] = "$52,000";
        quizData[0][2] = "f(1.20)=40,000+10,000×1.20 → f(1.20)=40,000+12,000 → f(1.20)=$52,000";

        quizData[1][0] = "Iris bought chewing gum and donuts for $90. Each packet costs $4, each donut costs $2. If she bought 15 packets of gum, how many donuts?";
        quizData[1][1] = "15";
        quizData[1][2] = "4×15 + 2×d = 90 → 60 + 2d = 90 → 2d = 30 → d = 15";

        quizData[2][0] = "Kevin runs at 9.30 minutes per mile. Which models miles in x minutes? A) x/9.30 B) 9.30+x C) 9.30/x D) 9.30x";
        quizData[2][1] = "A";
        quizData[2][2] = "To cover 1 mile takes 9.30 minutes. So in x minutes, he covers x/9.30 miles.";

        quizData[3][0] = "f(x) = x/20 + 20. What is the y-intercept? A) (20,0) B) (0,20) C) (0,0) D) (20,20)";
        quizData[3][1] = "B";
        quizData[3][2] = "Y-intercept: x=0 → f(0)=0/20+20=20. Point is (0,20).";

        quizData[4][0] = "7 more than 10 times x equals 104. Which equation? A) 10x+7=104 B) 7x+10=104 C) 10x-7=104";
        quizData[4][1] = "A";
        quizData[4][2] = "10 times x is 10x. 7 more is 10x+7. So: 10x+7=104";

        quizData[5][0] = "Simplify: 7x - 3x + 5";
        quizData[5][1] = "4x+5";
        quizData[5][2] = "Combine like terms: (7-3)x + 5 = 4x + 5";

        quizData[6][0] = "Solve for x: 2x - 8 = 4";
        quizData[6][1] = "x=6";
        quizData[6][2] = "2x - 8 = 4 → 2x = 12 → x = 6";

        quizData[7][0] = "Simplify: 5x/5 + 2";
        quizData[7][1] = "x+2";
        quizData[7][2] = "5x/5 = x. So x + 2";

        quizData[8][0] = "Solve for x: x/3 = 4";
        quizData[8][1] = "x=12";
        quizData[8][2] = "x/3 = 4 → x = 4 × 3 → x = 12";

        quizData[9][0] = "Simplify: (x + 2)(x - 2)";
        quizData[9][1] = "x²-4";
        quizData[9][2] = "Difference of squares: (a+b)(a-b) = a² - b²";

        quizData[10][0] = "Solve for x: 3x + 6 = 18";
        quizData[10][1] = "x=4";
        quizData[10][2] = "3x + 6 = 18 → 3x = 12 → x = 4";

        quizData[11][0] = "Simplify: 8x - 2x + 3x";
        quizData[11][1] = "9x";
        quizData[11][2] = "Combine like terms: (8-2+3)x = 9x";

        quizData[12][0] = "Solve for x: 4x - 12 = 0";
        quizData[12][1] = "x = 3";
        quizData[12][2] = "4x - 12 = 0 → 4x = 12 → x = 3";

        quizData[13][0] = "Simplify: 2x + x² - x";
        quizData[13][1] = "x² + x";
        quizData[13][2] = "Combine like terms: x² + (2-1)x = x² + x";

        quizData[14][0] = "Solve for x: 6 + 2x = 16";
        quizData[14][1] = "x = 5";
        quizData[14][2] = "6 + 2x = 16 → 2x = 10 → x = 5";

        quizData[15][0] = "Simplify: (2x)³";
        quizData[15][1] = "8x³";
        quizData[15][2] = "Power rule: (2x)³ = 2³ × x³ = 8x³";

        quizData[16][0] = "Solve for x: x + 5 = 12";
        quizData[16][1] = "x = 7";
        quizData[16][2] = "x + 5 = 12 → x = 7";

        quizData[17][0] = "Simplify: 10x ÷ 2x";
        quizData[17][1] = "5";
        quizData[17][2] = "10x ÷ 2x = 5";

        quizData[18][0] = "Solve for x: 2(x + 4) = 16";
        quizData[18][1] = "x = 4";
        quizData[18][2] = "2(x+4) = 16 → x+4 = 8 → x = 4";

        quizData[19][0] = "Simplify: 3x² + 2x² - x²";
        quizData[19][1] = "4x²";
        quizData[19][2] = "Combine like terms: (3+2-1)x² = 4x²";
    }

    /**
     * Runs the algebra quiz.
     *
     * @param scanner the Scanner for user input
     */
    public void runQuiz(Scanner scanner) {
        System.out.println("\n=== Algebra ===\n");
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
     * Checks if the user's answer is correct (normalized comparison).
     *
     * @param userAnswer    the user's response
     * @param correctAnswer the correct answer from the quiz data
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
