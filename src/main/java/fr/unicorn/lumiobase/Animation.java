package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

import java.util.UUID;

public class Animation {


    public static void colorWipe(Color rvb, int delay){
        for(int line = 0 ; line< (int) ReadProperties.prop.getJSONObject("lumio").getInt("NB_LINE") ; line++){
            for(int column = 0 ; column< (int) ReadProperties.prop.getJSONObject("lumio").getInt("NB_COLUMN") ; column++){
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //ColorPixel.SendColorPixel(rvb, Util.getIdPixel(line, column));
            }
        }
    }

    public static void verticalWipe(Color rvb, int delay){
        for(int line=0 ; line < ReadProperties.prop.getJSONObject("lumio").getInt("NB_LINE") ; line++){
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            //TODO uncomment this
            //ColorLine.SendColorLine(rvb, Util.getIdLine(line));
        }
        return true;
    }

    public static boolean rainbow(){

        IMqttClient publisher = Connections.connectPublisher();

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

    public static boolean glow(Color color, int time, int delay){
        int compt = 0;
        boolean reduce = true;
        while(compt<time){
            compt+=delay;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            Boubou.SendColorLumio(color, "all");
            if(reduce){
                if(!color.reduce()){
                    reduce = false;
                }
            }else{
                if(!color.increase()){
                    reduce = true;
                }
            }
        }
        return true;
    }

}
