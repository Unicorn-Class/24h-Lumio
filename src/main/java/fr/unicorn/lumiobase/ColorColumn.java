package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

import java.util.UUID;

public class ColorColumn {


    public static boolean SendColorColumn(Color c, int idColumn){

        IMqttClient publisher = Connections.connectPublisher();
        JSONObject json = new JSONObject();
        json.put("command", "set_column");
        json.put("led", idColumn);
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
