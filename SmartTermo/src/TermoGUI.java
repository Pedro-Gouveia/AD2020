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
    private float tempDesejadaFahrenheit;
    private float tempAtualFahrenheit;
    private LocalDate dataAtual;
    private String tempUnit;

    /*
    private Random rand = new Random();
    double prob = rand.nextDouble();
    */


    public TermoGUI(String title){
        super(title);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setContentPane(jPanelMain);

        this.dataAtual = LocalDate.now();
        this.jLabelDate.setText(String.valueOf(dataAtual));

        this.tempUnit = "c";

        this.tempDesejada = 24;
        this.jLabelTempDesejada.setText(Float.toString(tempDesejada) + " ºC");

        this.tempAtual = 22;
        this.jLabelTempAtual.setText(Float.toString(tempAtual));

        jLabelPlusTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tempUnit == "c") {
                    tempDesejada += 0.5;
                    tempDesejadaFahrenheit = (float) ((tempDesejada) * 1.8 +32);
                    jLabelTempDesejada.setText(Float.toString(tempDesejada) + " ºC");

                } else if (tempUnit == "f"){
                    tempDesejadaFahrenheit += (0.5 * 1.8) +32;
                    tempDesejada = (float) ((tempDesejadaFahrenheit - 32)/1.8);
                    jLabelTempDesejada.setText(Float.toString(tempDesejadaFahrenheit) + " ºF");
                }
            }
        });

        jLabelMinusTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tempUnit == "c") {
                    tempDesejada -= 0.5;
                    tempDesejadaFahrenheit = (float) ((tempDesejada) * 1.8 +32);
                    jLabelTempDesejada.setText(Float.toString(tempDesejada) + " ºC");

                } else if (tempUnit == "f"){
                    tempDesejadaFahrenheit -= (0.5 * 1.8) +32;
                    tempDesejada = (float) ((tempDesejadaFahrenheit - 32)/1.8);
                    jLabelTempDesejada.setText(Float.toString(tempDesejadaFahrenheit) + " ºF");
                }
            }
        });

        jLabelConvertTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tempUnit == "c") {
                    tempDesejadaFahrenheit = (float) ((tempDesejada) * 1.8 +32);
                    jLabelTempDesejada.setText(Float.toString(tempDesejadaFahrenheit) + " ºF");
                    jLabelLog.append("Converteu de Celsius para Fahrenheit." + "\n");
                    tempUnit = "f";

                } else if (tempUnit == "f"){
                    jLabelTempDesejada.setText(Float.toString(tempDesejada) + " ºC");
                    jLabelLog.append("Converteu de Fahrenheit para Celsius." + "\n");
                    tempUnit = "c";
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
    public void setTermoStatus(){
        if (tempAtual < tempDesejada){
            jLabelSatus.setText("ON");
        }
    }

    public static void main (String[] args){
        JFrame frame = new TermoGUI("Smart Termo");
        frame.setVisible(true);
    }

}
