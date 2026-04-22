import java.util.Scanner;

/**
 * AP Computer Science A Final Project: Math Randomizer Quiz
 *
 * This is an interactive math quiz application designed for high school
 * students to practice and improve their math skills across multiple topics:
 * - Algebra
 * - Advanced Math
 * - Problem-Solving and Data Analysis
 * - Geometry and Trigonometry
 *
 * The application uses a menu-driven interface to let users select a topic,
 * then presents 5 randomized questions from that topic with feedback and
 * explanations.
 *
 * @author RA-TechMed
 * @version 2.0
 */
public class App {
    private static QuestionBank questionBank;
    private static Scanner scanner;

    public static void main(String[] args) {
        // Initialize shared resources
        questionBank = new QuestionBank();
        scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  Welcome to Math Randomizer Quiz v2.0  ║");
        System.out.println("║  AP Computer Science A Final Project   ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // Main menu loop
        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    runQuiz(QuestionBank.ALGEBRA);
                    break;
                case 2:
                    runQuiz(QuestionBank.ADVANCED_MATH);
                    break;
                case 3:
                    runQuiz(QuestionBank.PROBLEM_SOLVING);
                    break;
                case 4:
                    runQuiz(QuestionBank.GEOMETRY);
                    break;
                case 5:
                    System.out.println("Thank you for using Math Randomizer! Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.\n");
            }
        }

        scanner.close();
    }

    /**
     * Displays the main menu with available quiz topics.
     */
    private static void displayMenu() {
        System.out.println("═══════════════════════════════════════");
        System.out.println("        AVAILABLE TOPICS");
        System.out.println("═══════════════════════════════════════");
        System.out.println("1. " + questionBank.getCategoryName(QuestionBank.ALGEBRA));
        System.out.println("2. " + questionBank.getCategoryName(QuestionBank.ADVANCED_MATH));
        System.out.println("3. " + questionBank.getCategoryName(QuestionBank.PROBLEM_SOLVING));
        System.out.println("4. " + questionBank.getCategoryName(QuestionBank.GEOMETRY));
        System.out.println("5. Quit");
        System.out.println("═══════════════════════════════════════");
    }

    /**
     * Gets a valid menu choice from the user.
     *
     * @return the user's choice (1-5)
     */
    private static int getUserChoice() {
        System.out.print("Choose a subject (1-5): ");
        System.out.flush();

        int choice = -1;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        } catch (Exception e) {
            scanner.nextLine(); // Clear invalid input
            choice = -1;
        }

        return choice;
    }

    /**
     * Runs a quiz for the specified category.
     * Creates a MathQuiz instance and starts it.
     *
     * @param category the category index to quiz on
     */
    private static void runQuiz(int category) {
        MathQuiz quiz = new MathQuiz(questionBank, category, scanner);
        quiz.startQuiz();
    }
}
