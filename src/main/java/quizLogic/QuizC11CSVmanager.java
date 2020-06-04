package quizLogic;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author francesco
 */
public class QuizC11CSVmanager {
    

    public Collection<QuizC11Entity> readAllC11Quizzes(String pSource) throws FileNotFoundException, IOException {
        // Create an object of file reader 
        File file = new File(pSource);
        // class with CSV file as a parameter. 
        FileReader filereader;
        ArrayList<QuizC11Entity> quizList;

        filereader = new FileReader(file);

        // create csvReader object and skip first Line 
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withSkipLines(1)
                .build();

        //read all data from csv
        List<String[]> allData = csvReader.readAll();
        //create an instance of quizList
        quizList = new ArrayList<>();

        // print Data 
        for (String[] row : allData) {

            QuizC11Entity quizc11 = new QuizC11Entity();
            quizc11.setRule(row[0]);
            quizc11.setQuestion(row[1]);
            quizc11.setAnswer(row[2]);

            //fill list
            quizList.add(quizc11);
        }

        return quizList;

    }
}
