package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author francesco
 */
public class ApplicationFrame extends JFrame {
    // java - get screen size using the Toolkit class

    private Dimension screenSize;
    private StartPanel startPanel;

    public ApplicationFrame(String pTitle) throws IOException {
        // invoke the JFrame constructor
        super(pTitle);                      
        
        //frame size
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width/3,screenSize.height/2);
        
        //add start panel
        startPanel = new StartPanel(screenSize);
        add(startPanel);
        
        setVisible(true);
        setResizable(false);
                
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
      

// add the label to the JFrame
        
    }

}
