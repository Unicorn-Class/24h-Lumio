package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import java.util.ArrayList;

public class Boubou {

    public static boolean SendColorLumio(Color c, String idLumio){
        IMqttClient publisher = Connections.connectPublisher();

        JSONObject json = new JSONObject();
        json.put("command", "fill");
        json.put("rgb",c.getRGB());
        MqttMessage message = new MqttMessage();
        message.setPayload(json.toString().getBytes());
        try {
            publisher.publish("laumio/"+idLumio+"/json",message);
        } catch (MqttException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void SendColorLumio(Color c, String[] idLumio){
        for (String id : idLumio) {
            SendColorLumio(c, id);
        }
    }

    public static boolean TurnOffLumio(String idLumio) throws NameAlreadyUsedException {
        return SendColorLumio(Color.create("off", 0, 0, 0), idLumio);
    }
    public static void TurnOffLumio(ArrayList<String> idLumio) throws NameAlreadyUsedException {
        for(String s : idLumio) {
            SendColorLumio(Color.create("off", 0, 0, 0), s);
        }
    }
}
