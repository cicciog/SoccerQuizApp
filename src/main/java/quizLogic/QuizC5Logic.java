package quizLogic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author francesco
 */
public class QuizC5Logic implements AbstractQuizLogic{

    private ArrayList<QuizEntity> quizList;
    private int numberOfQuestion;
    private int currentQuestion = 0;
    private ArrayList<QuizEntity> fullC5QuizList;
    private QuizCSVmanager quizCSVmanager;
    
    
    public QuizC5Logic(int pNumberOfQuestion){
        this.numberOfQuestion = pNumberOfQuestion;
        this.quizList = new ArrayList<>();
                
    }
    
    public Collection<QuizEntity> readAllQuizzes(String pSource) throws IOException{
        this.quizCSVmanager = new QuizCSVmanager();
        this.fullC5QuizList = (ArrayList<QuizEntity>) quizCSVmanager.readAllC5Quizzes(pSource);
        return fullC5QuizList;
    }
    
    public Collection<QuizEntity> generateQuiz() throws IOException{
        
        //check if the quiz list is null
        if(this.fullC5QuizList == null){
            this.fullC5QuizList = new ArrayList<>();
        }
        
        //check if the quiz list is empty
        if(this.fullC5QuizList.isEmpty()){
            this.fullC5QuizList = (ArrayList<QuizEntity>) readAllQuizzes("/home/francesco/NetBeansProjects/mavenproject1/src/main/java/storage/quiz_c5.csv");
        }
        
        //calculate slot for question range
        int slot = (this.fullC5QuizList.size() / this.numberOfQuestion);
        
        //generate quiz
        for (int i = 0; i < this.numberOfQuestion; i++) {
            int question = (int) (Math.random() * ((slot * (i+1)) - (slot * i) + 1)) + (slot * i);
            this.quizList.add(fullC5QuizList.get(question));
            System.out.println(fullC5QuizList.get(question));
        }
        
        return this.quizList;
    }

    @Override
    public QuizEntity getCurrentQuestion() {
        //show current question of the quiz session
        return quizList.get(currentQuestion);
    }

    @Override
    public QuizEntity getPreviousQuestion() throws IllegalArgumentException{
        //check if the previous question is in the correct range
        if(currentQuestion >= 0){
            currentQuestion = currentQuestion - 1;
        }else{
            throw new IllegalArgumentException("Non è possibile recuperare il quiz precedente");
        }
        
        return quizList.get(currentQuestion);
    }

    @Override
    public QuizEntity getNextQuestion() {
        //check if the previous question is in the correct range
         if(currentQuestion < numberOfQuestion){
            currentQuestion = currentQuestion + 1;
            return quizList.get(currentQuestion);
        }else{
            throw new IllegalArgumentException("Non è possibile recuperare il quiz successivo");
        }
    }

    @Override
    public void answerTheQuestion(int pQuestion, String pAnswer) {
        //anser a question
        quizList.get(pQuestion).setUserAnswer(pAnswer);
    }

    @Override
    public ResultEntity getResult() {
        int wrong = 0;
        int correct = 0;
        int notAnswerd = 0;
        ResultEntity result;
        
        //compute the correct, wrong and notAnswered question
        for(int i = 0; i < numberOfQuestion; i++){
            System.out.println(quizList.get(i));
            if(quizList.get(i).getUserAnswer() == null||quizList.get(i).getUserAnswer().length() == 0){
                notAnswerd = notAnswerd + 1;
            }else if(quizList.get(i).getUserAnswer().equals(quizList.get(i).getAnswer())){
                correct = correct + 1;
            }else{
                wrong = wrong + 1;
            }
        }
        
        //calculate the score of the quiz
        int score = correct*3-wrong*2+notAnswerd;
        
        result = new ResultEntity();
        result.setCorrect(correct);
        result.setWrong(wrong);
        result.setNotAnswered(notAnswerd);
        result.setScore(score);
        
        return result;

    }
    
    public void cleanQuizList(){
        this.quizList.clear();
    }
    
    public int getQuizListSize(){
        return this.quizList.size();
    }
    
}
