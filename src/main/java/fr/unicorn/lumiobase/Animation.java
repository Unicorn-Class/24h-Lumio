package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

import java.util.UUID;

public class Animation {


    public static void colorWipe(Color rvb, int delay){
        for(int line = 0 ; line<Util.NB_LINE ; line++){
            for(int column = 0 ; column<Util.NB_COLUMN ; column++){
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ColorPixel.SendColorPixel(rvb, Util.getIdPixel(line, column));
            }
        }
    }

    public static void verticalWipe(Color rvb, int delay){
        for(int line=0 ; line < Util.NB_LINE ; line++){
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //TODO uncomment this
            //ColorLine.SendColorLine(rvb, Util.getIdLine(line));
        }
    }

    public static boolean rainbow(){

        IMqttClient publisher = Connections.connectPublisher(true);

        JSONObject json = new JSONObject();
        json.put("command", "animate_rainbow");
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
