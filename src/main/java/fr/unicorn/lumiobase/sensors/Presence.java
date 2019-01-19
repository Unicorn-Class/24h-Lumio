package fr.unicorn.lumiobase.sensors;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Presence {

    public static boolean online = false;

    public static boolean presence = false;

    public static void initPresence(IMqttClient client) throws MqttException {
        client.subscribe("presence/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("ON")) presenceDetected(true);
            else presenceDetected(false);
        });
        client.subscribe("presence/status", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("online")) presenceStatus(true);
            else presenceStatus(false);
        });
    }

    public static void presenceDetected(boolean p) {
        presence = p;
        System.out.println("Presence !");
    }

    public static void presenceStatus(boolean state) {
        if (state) System.out.println("Presence : Online");
        else {
            presence = false;
            System.out.println("Presence : Offline");
        }
        online = state;
    }
}
