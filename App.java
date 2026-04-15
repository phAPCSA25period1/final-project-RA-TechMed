import java.util.Random;
import java.util.Scanner;

public class App {
    // SWITCH OUT EXPLANATIONS T CORRECT EXPLANATIONS TO CORRECT ANSWERS TO CORERECT
    // QUESTIONS
    private static final String[] algebraQuestions = {
            "The total cost, in dollars, to make 10,000 units of a certain brand of a premium pen is given by, where is the per unit cost, in dollars. What is the total cost, in dollars, to make 10,000 units of the pen when the per unit cost is $1.20?",
            "Imran bought a few packets of chewing gum and donuts for $90. Each packet of chewing gum cost $4, and each donut cost $2. If Imran bought 15 packets of chewing gum, how many donuts did he buy?",
            "For a competition, Kevin runs at an average speed of 9.30 minutes per mile. Which function models miles Kevin will run in minutes at this speed? A) f(x) = x/9.30 B) f(x) = 9.30 + x C) f(x) = 9.30/x D) f(x) = 9.30x",
            "The function f is defined by f(x)",
            "What is x² = 16? Find x (positive solution).",
            "Simplify: 7x - 3x + 5",
            "What is 2x - 8 = 4? Solve for x.",
            "Simplify: 5x/5 + 2",
            "What is x/3 = 4? Solve for x.",
            "Simplify: (x + 2)(x - 2)",
            "What is 3x + 6 = 18? Solve for x.",
            "Simplify: 8x - 2x + 3x",
            "What is 4x - 12 = 0? Solve for x.",
            "Simplify: 2x + x² - x",
            "What is 6 + 2x = 16? Solve for x.",
            "Simplify: (2x)³",
            "What is x + 5 = 12? Solve for x.",
            "Simplify: 10x ÷ 2x",
            "What is 2(x + 4) = 16? Solve for x.",
            "Simplify: 3x² + 2x² - x²"
    };
    // SWITCH OUT EXPLANATIONS T CORRECT EXPLANATIONS TO CORRECT ANSWERS TO CORERECT
    // QUESTIONS
    private static final String[] algebraAnswers = {
            "$52,000",
            "15 Donuts",
            "A",
            "6x + 2",
            "x = 4",
            "4x + 5",
            "x = 6",
            "x + 2",
            "x = 12",
            "x² - 4",
            "x = 4",
            "9x",
            "x = 3",
            "x² + x",
            "x = 5",
            "8x³",
            "x = 7",
            "5",
            "x = 4",
            "4x²"
    };
    // SWITCH OUT EXPLANATIONS T CORRECT EXPLANATIONS TO CORRECT ANSWERS TO CORERECT
    // QUESTIONS
    private static final String[] algebraExplanations = {
            "We are given that the total cost to make 10,000 units of the pen is given by f(x)=40,000+10,000x. Since the per unit cost is $1.20, the total cost would be f(1.20)=40,000+10,000×1.20 -> f(1.20)=40,000+12,000 -> f(1.20)=$52,000",
            "So, we know that Imran bought a few packets of chewing gum and donuts for $90; each packet of chewing gum cost $4, each donut cost $2, and he bought 15 packets of chewing gum. Say Imran bought x donuts; thus, the amount of money he spent on donuts =$2x and the amount of money he spent on chewing gum =$4×15=$60. So, 2x+60 must be equal to $90 -> 2x+60=90 -> x=(90-60)/2 = 15 donuts",
            "We know that Kevin's average speed is 9.30 minutes per mile. Or, to cover one mile, Kevin will take 9.30 minutes; thus, he will cover 1/9.30 miles in 1 minute. So, in x minutes, he will cover x/9.30 miles. Thus, the correct function is  f(x) = x/9.30.",
            "Distribute: 2x + 6 + 4x - 4 = 6x + 2",
            "x² = 16 → x = √16 = 4",
            "Combine like terms: (7 - 3 + 0)x + 5 = 4x + 5",
            "2x - 8 = 4 → 2x = 12 → x = 6",
            "Simplify fraction: x + 2",
            "x/3 = 4 → x = 4 × 3 = 12",
            "Difference of squares: (x + 2)(x - 2) = x² - 4",
            "3x + 6 = 18 → 3x = 12 → x = 4",
            "Combine like terms: (8 - 2 + 3)x = 9x",
            "4x - 12 = 0 → 4x = 12 → x = 3",
            "Combine like terms: x² + (2 - 1)x = x² + x",
            "6 + 2x = 16 → 2x = 10 → x = 5",
            "Power rule: (2x)³ = 2³ × x³ = 8x³",
            "x + 5 = 12 → x = 7",
            "Divide: 10x ÷ 2x = 5",
            "2(x + 4) = 16 → x + 4 = 8 → x = 4",
            "Combine like terms: (3 + 2 - 1)x² = 4x²"
    };

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();

            if (choice == 1) {
                handleAlgebra(scanner);

            } else if (choice == 2) {
                System.out.println("You selected: Advanced Math");
                // TODO: Add Advanced Math problems

            } else if (choice == 3) {
                System.out.println("You selected: Problem-Solving and Data Analysis");
                // TODO: Add Problem-Solving problems

            } else if (choice == 4) {
                System.out.println("You selected: Geometry and Trigonometry");
                // TODO: Add Geometry problems

            } else if (choice == 5) {
                System.out.println("Goodbye!");
                running = false;

            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }

    // Display main menu
    private static void displayMenu() {
        System.out.println("=== Math Subject Chooser ===");
        System.out.println("1. Algebra");
        System.out.println("2. Advanced Math");
        System.out.println("3. Problem-Solving and Data Analysis");
        System.out.println("4. Geometry and Trigonometry");
        System.out.println("5. Quit");
        System.out.print("Choose a subject (1-5): ");
    }

    // Handle Algebra section
    private static void handleAlgebra(Scanner scanner) {
        System.out.println("=== Algebra Problems ===");

        int score = 0;
        int questionsAsked = 0;
        Random rand = new Random();

        // Loop for 5 questions
        while (questionsAsked < 5) {
            // Generate random index (0-19)
            int randomIndex = rand.nextInt(algebraQuestions.length);

            // Display random question
            System.out.println("Question " + (questionsAsked + 1) + " of 5:");
            System.out.println(algebraQuestions[randomIndex]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim();

            // Check if answer is correct and show result
            String correctAnswer = algebraAnswers[randomIndex].trim();
            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("✓ Correct! You earned 1 point.");
                score++;
            } else {
                System.out.println("✗ Incorrect. The correct answer is: " + correctAnswer);
            }
            System.out.println("Explanation: " + algebraExplanations[randomIndex]);

            questionsAsked++;

            // Ask if they want to continue (after each question except the last)
            if (questionsAsked < 5) {
                System.out.print("Continue to next question? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("no")) {
                    break;
                }
            }
            System.out.println();
        }

        // Show final score
        System.out.println("========== FINAL SCORE ==========");
        System.out.println("You answered " + score + " out of " + questionsAsked + " questions correctly!");
        System.out.println("=================================");
    }
}
