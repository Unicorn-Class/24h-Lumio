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
            Boubou.SendColorLumio(color, idLaumio);

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

    public static void rain(int delay, String id_laumio) throws NameAlreadyUsedException,InterruptedException  {
        Color blue=Color.create("Blue",0,0,255);
        Color grey=Color.create("Blue",105,105,105);
        Color white=Color.create("White",255,255,255);
            Boubou.TurnOffLumio(id_laumio);
            //sky
            ColorRing.sendColorRing(grey, 2);
            //First step of rain
            ColorPixel.SendColorPixel(blue,1,id_laumio);
            Thread.sleep(delay/2);
            ColorPixel.SendColorPixel(blue,10,id_laumio);
            Thread.sleep(delay/2);
            ColorPixel.SendColorPixel(blue,4,id_laumio);
            Thread.sleep(delay/2);
            ColorPixel.SendColorPixel(blue,7,id_laumio);
            Thread.sleep(delay);

            //second step of rain
            ColorPixel.SendColorPixel(blue,0,id_laumio);
            Thread.sleep(delay/2);
            ColorPixel.SendColorPixel(blue,11,id_laumio);
            Thread.sleep(delay/2);
            ColorPixel.SendColorPixel(blue,5,id_laumio);
            Thread.sleep(delay/2);
            ColorPixel.SendColorPixel(blue,6,id_laumio);
            Thread.sleep(delay);

            //Erase bottom
            ColorPixel.SendColorPixel(white,0,id_laumio);
            Thread.sleep(delay/2);
            ColorPixel.SendColorPixel(white,11,id_laumio);
            Thread.sleep(delay/2);
            ColorPixel.SendColorPixel(white,5,id_laumio);
            Thread.sleep(delay/2);
            ColorPixel.SendColorPixel(white,6,id_laumio);

            //Erase middle
            ColorPixel.SendColorPixel(white,1,id_laumio);
            Thread.sleep(delay/2);
            ColorPixel.SendColorPixel(white,10,id_laumio);
            Thread.sleep(delay/2);
            ColorPixel.SendColorPixel(white,4,id_laumio);
            Thread.sleep(delay/2);
            ColorPixel.SendColorPixel(white,7,id_laumio);
    }

    public static void rain(int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException, InterruptedException {
        for (String s : idsLaumio) rain(delay,s);
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
            ColorPixel.SendColorPixel(green,2,id_laumio);
            ColorPixel.SendColorPixel(green,3,id_laumio);
            ColorPixel.SendColorPixel(green,1,id_laumio);
            ColorPixel.SendColorPixel(green,12,id_laumio);
            ColorPixel.SendColorPixel(green,5,id_laumio);

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
            ColorPixel.SendColorPixel(red,2,id_laumio);
            ColorPixel.SendColorPixel(red,3,id_laumio);
            ColorPixel.SendColorPixel(red,0,id_laumio);
            ColorPixel.SendColorPixel(red,11,id_laumio);
            ColorPixel.SendColorPixel(red,5,id_laumio);

        }
        return true;
    }

    public static void sad(int time, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException {
        for (String s : idsLaumio) sad(time,delay,s);
    }

    public static boolean sequence(Color c,int nb_led,int delay, String id_laumio) throws NameAlreadyUsedException {
        Boubou.TurnOffLumio(id_laumio);
        for(int compte=0;compte<nb_led;compte++) {
            ColorPixel.SendColorPixel(c,compte,id_laumio);
            if(compte>1) {
                ColorPixel.TurnOffLights(compte - 1, id_laumio);
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
