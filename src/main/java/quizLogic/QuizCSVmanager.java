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
 * @author cicciog
 */
public class QuizCSVmanager {
    

    public Collection<QuizEntity> readAllC11Quizzes(String pSource) throws FileNotFoundException, IOException {
        // Create an object of file reader 
        File file = new File(pSource);
        // class with CSV file as a parameter. 
        FileReader filereader;
        ArrayList<QuizEntity> quizList;

        filereader = new FileReader(file);

        // create csvReader object and skip first Line 
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withSkipLines(1)
                .build();

        //read all data from csv
        List<String[]> allData = csvReader.readAll();
        //close file reader
        csvReader.close(); 
        
        //create an instance of quizList
        quizList = new ArrayList<>();

        // print Data 
        for (String[] row : allData) {

            QuizEntity quizc11 = new QuizEntity();
            quizc11.setRule(row[0]);
            quizc11.setQuestion(row[1]);
            quizc11.setAnswer(row[2]);
            
            //fill list
            quizList.add(quizc11);
        }

        return quizList;
    }
    
    public Collection<QuizEntity> readAllC5Quizzes(String pSource) throws FileNotFoundException, IOException {
        // Create an object of file reader 
        File file = new File(pSource);
        // class with CSV file as a parameter. 
        FileReader filereader;
        ArrayList<QuizEntity> quizList;

        filereader = new FileReader(file);

        // create csvReader object and skip first Line 
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withSkipLines(1)
                .build();

        //read all data from csv
        List<String[]> allData = csvReader.readAll();
        //close file reader
        csvReader.close(); 
        
        //create an instance of quizList
        quizList = new ArrayList<>();

        // print Data 
        for (String[] row : allData) {

            QuizEntity quizc11 = new QuizEntity();
            quizc11.setRule(row[0]);
            quizc11.setQuestion(row[1]);
            quizc11.setAnswer(row[2]);
            
            //fill list
            quizList.add(quizc11);
        }

        return quizList;
    }
}
