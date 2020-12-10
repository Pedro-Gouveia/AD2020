import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.time.LocalDate;
import java.util.Random;
import java.util.TimerTask;

public class TermoGUI extends JFrame{
    private JPanel jPanelMain;
    private JTextArea jLabelLog;
    private JLabel jLabelTempAtual;
    private JLabel jLabelTempDesejada;
    private JLabel jLabelHumidadeAtual;
    private JLabel jLabelHumidadeDesejada;
    private JButton jLabelPlusTemp;
    private JButton jLabelMinusTemp;
    private JButton jLabelPlusHumidade;
    private JButton jLabelMinusHumidade;
    private JLabel jLabelDate;
    private JLabel jLabelSatus;

    private float tempDesejada;
    private float tempAtual;

    /*
    private Random r = new Random();
    double prob = r.nextDouble();
    */


    public TermoGUI(String title){
        super(title);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setContentPane(jPanelMain);

        LocalDate date = LocalDate.now();
        //this.jLabelDate.setText(date);

        this.tempDesejada = 24;
        this.jLabelTempDesejada.setText(Float.toString(tempDesejada));

        jLabelPlusTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempDesejada += 0.5;
                jLabelTempDesejada.setText(Float.toString(tempDesejada));
            }
        });

        jLabelMinusTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempDesejada -= 0.5;
                jLabelTempDesejada.setText(Float.toString(tempDesejada));
            }
        });

        this.tempAtual = 22;
        this.jLabelTempAtual.setText(Float.toString(tempAtual));
    }

    /*
    public TermoGUI(){
        super();
    }
    */

    public static void main (String[] args){
        JFrame frame = new TermoGUI("Smart Termo");
        frame.setVisible(true);
    }

}
