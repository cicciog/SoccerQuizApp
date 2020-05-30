package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author francesco
 */
public class StartPanel extends JPanel {

    private BufferedImage logoAia;
    private JLabel logoAiaLabel;
    private JButton startQuiz;
    private JComboBox chooseType;
    private JSlider numberOfQuestion;
    private JLabel statusLabel;
    private JLabel header;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    public StartPanel(Dimension pDimension) throws IOException {
        super();

        //create section of start screen
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        //set background color
        setBackground(Color.decode("#FFFFFF"));
        panel1.setBackground(Color.decode("#FFFFFF"));
        panel2.setBackground(Color.decode("#FFFFFF"));
        panel3.setBackground(Color.decode("#FFFFFF"));
        panel4.setBackground(Color.decode("#FFFFFF"));

        //set size
        setSize(pDimension);

        //creata aia logo
        logoAia = ImageIO.read(new File("/home/francesco/NetBeansProjects/mavenproject1/src/main/java/assets/logo_aia.png"));
        logoAiaLabel = new JLabel(new ImageIcon(logoAia));
        logoAiaLabel.setLocation(0, 0);
        panel1.add(logoAiaLabel);

        //create header section
        header = new JLabel("Benvenuto nell’applicazione dei\nquiz per arbitri AIA Figc");
        panel2.add(header);

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
        startQuiz = new JButton("Inizia quiz");
        startQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chooseType.getSelectedItem().equals("scegli quiz")) {
                    // display the jdialog when type of quiz didn't selected
                    JOptionPane.showMessageDialog(null, "Attenzione! Non hai scelto il tipo di quiz che desideri svolgere");
                } else {
                    try {
                        Thread.sleep(1000);
                        panel3.setVisible(false);
                        panel4.setVisible(false);
                        header.setText("il quiz avrà inizio tra pochi secondi...");
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

            }
        });
        panel4.add(startQuiz);

        //paint start screen
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);

    }

}
