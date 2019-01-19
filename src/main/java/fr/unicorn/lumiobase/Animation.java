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

    public static boolean arrow(Color color, int delay, String id_laumio) throws NameAlreadyUsedException {
        int pix1=6;
        int pix2=0;
        int pix3=12;
        while(pix2!=3){
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            Boubou.TurnOffLumio(id_laumio);
            ColorPixel.SendColorPixel(color,pix1,id_laumio);
            ColorPixel.SendColorPixel(color,pix2,id_laumio);
            ColorPixel.SendColorPixel(color,pix3,id_laumio);
            pix1++;
            pix2++;
            pix3--;
        }
        return true;
    }
    public static void arrow(Color color, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException {
        for (String s : idsLaumio) arrow(color,delay,s);
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

    public static boolean rain(int time, int delay, String id_laumio) throws NameAlreadyUsedException,InterruptedException  {
        Color blue=Color.create("Blue",0,0,255);
        Color white=Color.create("Blue",255,255,255);
        int compt = 0;
        while(compt<time) {
            compt += delay;
            Boubou.TurnOffLumio(id_laumio);
            ColorRing.sendColorRing(white, 2);
            ColorRing.sendColorRing(blue, 1);
            Thread.sleep(delay);
            ColorRing.sendColorRing(blue, 0);
            Thread.sleep(delay);
            ColorRing.sendColorRing(white,0);
            Thread.sleep(delay);
            ColorRing.sendColorRing(white,1);
        }
        return true;
    }

    public static void rain(int time, int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException, InterruptedException {
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
