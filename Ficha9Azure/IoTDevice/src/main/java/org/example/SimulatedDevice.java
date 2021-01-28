package org.example;

import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.IotHubClientProtocol;
import com.microsoft.azure.sdk.iot.device.Message;
import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.Gpio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class SimulatedDevice {

    // az iot hub device-identity show-connection-string --hub-name {YourIoTHubName} --device-id MyJavaDevice --output table
    private static String connString = "HostName=ctesp-tpsi-arqd-2019419.azure-devices.net;DeviceId=MyJavaDevice;SharedAccessKey=nCPyoDvKBP/27tJa+yWt8S/n/dAFJDz6UXGixbEnAbk=";

    // Using the MQTT protocol to connect to IoT Hub
    private static IotHubClientProtocol protocol = IotHubClientProtocol.MQTT;
    private static DeviceClient client;

    private static boolean alarmStatus = false;
    private UltraSonicSensor sonic;

    private GpioController gpio;
    private GpioPinDigitalOutput led;


    public SimulatedDevice() throws URISyntaxException, IOException {
       /*
        sonic = new UltraSonicSensor(
                0,//ECO PIN (physical 11)
                7,//TRIG PIN (pysical 22)
                1000,//REJECTION_START ; long (nano seconds)
                23529411 //REJECTION_TIME ; long (nano seconds)
        );

        */


        // Connect to the IoT hub.
        gpio = GpioFactory.getInstance();
        led = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);

        client = new DeviceClient(connString, protocol);
        client.open();

        // Register to receive direct method calls.
        client.subscribeToDeviceMethod(new DirectMethodCallback(this), null, new DirectMethodStatusCallback(), null);

        System.out.println("Device connected to hub!");
    }

    public void setAlarmOn(boolean status) {

        System.out.println("Direct method # Setting alarm: " + status);
        alarmStatus = status;

    }

    public void setAlarmOff(boolean status) {

        System.out.println("Direct method # Setting alarm: " + status);
        alarmStatus = status;

    }

    public void start() {
        TimerTask task = new TimerTask() {
            @Override
            public void run(){
                try {
                    sendMessage();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    private void sendMessage() throws Exception {
        UltraSonicSensor sonic = new UltraSonicSensor(
                0,//ECO PIN (physical 11)
                7,//TRIG PIN (pysical 22)
                1000,//REJECTION_START ; long (nano seconds)
                23529411 //REJECTION_TIME ; long (nano seconds)
        );

        int distance = sonic.getDistance();

        if (distance <= 50) {

            led.setState(PinState.HIGH);
        }

        TelemetryDataPoint data = new TelemetryDataPoint(distance, new Date(), false, false);

        // Converter para JSON
        String dataJson = data.serialize();
        Message msg = new Message(dataJson);

        Object lockobj = new Object();

        // Send message
        System.out.println("Sending message " + dataJson);
        client.sendEventAsync(msg, new EventCallback(), lockobj);

        // Garante o syncronismo
        // só é desbloqueado qdo recebe respostra do HUB
        synchronized (lockobj){
            lockobj.wait();
        }
    }

    public static void main(String[] args) {
        try {
            SimulatedDevice device = new SimulatedDevice();
            device.start();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
