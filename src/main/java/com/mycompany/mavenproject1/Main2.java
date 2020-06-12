package com.mycompany.mavenproject1;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import quizLogic.QuizC11CSVmanager;
import quizLogic.QuizC11Entity;
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

        QuizC11CSVmanager quizC11manager = new QuizC11CSVmanager();
        ArrayList<QuizC11Entity> quizList = new ArrayList<>();

        try {
            quizList = (ArrayList<QuizC11Entity>) quizC11manager.readAllC11Quizzes("/home/francesco/NetBeansProjects/mavenproject1/src/main/java/storage/quiz_c11.csv");
            QuizC11Logic quizC11Logic = new QuizC11Logic(quizList, 10);

            quizC11Logic.answerTheQuestion(0, "VERO");
            quizC11Logic.answerTheQuestion(1, "FALSO");
            quizC11Logic.answerTheQuestion(2, "VERO");
            quizC11Logic.answerTheQuestion(3, "FALSO");
            quizC11Logic.answerTheQuestion(5, "VERO");
            quizC11Logic.answerTheQuestion(6, "FALSO");
            quizC11Logic.answerTheQuestion(8, "VERO");

            quizC11Logic.getResult();

        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
