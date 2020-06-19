package quizLogic;

/**
 *
 * @author cicciog
 */
public interface AbstractQuizLogic {

   public QuizEntity getCurrentQuestion();
   
   public QuizEntity getPreviousQuestion();
   
   public QuizEntity getNextQuestion();
   
   public void answerTheQuestion(int pQuestion, String pAnswer);
   
   public ResultEntity getResult();
}
