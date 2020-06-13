package com.mycompany.mavenproject1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import quizLogic.QuizCSVmanager;
import quizLogic.QuizEntity;
import quizLogic.QuizC11Logic;

/**
 *
 * @author francesco
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        QuizCSVmanager quizC11manager = new QuizCSVmanager();
        ArrayList<QuizEntity> quizList = new ArrayList<>();
        QuizC11Logic quizC11Logic = null;
        QuizEntity currentQuiz = null;

        try {
            quizList = (ArrayList<QuizEntity>) quizC11manager.readAllC11Quizzes("/home/francesco/NetBeansProjects/mavenproject1/src/main/java/storage/quiz_c11.csv");
            quizC11Logic = new QuizC11Logic(quizList, 10);
        } catch (NullPointerException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("Benvenuto nell'applicazione per arbitri di calcio!");
        for (int i = 0; i < 10; i++) {
            // Declare the object and initialize with 
            // predefined standard input object 
            
            currentQuiz = quizC11Logic.getCurrentQuestion();
            
            
            System.out.println(currentQuiz.getQuestion());
            Scanner sc = new Scanner(System.in);

            // String input 
            String answer = sc.nextLine().toUpperCase();
            quizC11Logic.answerTheQuestion(i, answer);
            //System.out.println(quizC11Logic.getCurrentQuestion().getAnswer());
            if(i+1 < 10){
                quizC11Logic.getNextQuestion();
            }
            
        }
        
        System.out.println("Score: "+quizC11Logic.getResult().getScore());
        System.out.println("Risposte corrette: "+quizC11Logic.getResult().getCorrect());
        System.out.println("Risposte errate: "+quizC11Logic.getResult().getWrong());
        System.out.println("Risposte non inserite: "+quizC11Logic.getResult().getNotAnswered());

    }

}
