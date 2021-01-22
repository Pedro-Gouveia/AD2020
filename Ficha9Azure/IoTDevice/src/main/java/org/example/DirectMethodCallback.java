package org.example;

import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethodCallback;
import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceMethodData;

public class DirectMethodCallback implements DeviceMethodCallback
{
    // Define method response codes
    private static final int METHOD_SUCCESS = 200;
    private static final int METHOD_NOT_DEFINED = 404;
    private static final int INVALID_PARAMETER = 400;


    private static int telemetryInterval = 1000;
    private static boolean heaterState = false;

    private void setTelemetryInterval(int interval)
    {
        System.out.println("Direct method # Setting telemetry interval (seconds): " + interval);
        telemetryInterval = interval * 1000;
    }

    private void SetHeaterOn(boolean state) {

        System.out.println("Direct method # Setting heater: " + state);
        heaterState = state;

    }

    @Override
    public DeviceMethodData call(String methodName, Object methodData, Object context)
    {
        DeviceMethodData deviceMethodData;
        String payload = new String((byte[])methodData);
        switch (methodName)
        {
            case "SetHeaterOn": {

                boolean state;
                try {
                    int status = METHOD_SUCCESS;
                    state = Boolean.parseBoolean(payload);
                    System.out.println(payload);
                    SetHeaterOn(state);
                    deviceMethodData = new DeviceMethodData(status, "Executed direct method " + methodName);
                } catch (NumberFormatException e) {
                    int status = INVALID_PARAMETER;
                    deviceMethodData = new DeviceMethodData(status, "Invalid parameter " + payload);
                }
                break;
            }

            case "SetTelemetryInterval" :
            {
                int interval;
                try {
                    int status = METHOD_SUCCESS;
                    interval = Integer.parseInt(payload);
                    System.out.println(payload);
                    setTelemetryInterval(interval);
                    deviceMethodData = new DeviceMethodData(status, "Executed direct method " + methodName);
                } catch (NumberFormatException e) {
                    int status = INVALID_PARAMETER;
                    deviceMethodData = new DeviceMethodData(status, "Invalid parameter " + payload);
                }
                break;
            }
            default:
            {
                int status = METHOD_NOT_DEFINED;
                deviceMethodData = new DeviceMethodData(status, "Not defined direct method " + methodName);
            }
        }
        return deviceMethodData;
    }

}
