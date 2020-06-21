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
