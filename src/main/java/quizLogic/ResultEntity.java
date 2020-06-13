package quizLogic;

/**
 *
 * @author francesco
 */
public class ResultEntity {
    
    private int score = 0;
    private int correct = 0;
    private int wrong = 0;
    private int notAnswered = 0;

    public ResultEntity() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int pScore) {
        this.score = pScore;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int pCorrect) {
        this.correct = pCorrect;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int pWrong) {
        this.wrong = pWrong;
    }

    public int getNotAnswered() {
        return notAnswered;
    }

    public void setNotAnswered(int pNotAnswered) {
        this.notAnswered = pNotAnswered;
    }

    @Override
    public String toString() {
        return "ResultEntity{" + "score=" + score + ", correct=" + correct + ", wrong=" + wrong + ", notAnswered=" + notAnswered + '}';
    }
       
    
    
}
