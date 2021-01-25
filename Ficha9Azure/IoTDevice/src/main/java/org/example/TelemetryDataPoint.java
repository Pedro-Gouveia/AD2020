package org.example;

import com.google.gson.Gson;

import java.util.Date;

public class TelemetryDataPoint {

    public int distance;
    public Date date;
    public boolean alarmOn;
    public boolean intruderDetected;

    public TelemetryDataPoint(int distance, Date date, boolean alarmOn, boolean intruderDetected) {

        this.distance = distance;
        this.date = date;
        this.alarmOn = alarmOn;
        this.intruderDetected = intruderDetected;
    }

    // Serialize object to JSON format.
    public String serialize() {
            Gson gson = new Gson();
            return gson.toJson(this);
    }
}

