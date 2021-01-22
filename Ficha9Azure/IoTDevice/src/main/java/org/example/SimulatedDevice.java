package org.example;

import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.IotHubClientProtocol;
import com.microsoft.azure.sdk.iot.device.Message;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

public class SimulatedDevice {

    // az iot hub device-identity show-connection-string --hub-name {YourIoTHubName} --device-id MyJavaDevice --output table
    private static String connString = "HostName=ctesp-tpsi-arqd-2019419.azure-devices.net;DeviceId=MyJavaDevice;SharedAccessKey=nCPyoDvKBP/27tJa+yWt8S/n/dAFJDz6UXGixbEnAbk=";

    // Using the MQTT protocol to connect to IoT Hub
    private static IotHubClientProtocol protocol = IotHubClientProtocol.MQTT;
    private static DeviceClient client;


    public SimulatedDevice() throws URISyntaxException, IOException {
        // Connect to the IoT hub.
        client = new DeviceClient(connString, protocol);
        client.open();

        // Register to receive direct method calls.
        client.subscribeToDeviceMethod(new DirectMethodCallback(), null, new DirectMethodStatusCallback(), null);

        System.out.println("Device connected to hub!");
    }

    public void start() {
        TimerTask task = new TimerTask() {
            @Override
            public void run(){
                try {
                    sendMessage();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    private void sendMessage() throws InterruptedException {
        TelemetryDataPoint data = new TelemetryDataPoint(25, 70);
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
