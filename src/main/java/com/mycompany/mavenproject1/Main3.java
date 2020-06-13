package com.mycompany.mavenproject1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import quizLogic.QuizC5Logic;
import quizLogic.QuizCSVmanager;
import quizLogic.QuizEntity;

/**
 *
 * @author francesco
 */
public class Main3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        QuizCSVmanager quizC5manager = new QuizCSVmanager();
        ArrayList<QuizEntity> quizList = new ArrayList<>();
        QuizC5Logic quizC5Logic = null;
        QuizEntity currentQuiz = null;

        try {
            quizList = (ArrayList<QuizEntity>) quizC5manager.readAllC5Quizzes("/home/francesco/NetBeansProjects/mavenproject1/src/main/java/storage/quiz_c5.csv");
            quizC5Logic = new QuizC5Logic(quizList, 10);
        } catch (NullPointerException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("Benvenuto nell'applicazione per arbitri di calcio!");
        for (int i = 0; i < 10; i++) {
            // Declare the object and initialize with 
            // predefined standard input object 
            
            currentQuiz = quizC5Logic.getCurrentQuestion();
            
            
            System.out.println(currentQuiz.getQuestion());
            Scanner sc = new Scanner(System.in);

            // String input 
            String answer = sc.nextLine().toUpperCase();
            quizC5Logic.answerTheQuestion(i, answer);
            //System.out.println(quizC11Logic.getCurrentQuestion().getAnswer());
            if(i+1 < 10){
                quizC5Logic.getNextQuestion();
            }
            
        }
        
        System.out.println("Score: "+quizC5Logic.getResult().getScore());
        System.out.println("Risposte corrette: "+quizC5Logic.getResult().getCorrect());
        System.out.println("Risposte errate: "+quizC5Logic.getResult().getWrong());
        System.out.println("Risposte non inserite: "+quizC5Logic.getResult().getNotAnswered());

    }
    
}
