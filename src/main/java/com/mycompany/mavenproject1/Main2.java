package com.mycompany.mavenproject1;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author francesco
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try { 
        // Create an object of file reader 
        File file = new File("/home/francesco/NetBeansProjects/mavenproject1/src/main/java/storage/quiz_c11.csv");
        // class with CSV file as a parameter. 
        FileReader filereader = new FileReader(file); 
  
        // create csvReader object and skip first Line 
        CSVReader csvReader = new CSVReaderBuilder(filereader) 
                                  .withSkipLines(1) 
                                  .build(); 
        List<String[]> allData = csvReader.readAll(); 
  
        // print Data 
        for (String[] row : allData) { 
            for (String cell : row) { 
                System.out.print(cell + "\t"); 
            } 
            System.out.println(); 
        } 
    } 
    catch (Exception e) { 
        e.printStackTrace(); 
    } 
    }
    
}
