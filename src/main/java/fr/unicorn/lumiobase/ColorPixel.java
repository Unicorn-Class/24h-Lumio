package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

import java.util.ArrayList;

public class ColorPixel {

    public static void main(String args[]) throws NameAlreadyUsedException, InterruptedException {
        SendColorPixelDuring(Color.create("Bizarre",255,255,255),2,"all",2000);
    }


    public static void SendColorPixel(Color c, int idPixel, String idLumio){
        IMqttClient publisher = Connections.connectPublisher();
        JSONObject json = new JSONObject();
        json.put("command", "set_pixel");
        json.put("led", idPixel);
        json.put("rgb",c.getRGB());
        MqttMessage message = new MqttMessage();
        message.setPayload(json.toString().getBytes());
        try {
            publisher.publish("laumio/"+idLumio+"/json",message);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public static void SendColorPixel(Color c, int idPixel, ArrayList<String> idsLumio) {
        for (String s : idsLumio) SendColorPixel(c, idPixel, s);
    }

    public static void TurnOffLights(int idPixel, String idLumio) throws NameAlreadyUsedException {
        SendColorPixel(Color.create("Off",0,0,0),idPixel,idLumio);
    }

    public static void TurnOffLights(int idPixel, ArrayList<String> idsLumio) throws NameAlreadyUsedException {
        for (String s : idsLumio) SendColorPixel(Color.create("Off",0,0,0),idPixel,s);
    }

    public static void SendColorPixelDuring(Color c, int idPixel, String idLumio, int duration) throws InterruptedException, NameAlreadyUsedException {
        SendColorPixel(c,idPixel,idLumio);
        Thread.sleep(duration);
        TurnOffLights(idPixel,idLumio);
    }
}
