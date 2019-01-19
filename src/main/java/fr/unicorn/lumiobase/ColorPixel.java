package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

import java.util.UUID;

public class ColorPixel {

    public static void main(String args[]){
        SendColorPixel(Color.create("Bizarre",255,100,85),2);
        return;
    }

    public static boolean SendColorPixel(Color c, int idPixel){
        String publisherId = UUID.randomUUID().toString();
        IMqttClient publisher = null;
        try {
            publisher = new MqttClient("tcp://192.168.43.35:1883",publisherId);
        } catch (MqttException e) {
            e.printStackTrace();
            return false;
        }

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        try {
            publisher.connect(options);
        } catch (MqttException e) {
            e.printStackTrace();
            return false;
        }

        JSONObject json = new JSONObject();
        json.put("command", "set_pixel");
        json.put("led", idPixel);
        json.put("rgb",c.getRGB());
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
