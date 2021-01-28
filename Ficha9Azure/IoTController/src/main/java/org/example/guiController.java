package org.example;

import com.microsoft.azure.sdk.iot.service.devicetwin.DeviceMethod;
import com.microsoft.azure.sdk.iot.service.devicetwin.MethodResult;
import com.microsoft.azure.sdk.iot.service.exceptions.IotHubException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class guiController extends JFrame{
    private JPanel panel1;
    private JButton alterarButton;
    private JButton ativarButton;
    private JTextArea logArea;
    private JSlider distanceSlider;


    // Connection string for your IoT Hub
    // az iot hub show-connection-string --hub-name {your iot hub name} --policy-name service
    public static final String iotHubConnectionString = "HostName=ctesp-tpsi-arqd-2019419.azure-devices.net;SharedAccessKeyName=service;SharedAccessKey=eWQMRtjF0PHzoBjuKTU6B2xeMkdz/ZW+8TWlAcaQS7k=";

    // Device to call direct method on.
    public static final String deviceId = "MyJavaDevice";


    public static final Long responseTimeout = TimeUnit.SECONDS.toSeconds(30);
    public static final Long connectTimeout = TimeUnit.SECONDS.toSeconds(5);

    public static final String setAlarmOn = "setAlarmOn";
    public boolean alarmStatus = true;

    public guiController(String title) {
        super(title);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();

        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ativarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeviceMethod methodClient = null;
                try {
                    methodClient = DeviceMethod.createFromConnectionString(iotHubConnectionString);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                try {
                    MethodResult result = methodClient.invoke(deviceId, setAlarmOn, responseTimeout, connectTimeout, alarmStatus);

                    if (result == null) {
                        throw new IOException("Direct method invoke returns null");
                    }

                } catch (IotHubException iotHubException) {
                    iotHubException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        distanceSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });

    }


    public static void main (String[] args){
        JFrame frame = new guiController("Controller");
        frame.setVisible(true);
    }



}
