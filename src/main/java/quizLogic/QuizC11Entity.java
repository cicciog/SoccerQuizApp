package quizLogic;

/**
 *
 * @author francesco
 */
public class QuizC11Entity {
    private String rule;
    private String question;
    private String answer;

    public QuizC11Entity() {
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String pRule) {
        this.rule = pRule;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String pQuestion) {
        this.question = pQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String pAnswer) {
        this.answer = pAnswer;
    }

    @Override
    public String toString() {
        return "QuizC11Entity{" + "rule=" + rule + ", question=" + question + ", answer=" + answer + '}';
    }
    
    
    
    
}
