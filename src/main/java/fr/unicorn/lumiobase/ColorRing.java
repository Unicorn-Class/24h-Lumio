package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.UUID;

public class ColorRing {
    public static boolean sendColorRing(Color color, int ring){
        IMqttClient publisher = Connections.connectPublisher();

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
    public static boolean sendColorRing(Color color, int ring, String idLaumio){
        IMqttClient publisher = Connections.connectPublisher();

        JSONObject json = new JSONObject();
        json.put("command", "set_ring");
        json.put("ring", ring);
        json.put("rgb",color.getRGB());
        MqttMessage message = new MqttMessage();
        message.setPayload(json.toString().getBytes());
        try {
            publisher.publish("laumio/"+idLaumio+"/json",message);
        } catch (MqttException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean SendColorRing(Color c, int idColumn, ArrayList<String> idsLaumio){
        for (String s : idsLaumio) SendColorRing(c, idColumn, s);
    }
}
