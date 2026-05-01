import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlgebraQuiz {
    private String[][] quizData;
    private int score;
    private int questionsAsked;

    public AlgebraQuiz() {
        this.score = 0;
        this.questionsAsked = 0;
        initializeQuestions();
    }

    private void initializeQuestions() {
        quizData = new String[20][3];

        quizData[0][0] = "43x + 17y = 103\n17x + 43y = 77\nWhat is the value of x + y?";
        quizData[0][1] = "3";
        quizData[0][2] = "Add both equations: 60x + 60y = 180 → 60(x+y) = 180 → x+y = 3";

        quizData[1][0] = "The total cost to make 10,000 units of a premium pen is f(x) = 40,000 + 10,000x, where x is the per unit cost. What is the total cost when per unit cost is $1.20?";
        quizData[1][1] = "52000";
        quizData[1][2] = "f(1.20) = 40,000 + 10,000×1.20 = 40,000 + 12,000 = $52,000";

        quizData[2][0] = "5x² - 40x + d = 0 has no real solutions. Which CANNOT be a value of d?\nA) 80  B) 82  C) 100  D) 300";
        quizData[2][1] = "a";
        quizData[2][2] = "No real solutions requires discriminant < 0: (-40)²-4(5)(d) < 0 → 1600 < 20d → d > 80. So d=80 gives discriminant=0 (one real solution), meaning 80 CANNOT satisfy 'no real solutions'.";

        quizData[3][0] = "Machine A packs x boxes/hr, machine B packs y boxes/hr. A packs 200 boxes, B packs 300 boxes, together working 30 hours. Which equation fits?\nA) 200x + 300y = 30\nB) (1/200)x + (1/300)y = 30\nC) 30x + 30y = 500\nD) 200/x + 300/y = 30";
        quizData[3][1] = "d";
        quizData[3][2] = "Time = boxes ÷ rate. A takes 200/x hrs, B takes 300/y hrs. Total: 200/x + 300/y = 30.";

        quizData[4][0] = "y > 33\n4x + y < 37\nWhich could be the value of x?\nA) 3  B) 2  C) 1  D) 0";
        quizData[4][1] = "d";
        quizData[4][2] = "Since y > 33, plug into second inequality: 4x < 37 - y < 37 - 33 = 4 → x < 1. Only x=0 works.";

        quizData[5][0] = "Imran bought gum packets and donuts for $90. Gum costs $4/packet, donuts cost $2 each. He bought 15 gum packets. How many donuts did he buy?";
        quizData[5][1] = "15";
        quizData[5][2] = "4×15 + 2d = 90 → 60 + 2d = 90 → 2d = 30 → d = 15";

        quizData[6][0] = "46 pencils and 38 pens cost $164. Price ratio pencil:pen = 3:5. What is the price of 4 pencils and 5 pens?\nA) $0.50  B) $4.00  C) $18.50  D) Cannot be determined";
        quizData[6][1] = "c";
        quizData[6][2] = "Let pencil=3k, pen=5k. 46(3k)+38(5k)=164 → 328k=164 → k=0.5. 4 pencils+5 pens = 4(1.50)+5(2.50) = 6+12.50 = $18.50";

        quizData[7][0] = "Kevin runs at 9.30 minutes per mile. Which function models miles run in x minutes?\nA) f(x) = x/9.30  B) f(x) = 9.30 + x  C) f(x) = 9.30/x  D) f(x) = 9.30x";
        quizData[7][1] = "a";
        quizData[7][2] = "1 mile takes 9.30 min. In x minutes: miles = x/9.30.";

        quizData[8][0] = "s = 70 - 4t gives truck speed (mph) at t seconds after decelerating. What is the speed at t=4?\nA) 86  B) 70  C) 54  D) 16";
        quizData[8][1] = "c";
        quizData[8][2] = "s = 70 - 4(4) = 70 - 16 = 54 mph";

        quizData[9][0] = "A baker pays a $50 venue fee plus $1.50 per visitor in samples. Budget is $150. What is the greatest number of visitors possible?";
        quizData[9][1] = "66";
        quizData[9][2] = "50 + 1.50v ≤ 150 → 1.50v ≤ 100 → v ≤ 66.67 → greatest whole number is 66";

        quizData[10][0] = "A 100-point test has questions worth 1, 2, and 3 points (x, y, z questions respectively). Which equation fits?\nA) 6xyz = 100  B) 6(x+y+z) = 100  C) x + y/2 + z/3 = 100  D) x + 2y + 3z = 100";
        quizData[10][1] = "d";
        quizData[10][2] = "Total points: 1·x + 2·y + 3·z = 100.";

        quizData[11][0] = "A man buys 100 items (pens and notebooks). The equation x/2 + y/3 = 100 models it, where x=money on pens, y=money on notebooks. Which is true?\nA) Price of a pen is $3\nB) Price of a notebook is $3\nC) Number of pens is 3\nD) Number of notebooks is 3";
        quizData[11][1] = "b";
        quizData[11][2] = "x/2 = number of pens → pen costs $2. y/3 = number of notebooks → notebook costs $3.";

        quizData[12][0] = "A square pond (side 10m) and circular pond (radius 7m) hold 20,453 fish total. Equation: 100x + 154y = 20,453. What is the best interpretation of y?\nA) Avg fish/m² in square pond\nB) Avg fish/m² in circular pond\nC) Total fish in square pond\nD) Total fish in circular pond";
        quizData[12][1] = "b";
        quizData[12][2] = "Square area=100m², circle area=154m². So x=avg fish/m² in square pond, y=avg fish/m² in circular pond.";

        quizData[13][0] = "f(x) = x/20 + 20. What is the y-intercept?\nA) (20, 0)  B) (0, 20)  C) (0, 0)  D) (20, 20)";
        quizData[13][1] = "b";
        quizData[13][2] = "Set x=0: f(0) = 0/20 + 20 = 20. Y-intercept is (0, 20).";

        quizData[14][0] = "If |32 - 4x²| = 112, what is the negative value of x?";
        quizData[14][1] = "-6";
        quizData[14][2] = "Case 1: 32-4x²=112 → x²=-20 (no real solution). Case 2: 32-4x²=-112 → x²=36 → x=±6. Negative value: -6.";

        quizData[15][0] = "Which is equivalent to (1/x²)^(-9/8) where x > 0?\nA) ⁹√(x⁴)  B) ⁴√(x⁹)  C) ⁴√(x⁻⁹)  D) ⁹√(x⁻⁴)";
        quizData[15][1] = "b";
        quizData[15][2] = "(x^-2)^(-9/8) = x^(18/8) = x^(9/4) = ⁴√(x⁹)";

        quizData[16][0] = "A factory's average cost per pen is f(s) = 3 + 7s dollars. Each pen sells at $p. Which inequality means profit?\nA) 3 + 7s > p  B) 3 + 7s² > ps  C) 3 + 7s² > p  D) 3 + 7s < p";
        quizData[16][1] = "d";
        quizData[16][2] = "Profit means selling price exceeds cost: p > 3 + 7s → 3 + 7s < p.";

        quizData[17][0] = "7 more than 10 times a number x equals 104. Which equation fits?\nA) (7)(10)x = 104  B) 10x = 104 + 7  C) 7x + 10 = 104  D) 10x + 7 = 104";
        quizData[17][1] = "d";
        quizData[17][2] = "10 times x = 10x. 7 more = 10x + 7 = 104.";

        quizData[18][0] = "Jack's bank balance after n yearly deposits is f(n) = 300 + 50n. What is the best interpretation of 50?\nA) Each deposit increases balance by $50\nB) Initial balance before any deposits was $50\nC) Balance after one deposit was $50\nD) Jack made 50 total deposits";
        quizData[18][1] = "a";
        quizData[18][2] = "The slope 50 represents the rate of change: each additional deposit adds $50 to the balance.";

        quizData[19][0] = "A linear function f has: f(0)=37, f(1)=39, f(2)=41. Which equation defines f(x)?\nA) f(x) = 2x + 37  B) f(x) = 37x + 39  C) f(x) = 41x + 37  D) f(x) = 39x + 41";
        quizData[19][1] = "a";
        quizData[19][2] = "Slope = (39-37)/(1-0) = 2. Y-intercept = f(0) = 37. So f(x) = 2x + 37.";
    }

    public void runQuiz(Scanner scanner) {
        System.out.println("\n=== Algebra ===\n");
        score = 0;
        questionsAsked = 0;

        int maxQuestions = 5;

        // Shuffle indices so no repeats
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < quizData.length; i++) indices.add(i);
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
                System.out.println("✗ Incorrect. The correct answer is: " + quizData[idx][1].toUpperCase());
            }

            System.out.println("Explanation: " + quizData[idx][2]);
            questionsAsked++;

            if (questionsAsked < maxQuestions) {
                System.out.print("\nContinue to next question? (yes/no): ");
                System.out.flush();
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("no")) break;
                System.out.println();
            }
        }

        displayScore();
    }

    private boolean isCorrect(String userAnswer, String correctAnswer) {
        return normalizeAnswer(userAnswer).equals(normalizeAnswer(correctAnswer));
    }

    private String normalizeAnswer(String answer) {
        if (answer == null) return "";
        return answer
            .replaceAll("[\\s,.$€£¥]", "")  // strip whitespace, commas, currency symbols
            .replace("−", "-")               // Unicode minus → ASCII minus
            .replaceAll("(?i)^([a-d])\\).*", "$1")  // "A) some text" → "a"
            .toLowerCase()
            .trim();
    }

    private void displayScore() {
        System.out.println("\n========== FINAL SCORE ==========");
        System.out.println("You answered " + score + " out of " + questionsAsked + " correctly!");
        if (questionsAsked > 0) {
            System.out.printf("Percentage: %.1f%%\n", (score * 100.0) / questionsAsked);
        }
        System.out.println("=================================\n");
    }

    public int getScore() { return score; }
    public int getTotalQuestions() { return quizData.length; }
}
