package quizLogic;

import java.util.ArrayList;

/**
 *
 * @author francesco
 */
public class QuizC11Logic {

    private ArrayList<QuizC11Entity> QuizList;
    private int numberOfQuestion;
    private int currentQuestion = 0;

    public QuizC11Logic(ArrayList<QuizC11Entity> pFullC11QuizList, int pNumberOfQuestion) throws NullPointerException, IndexOutOfBoundsException {
        if (pFullC11QuizList == null) {
            throw new NullPointerException("Lista di quiz vuota");
        }

        if (pFullC11QuizList.isEmpty()) {
            throw new IndexOutOfBoundsException("Lista dei quiz vuota");
        }

        this.numberOfQuestion = pNumberOfQuestion;
        QuizList = new ArrayList<>();

        int slot = (pFullC11QuizList.size() / this.numberOfQuestion);
        System.out.println("slot: "+slot);
        
        for (int i = 0; i < numberOfQuestion; i++) {
            int question = (int) (Math.random() * ((slot * (i+1)) - (slot * i) + 1)) + (slot * i);
            System.out.println("question"+i+": "+question);
            QuizList.add(pFullC11QuizList.get(question));
        }
        

        for (QuizC11Entity quiz : QuizList) {
            System.out.println(quiz.toString());
        }
    }

    public QuizC11Entity getCurrentQuestion() {
        return QuizList.get(currentQuestion);
    }

    public QuizC11Entity getPreviousQuestion() throws IllegalArgumentException{
        if(currentQuestion < numberOfQuestion && currentQuestion > 0){
            currentQuestion = currentQuestion - 1;
        }else{
            throw new IllegalArgumentException("Non è possibile recuperare il quiz precedente");
        }
        
        return QuizList.get(currentQuestion);
    }

    public QuizC11Entity getNextQuestion() {
         if(currentQuestion < numberOfQuestion && currentQuestion >= 0){
            currentQuestion = currentQuestion + 1;
        }else{
            throw new IllegalArgumentException("Non è possibile recuperare il quiz precedente");
        }
        
        return QuizList.get(currentQuestion);
    }

    public void answerTheQuestion(int pQuestion, String pAnswer) {
        System.err.println("Answer the question n."+pQuestion);
        System.out.println(QuizList.get(pQuestion));
        QuizList.get(pQuestion).setUserAnswer(pAnswer);
        System.out.println(QuizList.get(pQuestion));
    }

    public void getResult() {
        int wrong = 0;
        int correct = 0;
        int notAnswerd = 0;
        
        for(int i = 0; i < numberOfQuestion; i++){
            if(QuizList.get(i).getUserAnswer() == null){
                notAnswerd = notAnswerd + 1;
            }else if(QuizList.get(i).getUserAnswer().equals(QuizList.get(i).getAnswer())){
                correct = correct + 1;
            }else{
                wrong = wrong + 1;
            }
        }
        
        int score = correct*3-wrong*2+notAnswerd;
        System.out.println(score);
        
        System.out.println("Quiz score: "+score+" correct: "+correct+" wrong: "+wrong+" not answerd: "+notAnswerd);

    }

}
