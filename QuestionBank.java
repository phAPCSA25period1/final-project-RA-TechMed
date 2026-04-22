/**
 * Manages all quiz question categories using a 2D array structure.
 * Each category (row) contains an array of Question objects.
 * Provides access to questions by category index.
 */
public class QuestionBank {
    // Category constants
    public static final int ALGEBRA = 0;
    public static final int ADVANCED_MATH = 1;
    public static final int PROBLEM_SOLVING = 2;
    public static final int GEOMETRY = 3;

    private static final String[] CATEGORY_NAMES = {
            "Algebra",
            "Advanced Math",
            "Problem-Solving and Data Analysis",
            "Geometry and Trigonometry"
    };

    // 2D array: [category][question index]
    private Question[][] questionBank;

    /**
     * Initializes the question bank with all categories.
     */
    public QuestionBank() {
        questionBank = new Question[4][];
        initializeAlgebra();
        initializeAdvancedMath();
        initializeProblemSolving();
        initializeGeometry();
    }

    // ========== ALGEBRA QUESTIONS ==========
    private void initializeAlgebra() {
        Question[] algebra = new Question[20];

        algebra[0] = new Question(
                "The total cost, in dollars, to make 10,000 units of a pen is given by f(x)=40,000+10,000x. What is the total cost when the per unit cost is $1.20?",
                "$52,000",
                "f(1.20)=40,000+10,000×1.20 → f(1.20)=40,000+12,000 → f(1.20)=$52,000");

        algebra[1] = new Question(
                "Iris bought chewing gum and donuts for $90. Each packet costs $4, each donut costs $2. If she bought 15 packets of gum, how many donuts did she buy?",
                "15",
                "4×15 + 2×d = 90 → 60 + 2d = 90 → 2d = 30 → d = 15");

        algebra[2] = new Question(
                "Kevin runs at 9.30 minutes per mile. Which function models miles Kevin runs in x minutes? A) x/9.30 B) 9.30+x C) 9.30/x D) 9.30x",
                "A",
                "To cover 1 mile takes 9.30 minutes. So in x minutes, he covers x/9.30 miles.");

        algebra[3] = new Question(
                "The function f(x) = x/20 + 20. What is the y-intercept of y = f(x)? A) (20,0) B) (0,20) C) (0,0) D) (20,20)",
                "B",
                "The y-intercept occurs when x=0. f(0)=0/20+20=20. So the point is (0,20).");

        algebra[4] = new Question(
                "7 more than 10 times a number x equals 104. Which equation represents this? A) 10x+7=104 B) 7x+10=104 C) 10x-7=104",
                "A",
                "10 times x is 10x. 7 more than that is 10x+7. So: 10x+7=104");

        algebra[5] = new Question("Simplify: 7x - 3x + 5", "4x + 5", "Combine like terms: (7-3)x + 5 = 4x + 5");

        algebra[6] = new Question("Solve for x: 2x - 8 = 4", "x = 6", "2x - 8 = 4 → 2x = 12 → x = 6");

        algebra[7] = new Question("Simplify: 5x/5 + 2", "x + 2", "5x/5 = x. So x + 2");

        algebra[8] = new Question("Solve for x: x/3 = 4", "x = 12", "x/3 = 4 → x = 4 × 3 → x = 12");

        algebra[9] = new Question("Simplify: (x + 2)(x - 2)", "x² - 4", "Difference of squares: (a+b)(a-b) = a² - b²");

        algebra[10] = new Question("Solve for x: 3x + 6 = 18", "x = 4", "3x + 6 = 18 → 3x = 12 → x = 4");

        algebra[11] = new Question("Simplify: 8x - 2x + 3x", "9x", "Combine like terms: (8-2+3)x = 9x");

        algebra[12] = new Question("Solve for x: 4x - 12 = 0", "x = 3", "4x - 12 = 0 → 4x = 12 → x = 3");

        algebra[13] = new Question("Simplify: 2x + x² - x", "x² + x", "Combine like terms: x² + (2-1)x = x² + x");

        algebra[14] = new Question("Solve for x: 6 + 2x = 16", "x = 5", "6 + 2x = 16 → 2x = 10 → x = 5");

        algebra[15] = new Question("Simplify: (2x)³", "8x³", "Power rule: (2x)³ = 2³ × x³ = 8x³");

        algebra[16] = new Question("Solve for x: x + 5 = 12", "x = 7", "x + 5 = 12 → x = 7");

        algebra[17] = new Question("Simplify: 10x ÷ 2x", "5", "10x ÷ 2x = 5");

        algebra[18] = new Question("Solve for x: 2(x + 4) = 16", "x = 4", "2(x+4) = 16 → x+4 = 8 → x = 4");

        algebra[19] = new Question("Simplify: 3x² + 2x² - x²", "4x²", "Combine like terms: (3+2-1)x² = 4x²");

        questionBank[ALGEBRA] = algebra;
    }

