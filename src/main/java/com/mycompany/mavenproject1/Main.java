package com.mycompany.mavenproject1;

import GUI.ApplicationFrame;
import java.io.IOException;


/**
 *
 * @author francesco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ApplicationFrame applicationFrame = new ApplicationFrame("Associazione Italiana Arbitri [Quiz]");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}
