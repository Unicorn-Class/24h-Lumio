package fr.unicorn.lumiobase.sensors;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Athmospheric {
    public static boolean online = false;

    public static float temperature = -1;
    public static float pressure = -1;
    public static float humidity = -1;
    public static float absHumidity = -1;

    public static void initAtmospheric(IMqttClient client) throws MqttException {
        client.subscribe("atmosphere/temperature", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            temperature = Float.parseFloat(str);
        });
        client.subscribe("atmosphere/pression", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            pressure = Float.parseFloat(str);
        });
        client.subscribe("atmosphere/humidite", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            humidity = Float.parseFloat(str);
        });
        client.subscribe("atmosphere/humidite_absolue", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            absHumidity = Float.parseFloat(str);
        });
        client.subscribe("atmosphere/status", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("online")) atmosphereStatus(true);
            else atmosphereStatus(false);
        });
    }

    public static void atmosphereStatus(boolean state) {
        if (state) System.out.println("Presence : Online");
        else System.out.println("Presence : Offline");
        online = state;
    }
}
