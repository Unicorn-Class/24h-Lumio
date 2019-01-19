package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

public class Boubou {

    public static void main(String[] a) throws NameAlreadyUsedException {
        SendColorLumio(Color.create("", 23, 45 ,123), "3");
    }

    public static boolean SendColorLumio(Color c, String idLumio){
        IMqttClient publisher = Connections.connectPublisher(true);

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

    public static boolean TurnOffLumio(String idLumio) throws NameAlreadyUsedException {
        return SendColorLumio(Color.create("off", 0, 0, 0), idLumio);
    }
}
