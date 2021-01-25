package com.example.smartalarm;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubConsumerAsyncClient;
import com.fasterxml.jackson.databind.util.TokenBufferReadContext;

public class MainActivity extends AppCompatActivity {

    private static final String EH_COMPATIBLE_CONNECTION_STRING_FORMAT = "Endpoint=%s/;EntityPath=%s;"
            + "SharedAccessKeyName=%s;SharedAccessKey=%s";

    // az iot hub show --query properties.eventHubEndpoints.events.endpoint --name {your IoT Hub name}
    private static final String EVENT_HUBS_COMPATIBLE_ENDPOINT = "sb://ihsuprodamres070dednamespace.servicebus.windows.net/";

    // az iot hub show --query properties.eventHubEndpoints.events.path --name {your IoT Hub name}
    private static final String EVENT_HUBS_COMPATIBLE_PATH = "iothub-ehub-ctesp-tpsi-6674618-c93477aa8b";

    // az iot hub policy show --name service --query primaryKey --hub-name {your IoT Hub name}
    private static final String IOT_HUB_SAS_KEY = "eWQMRtjF0PHzoBjuKTU6B2xeMkdz/ZW+8TWlAcaQS7k=";
    private static final String IOT_HUB_SAS_KEY_NAME = "service";

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Runnable runnable = new Runnable(){
            public void run(){
                String eventHubCompatibleConnectionString = String.format(EH_COMPATIBLE_CONNECTION_STRING_FORMAT,
                        EVENT_HUBS_COMPATIBLE_ENDPOINT, EVENT_HUBS_COMPATIBLE_PATH, IOT_HUB_SAS_KEY_NAME, IOT_HUB_SAS_KEY);

                // Setup the EventHubBuilder by configuring various options as needed.
                EventHubConsumerAsyncClient client = new EventHubClientBuilder()
                        .consumerGroup(EventHubClientBuilder.DEFAULT_CONSUMER_GROUP_NAME)
                        .connectionString(eventHubCompatibleConnectionString).buildAsyncConsumerClient();

                client.receive(false) // set this to false to read only the newly available events
                        .subscribe(partitionEvent -> {
                                   String s = partitionEvent.getData().getBodyAsString();
                            textView.post(new Runnable() {
                                public void run() {textView.setText(s);}
                            });

                        }, ex -> {
                            System.out.println("Error receiving events " + ex);
                        }, () -> {
                            System.out.println("Completed receiving events");
                        });
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}