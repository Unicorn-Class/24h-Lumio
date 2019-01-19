package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import java.util.UUID;

public class ColorRing {
    public boolean sendColorRing(Color color, int ring){
        IMqttClient publisher = Connections.connectPublisher(true);

        JSONObject json = new JSONObject();
        json.put("command", "set_ring");
        json.put("ring", ring);
        json.put("rgb",color.getRGB());
        MqttMessage message = new MqttMessage();
        message.setPayload(json.toString().getBytes());
        try {
            publisher.publish("laumio/all/json",message);
        } catch (MqttException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
