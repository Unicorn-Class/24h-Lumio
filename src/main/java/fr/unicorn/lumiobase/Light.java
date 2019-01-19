package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import java.util.ArrayList;

public class Light {

    /**
     * Turn on a Column
     */


    public static boolean TurnOnColumn(Color c, int idColumn, String idLumio){

        IMqttClient publisher = Connections.connectPublisher();
        JSONObject json = new JSONObject();
        json.put("command", "set_column");
        json.put("led", idColumn);
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

    public static void TurnOnColumn(Color c, int idColumn, ArrayList<String> idsLumio){
        for (String s : idsLumio) TurnOnColumn(c, idColumn, s);

    }

    /**
     * Turn on just one pixel
     */

    public static void TurnOnPixel(Color c, int idPixel, String idLumio){
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

    public static void TurnOnPixel(Color c, int idPixel, ArrayList<String> idsLumio) {
        for (String s : idsLumio) TurnOnPixel(c, idPixel, s);
    }

    public static void TurnOffPixel(int idPixel, String idLumio) throws NameAlreadyUsedException {
        TurnOnPixel(Color.create("Off",0,0,0),idPixel,idLumio);
    }

    public static void TurnOffPixel(int idPixel, ArrayList<String> idsLumio) throws NameAlreadyUsedException {
        for (String s : idsLumio) TurnOnPixel(Color.create("Off",0,0,0),idPixel,s);
    }

    public static void TurnOnPixelDuring(Color c, int idPixel, String idLumio, int duration) throws InterruptedException, NameAlreadyUsedException {
        TurnOnPixel(c,idPixel,idLumio);
        Thread.sleep(duration);
        TurnOffPixel(idPixel,idLumio);
    }

    public static void TurnOnPixelDuring(Color c, int idPixel, ArrayList<String> idsLumio, int duration) throws InterruptedException, NameAlreadyUsedException {
        for (String s : idsLumio) TurnOnPixelDuring(c, idPixel, s, duration);
    }

    /**
     * Turn on a Ring
     */

    public static boolean TurnOnRing(Color color, int ring, String idLaumio){
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

    public static void TurnOnRing(Color c, int idColumn, ArrayList<String> idsLaumio){
        for (String s : idsLaumio) TurnOnRing(c, idColumn, s);
    }



    /**
     * Turn on all the Lumio
     */

    public static boolean TurnOnAllLumio(Color c, String idLumio){
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

    public static void TurnOnAllLumio(Color c, String[] idLumio){
        for (String id : idLumio) {
            TurnOnAllLumio(c, id);
        }
    }


    /**
     * Turn off Lumio
     */

    public static boolean TurnOffLumio(String idLumio) throws NameAlreadyUsedException {
        return TurnOnAllLumio(Color.create("off", 0, 0, 0), idLumio);
    }

    public static void TurnOffLumio(ArrayList<String> idLumio) throws NameAlreadyUsedException {
        for(String s : idLumio) {
            TurnOnAllLumio(Color.create("off", 0, 0, 0), s);
        }
    }
}