    // ========== ADVANCED MATH QUESTIONS ==========
    private void initializeAdvancedMath() {
        Question[] advanced = new Question[10];

        advanced[0] = new Question(
                "Solve: x² + 5x + 6 = 0",
                "x = -2 or x = -3",
                "Factor: (x+2)(x+3)=0 → x=-2 or x=-3");

        advanced[1] = new Question(
                "What is the vertex of y = (x-3)² + 2?",
                "(3, 2)",
                "Vertex form is y = a(x-h)² + k. The vertex is (h, k) = (3, 2)");

        advanced[2] = new Question(
                "Simplify: √(16x⁴)",
                "4x²",
                "√(16x⁴) = √16 × √(x⁴) = 4 × x² = 4x²");

        advanced[3] = new Question(
                "Solve: 2^(x+1) = 8",
                "x = 2",
                "2^(x+1) = 8 → 2^(x+1) = 2³ → x+1 = 3 → x = 2");

        advanced[4] = new Question(
                "What is log₂(32)?",
                "5",
                "2⁵ = 32, so log₂(32) = 5");

        advanced[5] = new Question(
                "Simplify: (3x²y³)²",
                "9x⁴y⁶",
                "(3x²y³)² = 3² × (x²)² × (y³)² = 9x⁴y⁶");

        advanced[6] = new Question(
                "What is the range of f(x) = -x² + 4?",
                "(-∞, 4]",
                "Parabola opens downward with vertex at (0,4). Maximum is 4, goes to -∞.");

        advanced[7] = new Question(
                "Solve: |x - 3| = 5",
                "x = 8 or x = -2",
                "|x-3| = 5 → x-3 = 5 or x-3 = -5 → x = 8 or x = -2");

        advanced[8] = new Question(
                "Simplify: (x³ + 2x) / x",
                "x² + 2",
                "(x³ + 2x) / x = x³/x + 2x/x = x² + 2");

        advanced[9] = new Question(
                "What is the discriminant of x² + 4x + 4?",
                "0",
                "b² - 4ac = 4² - 4(1)(4) = 16 - 16 = 0");

        questionBank[ADVANCED_MATH] = advanced;
    }

    // ========== PROBLEM-SOLVING & DATA ANALYSIS ==========
    private void initializeProblemSolving() {
        Question[] problemSolving = new Question[10];

        problemSolving[0] = new Question(
                "A store sells items at $12 each. If they sell 50 items, what is the total revenue?",
                "$600",
                "Total = Price × Quantity = $12 × 50 = $600");

        problemSolving[1] = new Question(
                "The average of 5 numbers is 20. What is their sum?",
                "100",
                "Average = Sum / Count → 20 = Sum / 5 → Sum = 100");

        problemSolving[2] = new Question(
                "If a recipe serves 4 people and uses 2 cups of flour, how much flour is needed to serve 10 people?",
                "5 cups",
                "Scale factor = 10/4 = 2.5. Flour needed = 2 × 2.5 = 5 cups");

        problemSolving[3] = new Question(
                "What percentage is 15 out of 60?",
                "25%",
                "Percentage = (15/60) × 100 = 0.25 × 100 = 25%");

        problemSolving[4] = new Question(
                "If 3 workers complete a job in 8 hours, how long would 4 workers take?",
                "6 hours",
                "Total work = 3 × 8 = 24 worker-hours. With 4 workers: 24/4 = 6 hours");

        problemSolving[5] = new Question(
                "A car travels 150 miles in 3 hours. What is its average speed?",
                "50 mph",
                "Speed = Distance / Time = 150 / 3 = 50 mph");

        problemSolving[6] = new Question(
                "If a population grows from 1000 to 1200, what is the percent increase?",
                "20%",
                "Increase = 1200 - 1000 = 200. Percent = (200/1000) × 100 = 20%");

        problemSolving[7] = new Question(
                "What is the median of: 3, 7, 5, 9, 1?",
                "5",
                "Sort: 1, 3, 5, 7, 9. The middle value is 5.");

        problemSolving[8] = new Question(
                "If a store discounts an item by 25% from $40, what is the new price?",
                "$30",
                "Discount = $40 × 0.25 = $10. New price = $40 - $10 = $30");

        problemSolving[9] = new Question(
                "What is the mode of: 2, 3, 3, 5, 3, 7?",
                "3",
                "The mode is the most frequently occurring value. 3 appears 3 times.");

        questionBank[PROBLEM_SOLVING] = problemSolving;
    }

