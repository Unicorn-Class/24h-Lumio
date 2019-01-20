package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

import java.util.ArrayList;

public class Animation {


    public static void colorWipe(Color rvb, int delay, String id){
        for(int line = 0 ; line< (int) ReadProperties.prop.getJSONObject("lumio").getInt("NB_LINE") ; line++){
            for(int column = 0 ; column< (int) ReadProperties.prop.getJSONObject("lumio").getInt("NB_COLUMN") ; column++){
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Light.TurnOnPixel(rvb, Util.getIdPixel(line, column), id);
            }
        }
    }


    public static boolean verticalWipe(Color rvb, int delay, String idLaumio){
        for(int line=0 ; line < ReadProperties.prop.getJSONObject("lumio").getInt("NB_LINE") ; line++){
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            Light.TurnOnRing(rvb, line,idLaumio);
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


    public static boolean glow(Color color, int time, int delay, String idLaumio) throws NameAlreadyUsedException {
        int vr = color.getR()/10;
        int vg = color.getG()/10;
        int vb = color.getB()/10;
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
            Light.TurnOnAllLumio(color, idLaumio);

            if(reduce){
                if(!color.reduce(vr, vg, vb)){
                    reduce = false;
                }
            }else{
                if(!color.increase(vr, vg, vb)){
                    reduce = true;
                }
            }
        }
        return true;
    }


    public static void glow(Color color, int time, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException {
        for (String s : idsLaumio) {
            glow(color,time,delay,s);
        }
    }

    public static boolean plus(int time, int delay, String idLaumio) throws NameAlreadyUsedException {
        Color green=Color.create("Green",0,255,0);
        Light.TurnOffLumio(idLaumio);
        int compt = 0;
        while(compt<time) {
            compt += delay;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            Light.TurnOnRing(green, 1,idLaumio);
            Light.TurnOnColumn(green,1,idLaumio);
            Light.TurnOnColumn(green,2,idLaumio);
        }
        return true;
    }

    public static void plus(int time, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException {
        for (String s : idsLaumio) plus(time,delay,s);
    }


    public static boolean minus(int time, int delay, String idLaumio ) throws NameAlreadyUsedException {
        Color red=Color.create("Red",255,0,0);
        Light.TurnOffLumio(idLaumio);
        int compt = 0;
        while(compt<time) {
            compt += delay;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            Light.TurnOnRing(red, 1,idLaumio);
        }
        return true;
    }

    public static void minus(int time, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException {
        for (String s : idsLaumio) minus(time,delay,s);
    }


    public static boolean happy(int time, int delay, String idLaumio) throws NameAlreadyUsedException {
        Color green=Color.create("Green",0,255,0);
        Light.TurnOffLumio(idLaumio);
        int compt = 0;
        while(compt<time) {
            compt += delay;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            Light.TurnOffLumio(idLaumio);
            Light.TurnOnPixel(green,2,idLaumio);
            Light.TurnOnPixel(green,3,idLaumio);
            Light.TurnOnPixel(green,1,idLaumio);
            Light.TurnOnPixel(green,12,idLaumio);
            Light.TurnOnPixel(green,5,idLaumio);

        }
        return true;
    }

    public static void happy(int time, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException {
        for (String s : idsLaumio) happy(time,delay,s);
    }

    public static boolean sad(int time, int delay, String idLaumio) throws NameAlreadyUsedException {
        Light.TurnOffLumio(idLaumio);
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
            Light.TurnOffLumio(idLaumio);
            Light.TurnOnPixel(red,2,idLaumio);
            Light.TurnOnPixel(red,3,idLaumio);
            Light.TurnOnPixel(red,0,idLaumio);
            Light.TurnOnPixel(red,11,idLaumio);
            Light.TurnOnPixel(red,5,idLaumio);

        }
        return true;
    }

    public static void sad(int time, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException {
        for (String s : idsLaumio) sad(time,delay,s);
    }

    public static boolean sequence(Color c,int nb_led,int delay, String id_laumio) throws NameAlreadyUsedException {
        Light.TurnOffLumio(id_laumio);
        for(int compte=0;compte<nb_led;compte++) {
            Light.TurnOnPixel(c,compte,id_laumio);
            if(compte>1) {
                Light.TurnOffPixel(compte - 1, id_laumio);
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

}
