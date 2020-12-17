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
    private JButton jLabelConvertTemp;
    private JButton JLabelCleatLog;

    private float tempDesejada;
    private float tempAtual;
    private LocalDate dataAtual;
    private String tempUnit;


    public TermoGUI(String title){
        super(title);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setContentPane(jPanelMain);

        this.dataAtual = LocalDate.now();
        this.jLabelDate.setText(String.valueOf(dataAtual));

        this.tempUnit = "C";

        this.tempDesejada = 24;
        this.jLabelTempDesejada.setText(tempDesejada + " º" + tempUnit);

        this.tempAtual = 22;
        this.jLabelTempAtual.setText(Float.toString(tempAtual));


        jLabelPlusTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempDesejada += 0.5;
                if (tempUnit == "C") {
                    jLabelTempDesejada.setText(tempDesejada + " º" + tempUnit);

                } else {
                    jLabelTempDesejada.setText(convertToF(tempDesejada) + " º" + tempUnit);
                }
            }
        });

        jLabelMinusTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempDesejada -= 0.5;
                if (tempUnit == "C") {
                    jLabelTempDesejada.setText(tempDesejada + " º" + tempUnit);

                } else {
                    jLabelTempDesejada.setText(convertToF(tempDesejada) + " º" + tempUnit);
                }
            }
        });

        jLabelConvertTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tempUnit == "C") {
                    tempUnit = "F";
                    jLabelTempDesejada.setText(convertToF(tempDesejada) + " º" + tempUnit);
                    appendLog("Converteu de Celsius para Fahrenheit.");

                } else {
                    tempUnit = "C";
                    jLabelTempDesejada.setText(tempDesejada + " º" + tempUnit);
                    appendLog("Fahrenheit de Celsius para Celsius.");
                }
            }
        });
        JLabelCleatLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabelLog.setText(null);
            }

        });
    }

    /*
    public TermoGUI(){
        super();
    }
    */


    public void appendLog(String text){
        jLabelLog.append(text + "\n");
    }

    public float convertToF(float temp){
        return (float) (temp * 1.8 +32);
    }

    public void setTermoStatus(){
        if (tempAtual < tempDesejada){
            jLabelSatus.setText("ON");
        } else {
            jLabelSatus.setText("OFF");
        }
    }

    public static void main (String[] args){
        JFrame frame = new TermoGUI("Smart Termo");
        frame.setVisible(true);
    }

}
