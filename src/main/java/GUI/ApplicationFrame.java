package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author francesco
 */
public class ApplicationFrame extends JFrame {

    //set screen size 
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final Dimension FRAME_SIZE = new Dimension(screenSize.width / 3,screenSize.height / 2);

    //panel declaration
    private StartPanel startPanel;
    private QuizC11Panel quizC11panel;
    private QuizC5Panel quizC5Panel;
    private PiePanel piePanel;

    public ApplicationFrame(String pTitle){
        
        this.setTitle(pTitle);
        this.setSize(screenSize.width / 3, screenSize.height / 2);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_SIZE);
        
        piePanel = new PiePanel();
        initPanel(piePanel,false); 
        
        startPanel = new StartPanel();
        initPanel(startPanel,true);
        
        startPanel.startQuizBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startPanel.chooseType.getSelectedItem().equals("scegli quiz")) {
                    // display the jdialog when type of quiz didn't selected
                    JOptionPane.showMessageDialog(null, "Attenzione! Non hai scelto il tipo di quiz che desideri svolgere");
                } else if (startPanel.chooseType.getSelectedItem().equals("Calcio a 11")) {
                    JOptionPane.showMessageDialog(null, "Desideri fare i quiz di calcio a 11");
                    swapPanel(startPanel,piePanel);
                    startPanel.invalidate();
                    startPanel.removeAll();
                    piePanel.validate();
                } else {
                    JOptionPane.showMessageDialog(null, "Desideri fare i quiz di calcio a 5");
                    swapPanel(startPanel,piePanel);
                    startPanel.invalidate();
                    startPanel.removeAll();
                    piePanel.validate();
                }
            }
        });

    }

    private void initPanel(JPanel pPanel, boolean pValue) {
        pPanel.setSize(FRAME_SIZE);
        pPanel.setVisible(pValue);
        this.add(pPanel);
    }
    
     private void swapPanel(JPanel pFrom, JPanel pTo) {
        pTo.setVisible(true);
        pFrom.setVisible(false);
    }

    /*   public void createquiz(){
        QuizCSVmanager quizC11manager = new QuizCSVmanager();
        ArrayList<QuizEntity> quizList = new ArrayList<>();
        QuizC5Logic quizC5Logic = null;
        
        try {
            quizList = (ArrayList<QuizEntity>) quizC11manager.readAllC11Quizzes("/home/francesco/NetBeansProjects/mavenproject1/src/main/java/storage/quiz_c11.csv");
            quizC5Logic = new QuizC5Logic(quizList, 10);
        } catch (NullPointerException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        quizC5Panel = new QuizC5Panel(screenSize,quizC5Logic);
    }*/
}
