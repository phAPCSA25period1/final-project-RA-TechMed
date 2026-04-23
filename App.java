import java.util.Scanner;

/**
 * AP Computer Science A Final Project: Math Randomizer Quiz
 *
 * Main application class that orchestrates all quiz categories.
 * Demonstrates composition: App uses 4 different quiz classes
 * (AlgebraQuiz, AdvancedMathQuiz, ProblemSolvingDataAnalysisQuiz,
 * TrigonometryGeometryQuiz).
 *
 * Each quiz class encapsulates its own questions in a 2D array structure.
 * App acts as a controller that displays menus and calls the appropriate quiz
 * method.
 *
 * Key AP CSA Concepts:
 * - Multiple interacting classes (5 total)
 * - Encapsulation (private fields in quiz classes, public methods)
 * - 2D arrays (in each quiz class: questions[index][0=Q, 1=A, 2=E])
 * - Composition (App uses quiz classes)
 * - Clear single responsibilities
 *
 * @author RA-TechMed
 * @version 3.0
 */
public class App {
    // Quiz instances - initialized once and reused
    private static AlgebraQuiz algebraQuiz;
    private static AdvancedMathQuiz advancedMathQuiz;
    private static ProblemSolvingDataAnalysisQuiz problemSolvingQuiz;
    private static TrigonometryGeometryQuiz trigGeomQuiz;
    private static Scanner scanner;

    /**
     * Main method - Entry point for the application.
     * Initializes all quiz objects and runs the menu loop.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize all quiz objects
        algebraQuiz = new AlgebraQuiz();
        advancedMathQuiz = new AdvancedMathQuiz();
        problemSolvingQuiz = new ProblemSolvingDataAnalysisQuiz();
        trigGeomQuiz = new TrigonometryGeometryQuiz();
        scanner = new Scanner(System.in);

        displayWelcome();

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    algebraQuiz.runQuiz(scanner);
                    break;
                case 2:
                    advancedMathQuiz.runQuiz(scanner);
                    break;
                case 3:
                    problemSolvingQuiz.runQuiz(scanner);
                    break;
                case 4:
                    trigGeomQuiz.runQuiz(scanner);
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
     * Displays a welcome banner to the user.
     */
    private static void displayWelcome() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  Welcome to Math Randomizer Quiz v3.0  ║");
        System.out.println("║  AP Computer Science A Final Project   ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    /**
     * Displays the main menu with available quiz topics.
     */
    private static void displayMenu() {
        System.out.println("═══════════════════════════════════════");
        System.out.println("        AVAILABLE TOPICS");
        System.out.println("═══════════════════════════════════════");
        System.out.println("1. Algebra");
        System.out.println("2. Advanced Math");
        System.out.println("3. Problem-Solving and Data Analysis");
        System.out.println("4. Trigonometry and Geometry");
        System.out.println("5. Quit");
        System.out.println("═══════════════════════════════════════");
    }

    /**
     * Gets a valid menu choice from the user.
     * Handles invalid input gracefully.
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
}
