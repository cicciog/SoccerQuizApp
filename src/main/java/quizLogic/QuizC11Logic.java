/*
MIT License

Copyright (c) 2020 cicciog

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE. 
*/
package quizLogic;

import executable.SoccerQuizApp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author cicciog
 */
public class QuizC11Logic implements AbstractQuizLogic{

    private ArrayList<QuizEntity> quizList;
    private int numberOfQuestion;
    private int currentQuestion = 0;
    private ArrayList<QuizEntity> fullC11QuizList;
    private QuizCSVmanager quizCSVmanager;
    
    
    public QuizC11Logic(int pNumberOfQuestion){
        this.numberOfQuestion = pNumberOfQuestion;
        this.quizList = new ArrayList<>();
                
    }
    
    public Collection<QuizEntity> readAllQuizzes(String pSource) throws IOException{
        this.quizCSVmanager = new QuizCSVmanager();
        this.fullC11QuizList = (ArrayList<QuizEntity>) quizCSVmanager.readAllC11Quizzes(pSource);
        return fullC11QuizList;
    }
    
    public Collection<QuizEntity> generateQuiz() throws IOException{
        
        //check if the quiz list is null
        if(this.fullC11QuizList == null){
            this.fullC11QuizList = new ArrayList<>();
        }
        
        //check if the quiz list is empty
        if(this.fullC11QuizList.isEmpty()){
            this.fullC11QuizList = (ArrayList<QuizEntity>) readAllQuizzes("./src/main/java/resources/quiz_c11.csv");
        }   
        
        //calculate slot for question range
        int slot = (this.fullC11QuizList.size() / this.numberOfQuestion);
        
        //generate quiz
        for (int i = 0; i < this.numberOfQuestion; i++) {
            int question = (int) (Math.random() * ((slot * (i+1)) - (slot * i) + 1)) + (slot * i);
            this.quizList.add(fullC11QuizList.get(question));
            System.out.println(fullC11QuizList.get(question));
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
