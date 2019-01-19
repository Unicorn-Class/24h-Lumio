package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

public class ColorPixel {

    public static void main(String args[]) throws NameAlreadyUsedException, InterruptedException {
        SendColorPixelDuring(Color.create("Bizarre",255,255,255),2,"all",2000);
        return;
    }

    public static boolean SendColorPixel(Color c, int idPixel, String idLumio){
        IMqttClient publisher = Connections.connectPublisher(false);
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
            return false;
        }
        return true;
    }

    public static void TurnOffLights(int idPixel, String idLumio) throws NameAlreadyUsedException {
        SendColorPixel(Color.create("Off",0,0,0),idPixel,idLumio);
    }

    public static void SendColorPixelDuring(Color c, int idPixel, String idLumio, int duration) throws InterruptedException, NameAlreadyUsedException {
        SendColorPixel(c,idPixel,idLumio);
        Thread.sleep(duration);
        TurnOffLights(idPixel,idLumio);
    }
}
