package quizLogic;

import java.util.ArrayList;

/**
 *
 * @author francesco
 */
public class QuizC5Logic implements AbstractQuizLogic {

    private ArrayList<QuizEntity> QuizList;
    private int numberOfQuestion;
    private int currentQuestion = 0;
    
    
    public QuizC5Logic(ArrayList<QuizEntity> pFullC11QuizList, int pNumberOfQuestion) throws NullPointerException, IndexOutOfBoundsException {
        //check if the quiz list is null
        if (pFullC11QuizList == null) {
            throw new NullPointerException("Lista di quiz vuota");
        }
        
        //check if the quiz list is empty
        if (pFullC11QuizList.isEmpty()) {
            throw new IndexOutOfBoundsException("Lista dei quiz vuota");
        }

        this.numberOfQuestion = pNumberOfQuestion;
        QuizList = new ArrayList<>();
        
        //calculate slot for question range
        int slot = (pFullC11QuizList.size() / this.numberOfQuestion);
        
        //generate quiz
        for (int i = 0; i < numberOfQuestion; i++) {
            int question = (int) (Math.random() * ((slot * (i+1)) - (slot * i) + 1)) + (slot * i);
            QuizList.add(pFullC11QuizList.get(question));
        }
        
    }

    @Override
    public QuizEntity getCurrentQuestion() {
        //show current question of the quiz session
        return QuizList.get(currentQuestion);
    }

    @Override
    public QuizEntity getPreviousQuestion() {
        //check if the previous question is in the correct range
        if (currentQuestion >= 0) {
            currentQuestion = currentQuestion - 1;
        } else {
            throw new IllegalArgumentException("Non è possibile recuperare il quiz precedente");
        }

        return QuizList.get(currentQuestion);
    }

    @Override
    public QuizEntity getNextQuestion() {
        //check if the previous question is in the correct range
        if (currentQuestion < numberOfQuestion) {
            currentQuestion = currentQuestion + 1;
            return QuizList.get(currentQuestion);
        } else {
            throw new IllegalArgumentException("Non è possibile recuperare il quiz successivo");
        }
    }

    @Override
    public void answerTheQuestion(int pQuestion, String pAnswer) {
        //anser a question
        QuizList.get(pQuestion).setUserAnswer(pAnswer);
    }

    @Override
    public ResultEntity getResult() {
        int wrong = 0;
        int correct = 0;
        int notAnswerd = 0;
        ResultEntity result;

        //compute the correct, wrong and notAnswered question
        for (int i = 0; i < numberOfQuestion; i++) {
            if (QuizList.get(i).getUserAnswer() == null || QuizList.get(i).getUserAnswer().length() == 0) {
                notAnswerd = notAnswerd + 1;
            } else if (QuizList.get(i).getUserAnswer().equals(QuizList.get(i).getAnswer())) {
                correct = correct + 1;
            } else {
                wrong = wrong + 1;
            }
        }

        //calculate the score of the quiz
        int score = correct * 3 - wrong * 2 + notAnswerd;

        result = new ResultEntity();
        result.setCorrect(correct);
        result.setWrong(wrong);
        result.setNotAnswered(notAnswerd);
        result.setScore(score);

        return result;

    }

}
