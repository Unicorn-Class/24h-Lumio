package fr.unicorn.lumiobase.sensors;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Distance {
    public boolean online = false;

    public float distance = -1;

    public void initDistance(IMqttClient client) throws MqttException {
        client.subscribe("distance/value", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            distance = Float.parseFloat(str);
            //System.out.println("distance = " + distance);
        });
        client.subscribe("distance/status", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("online")) distanceStatus(true);
            else distanceStatus(false);
        });
    }

    public  void distanceStatus(boolean state) {
        if (state) System.out.println("Presence : Online");
        else {
            distance = -1;
            System.out.println("Presence : Offline");
        }
        online = state;
    }
}
