package org.example;

import com.microsoft.azure.sdk.iot.service.devicetwin.DeviceMethod;
import com.microsoft.azure.sdk.iot.service.devicetwin.MethodResult;
import com.microsoft.azure.sdk.iot.service.exceptions.IotHubException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SimulatedController {

    // Connection string for your IoT Hub
    // az iot hub show-connection-string --hub-name {your iot hub name} --policy-name service
    public static final String iotHubConnectionString = "HostName=ctesp-tpsi-arqd-2019419.azure-devices.net;SharedAccessKeyName=service;SharedAccessKey=eWQMRtjF0PHzoBjuKTU6B2xeMkdz/ZW+8TWlAcaQS7k=";

    // Device to call direct method on.
    public static final String deviceId = "MyJavaDevice";

    // Name of direct method and payload.
    // public static final String methodName = "SetTelemetryInterval";
    // public static final int payload = 10; // Number of seconds for telemetry interval.

    public static final String setAlarmOn = "setAlarmOn";
    public static final String setAlarmOff = "setAlarmOff";
    public static final boolean alarmStatus = false;

    public static final Long responseTimeout = TimeUnit.SECONDS.toSeconds(30);
    public static final Long connectTimeout = TimeUnit.SECONDS.toSeconds(5);

    public static void main(String[] args) {


        try {
            // Create a DeviceMethod instance to call a direct method.
            DeviceMethod methodClient = DeviceMethod.createFromConnectionString(iotHubConnectionString);

            // Call the direct method.
            //MethodResult result = methodClient.invoke(deviceId, methodName, responseTimeout, connectTimeout, payload);

            MethodResult result = methodClient.invoke(deviceId, setAlarmOn, responseTimeout, connectTimeout, alarmStatus);


            if (result == null) {
                throw new IOException("Direct method invoke returns null");
            }

            // Show the acknowledgement from the device.
            System.out.println("Status: " + result.getStatus());
            System.out.println("Response: " + result.getPayload());

        } catch (IOException e) {
            e.printStackTrace();

        } catch (IotHubException e) {
            e.printStackTrace();
        }

    }
}
