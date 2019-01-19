package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

import java.util.ArrayList;
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

    public static boolean verticalWipe(Color rvb, int delay){
        for(int line=0 ; line < ReadProperties.prop.getJSONObject("lumio").getInt("NB_LINE") ; line++){
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            ColorRing.sendColorRing(rvb, line);
        }
        return true;
    }

    public static boolean verticalWipe(Color rvb, int delay, String idLaumio){
        for(int line=0 ; line < ReadProperties.prop.getJSONObject("lumio").getInt("NB_LINE") ; line++){
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            ColorRing.sendColorRing(rvb, line,idLaumio);
        }
        return true;
    }

    public static void verticalWipe(Color rvb, int delay, ArrayList<String> idsLaumio){
        for (String s : idsLaumio) verticalWipe(rvb, delay, s);
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

    public static boolean rainbow(String idLaumio){

        IMqttClient publisher = Connections.connectPublisher();

        JSONObject json = new JSONObject();
        json.put("command", "animate_rainbow");
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

    public static void rainbow(ArrayList<String> idsLaumio){
        for (String s : idsLaumio) rainbow(s);
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

    public static boolean glow(Color color, int time, int delay, String idLaumio){
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
            Boubou.SendColorLumio(color,idLaumio);

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

    public static void glow(Color color, int time, int delay, ArrayList<String> idsLaumio){
        for (String s : idsLaumio) glow(color,time,delay,s);
    }

    public static boolean arrow(Color color, int time, int delay, String id_laumio) throws NameAlreadyUsedException {
        int compt = 0;
        int pix1[]={0,0};
        int pix2[]={1,1};
        int pix3[]={0,2};
        while(compt<time){
            compt+=delay;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            Boubou.TurnOffLumio(id_laumio);
            ColorPixel.SendColorPixel(color,Util.getIdPixel(pix1[0],pix1[1]),id_laumio);
            ColorPixel.SendColorPixel(color,Util.getIdPixel(pix2[0],pix2[1]),id_laumio);
            ColorPixel.SendColorPixel(color,Util.getIdPixel(pix3[0],pix3[1]),id_laumio);
            pix1[1]++;
            pix2[1]++;
            pix3[1]++;
        }
        return true;
    }
    public static void arrow(Color color, int time, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException {
        for (String s : idsLaumio) arrow(color,time,delay,s);
    }

    public static boolean plus(int time, int delay) throws NameAlreadyUsedException {
        Color green=Color.create("Green",0,255,0);
        int compt = 0;
        while(compt<time) {
            compt += delay;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            ColorRing.sendColorRing(green, 1);
            ColorColumn.SendColorColumn(green,1);
            ColorColumn.SendColorColumn(green,2);
        }
        return true;
    }

    public static boolean plus(int time, int delay, String idLaumio) throws NameAlreadyUsedException {
        Color green=Color.create("Green",0,255,0);
        int compt = 0;
        while(compt<time) {
            compt += delay;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            ColorRing.sendColorRing(green, 1,idLaumio);
            ColorColumn.SendColorColumn(green,1,idLaumio);
            ColorColumn.SendColorColumn(green,2,idLaumio);
        }
        return true;
    }

    public static void plus(int time, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException {
        for (String s : idsLaumio) plus(time,delay,s);
    }

    public static boolean minus(int time, int delay ) throws NameAlreadyUsedException {
        Color red=Color.create("Red",255,0,0);
        int compt = 0;
        while(compt<time) {
            compt += delay;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            ColorRing.sendColorRing(red, 1);
        }
        return true;
    }

    public static boolean minus(int time, int delay, String idLaumio ) throws NameAlreadyUsedException {
        Color red=Color.create("Red",255,0,0);
        int compt = 0;
        while(compt<time) {
            compt += delay;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            ColorRing.sendColorRing(red, 1,idLaumio);
        }
        return true;
    }

    public static void minus(int time, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException {
        for (String s : idsLaumio) minus(time,delay,s);
    }

    public static boolean rain(int time, int delay, String id_laumio) throws NameAlreadyUsedException {
        Color blue=Color.create("Blue",0,0,255);
        Color white=Color.create("Blue",255,255,255);
        int compt = 0;
        while(compt<time) {
            compt += delay;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            Boubou.TurnOffLumio(id_laumio);
            ColorRing.sendColorRing(white, 0);
            ColorPixel.SendColorPixel(blue,Util.getIdPixel(1,1),id_laumio);
            ColorPixel.SendColorPixel(blue,Util.getIdPixel(1,2),id_laumio);
            ColorPixel.SendColorPixel(blue,Util.getIdPixel(2,1),id_laumio);
            ColorPixel.SendColorPixel(blue,Util.getIdPixel(2,2),id_laumio);
        }
        return true;
    }

    public static void rain(int time, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException {
        for (String s : idsLaumio) rain(time,delay,s);
    }

    public static boolean happy(int time, int delay, String id_laumio) throws NameAlreadyUsedException {
        Color green=Color.create("Green",0,255,0);
        int compt = 0;
        while(compt<time) {
            compt += delay;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            Boubou.TurnOffLumio(id_laumio);
            ColorPixel.SendColorPixel(green,Util.getIdPixel(1,0),id_laumio);
            ColorPixel.SendColorPixel(green,Util.getIdPixel(2,1),id_laumio);
            ColorPixel.SendColorPixel(green,Util.getIdPixel(2,2),id_laumio);
            ColorPixel.SendColorPixel(green,Util.getIdPixel(1,3),id_laumio);

        }
        return true;
    }

    public static void happy(int time, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException {
        for (String s : idsLaumio) happy(time,delay,s);
    }

    public static boolean sad(int time, int delay, String id_laumio) throws NameAlreadyUsedException {
        Color red=Color.create("Red",255,0,0);
        int compt = 0;
        while(compt<time) {
            compt += delay;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            Boubou.TurnOffLumio(id_laumio);
            ColorPixel.SendColorPixel(red,Util.getIdPixel(0,2),id_laumio);
            ColorPixel.SendColorPixel(red,Util.getIdPixel(1,1),id_laumio);
            ColorPixel.SendColorPixel(red,Util.getIdPixel(1,2),id_laumio);
            ColorPixel.SendColorPixel(red,Util.getIdPixel(2,3),id_laumio);

        }
        return true;
    }

    public static void sad(int time, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException {
        for (String s : idsLaumio) sad(time,delay,s);
    }

}