    // ========== GEOMETRY & TRIGONOMETRY QUESTIONS ==========
    private void initializeGeometry() {
        Question[] geometry = new Question[10];

        geometry[0] = new Question(
                "What is the area of a rectangle with length 8 and width 5?",
                "40",
                "Area = length × width = 8 × 5 = 40 square units");

        geometry[1] = new Question(
                "What is the circumference of a circle with radius 3?",
                "6π",
                "Circumference = 2πr = 2π(3) = 6π");

        geometry[2] = new Question(
                "Find the area of a triangle with base 10 and height 6.",
                "30",
                "Area = (1/2) × base × height = (1/2) × 10 × 6 = 30 square units");

        geometry[3] = new Question(
                "What is the Pythagorean theorem?",
                "a² + b² = c²",
                "For a right triangle: a² + b² = c², where c is the hypotenuse");

        geometry[4] = new Question(
                "If a right triangle has legs of 3 and 4, what is the hypotenuse?",
                "5",
                "c² = 3² + 4² = 9 + 16 = 25 → c = 5");

        geometry[5] = new Question(
                "What is sin(90°)?",
                "1",
                "sin(90°) = 1 by definition of the sine function");

        geometry[6] = new Question(
                "What is the volume of a cube with side length 4?",
                "64",
                "Volume = side³ = 4³ = 64 cubic units");

        geometry[7] = new Question(
                "What is cos(0°)?",
                "1",
                "cos(0°) = 1 by definition of the cosine function");

        geometry[8] = new Question(
                "What is the sum of angles in a triangle?",
                "180°",
                "The sum of interior angles in any triangle is always 180°");

        geometry[9] = new Question(
                "What is the area of a circle with radius 5?",
                "25π",
                "Area = πr² = π(5)² = 25π square units");

        questionBank[GEOMETRY] = geometry;
    }

    /**
     * Gets a question from a specific category.
     *
     * @param category the category index (ALGEBRA, ADVANCED_MATH, etc.)
     * @param index    the question index within the category
     * @return the Question object
     */
    public Question getQuestion(int category, int index) {
        if (category < 0 || category >= questionBank.length) {
            throw new IllegalArgumentException("Invalid category: " + category);
        }
        if (index < 0 || index >= questionBank[category].length) {
            throw new IllegalArgumentException("Invalid question index: " + index);
        }
        return questionBank[category][index];
    }

    /**
     * Gets the category name.
     *
     * @param category the category index
     * @return the category name
     */
    public String getCategoryName(int category) {
        if (category < 0 || category >= CATEGORY_NAMES.length) {
            throw new IllegalArgumentException("Invalid category: " + category);
        }
        return CATEGORY_NAMES[category];
    }

    /**
     * Gets the number of questions in a category.
     *
     * @param category the category index
     * @return the count of questions
     */
    public int getCategorySize(int category) {
        if (category < 0 || category >= questionBank.length) {
            throw new IllegalArgumentException("Invalid category: " + category);
        }
        return questionBank[category].length;
    }

    /**
     * Gets the total number of categories.
     *
     * @return the number of categories (4)
     */
    public int getNumCategories() {
        return questionBank.length;
    }
}
