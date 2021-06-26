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
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author cicciog
 */
public class StartPanel extends JPanel {

    private BufferedImage logoAia;
    private JLabel logoAiaLabel;
    public JButton startQuizBtn;
    public JComboBox chooseType;
    public JSlider numberOfQuestion;
    private JLabel statusLabel;
    private JLabel header;
    private JLabel rules;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;

    public StartPanel() {
        try {
            initPanel();
        } catch (IOException ex) {
            System.out.println("There is a problem to retrieve the logo");
        }
    }

    private void initPanel() throws IOException {

        //create section of start screen
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();

        //set background color
        this.setBackground(Color.decode("#FFFFFF"));
        panel1.setBackground(Color.decode("#FFFFFF"));
        panel2.setBackground(Color.decode("#FFFFFF"));
        panel5.setBackground(Color.decode("#FFFFFF"));
        panel3.setBackground(Color.decode("#FFFFFF"));
        panel4.setBackground(Color.decode("#FFFFFF"));

        //create aia logo
        logoAia = ImageIO.read(new File("src/main/java/resources/logo_aia.png"));

        logoAiaLabel = new JLabel(new ImageIcon(logoAia));
        panel1.add(logoAiaLabel);

        //create header section
        header = new JLabel("Benvenuto nell’applicazione dei quiz per arbitri AIA Figc");
        panel2.add(header);

        //create section that show the rules that determine score
        rules = new JLabel("PUNTEGGIO RISPOSTE: Corrette: +3 Errate: -2 Non date: +1");
        rules.setFont(new Font("Serif", Font.PLAIN, 14));
        panel5.add(rules);

        //create jlist
        Object[] data = {"scegli quiz", "Calcio a 11", "Calcio a 5"};
        chooseType = new JComboBox(data);

        //create jslider
        statusLabel = new JLabel("Grandezza test: 10");
        numberOfQuestion = new JSlider(JSlider.HORIZONTAL, 5, 15, 10);
        numberOfQuestion.setPaintTicks(true);
        numberOfQuestion.setPaintLabels(true);
        numberOfQuestion.setMinorTickSpacing(1);
        numberOfQuestion.setMaximum(5);
        numberOfQuestion.setMaximum(15);
        numberOfQuestion.setValue(10);

        numberOfQuestion.addChangeListener((ChangeEvent e) -> {
            if (((JSlider) e.getSource()).getValue() < 10) {
                statusLabel.setText("Grandezza test: 0" + ((JSlider) e.getSource()).getValue());
            } else {
                statusLabel.setText("Grandezza test: " + ((JSlider) e.getSource()).getValue());
            }
        });

        //create section 3 of start screen
        panel3.add(chooseType);
        panel3.add(statusLabel);
        panel3.add(numberOfQuestion);

        //create section 4 of start screen
        startQuizBtn = new JButton("Inizia quiz");
        panel4.add(startQuizBtn);

        //paint start screen
        add(panel1);
        add(panel2);
        add(panel5);
        add(panel3);
        add(panel4);
    }

}
