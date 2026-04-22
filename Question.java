/**
 * Represents a single quiz question with answer and explanation.
 * Encapsulates question data with private fields and controlled access.
 */
public class Question {
    private String questionText;
    private String answer;
    private String explanation;

    /**
     * Constructs a Question with text, answer, and explanation.
     *
     * @param questionText the question prompt
     * @param answer       the correct answer
     * @param explanation  the explanation of the answer
     */
    public Question(String questionText, String answer, String explanation) {
        this.questionText = questionText;
        this.answer = answer;
        this.explanation = explanation;
    }

    // Getters with encapsulation
    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public String getExplanation() {
        return explanation;
    }

    /**
     * Normalizes answer for flexible comparison.
     * Removes spaces, handles exponents, currency, and case-insensitivity.
     *
     * @param answer the answer to normalize
     * @return normalized answer string
     */
    public static String normalizeAnswer(String answer) {
        if (answer == null)
            return "";

        answer = answer.replace(" ", "");
        answer = answer.replace("**", "^");
        answer = answer.replace("$", "");
        answer = answer.replace("£", "");
        answer = answer.replace("€", "");
        answer = answer.replace("¥", "");
        answer = answer.replace(",", "");
        answer = answer.toLowerCase();

        return answer.trim();
    }

    /**
     * Checks if the provided answer matches the correct answer.
     *
     * @param userAnswer the user's response
     * @return true if answer is correct, false otherwise
     */
    public boolean isCorrect(String userAnswer) {
        String normalized = normalizeAnswer(userAnswer);
        String correctNormalized = normalizeAnswer(this.answer);
        return normalized.equals(correctNormalized);
    }
}
