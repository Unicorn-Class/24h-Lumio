package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

import java.util.UUID;

public class ColorPixel {

    public static void main(String args[]) throws NameAlreadyUsedException {
        SendColorPixel(Color.create("Bizarre",255,255,255),2);
        return;
    }

    public static boolean SendColorPixel(Color c, int idPixel){
        IMqttClient publisher = Connections.connectPublisher(false);
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
