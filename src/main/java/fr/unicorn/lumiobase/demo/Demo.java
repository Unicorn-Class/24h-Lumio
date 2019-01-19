package fr.unicorn.lumiobase.demo;

import fr.unicorn.lumiobase.*;
import fr.unicorn.lumiobase.sensors.Lumio;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.ArrayList;

public class Demo {

    private static Color red, yellow, blue, purple, orange;
    private static ArrayList<ArrayList<String>> grp;

    public static void main(String[] args) throws NameAlreadyUsedException, InterruptedException, NameAlreadyUsedException, MqttException {
        initColor();
        initGroup();
/*
        shutdown();
        turnOnAllOneByOne(purple);
        shutdownAllGroup();
        turnOnOneGroup(0, orange);
        turnOnOneGroup(1, purple);
        turnOnOneGroup(2, orange);
        turnOnOneGroup(3, purple);
        turnOnOneGroup(4, red);
        glowOn(4, purple);
        */


        Lumio l=new Lumio();
        Color c = Color.create("myColor", 255,255,255);
        while(true){
            System.out.println(255-(int)(l.getDistance().distance*159));
            c.setR(255-(int)(l.getDistance().distance*159));
            c.setG(255-(int)(l.getDistance().distance*159));
            c.setB(255-(int)(l.getDistance().distance*159));
            Light.TurnOnAllLumio(c, grp.get(4).get(0));
            Thread.sleep(300);
        }

    }

    private static void glowOn(int id, Color color) throws NameAlreadyUsedException {
        Animation.glow(color, 7000, 100,grp.get(4).get(0));
    }

    private static void turnOnOneGroup(int i, Color color) throws InterruptedException {

        for(String id : grp.get(i)){
            Light.TurnOnAllLumio(color,id);
        }
        Thread.sleep(500);
    }


    private static void shutdownAllGroup() throws NameAlreadyUsedException, InterruptedException {
        for(ArrayList<String> list : grp){
            for(String id : list){
                Light.TurnOffLumio(id);
            }
            Thread.sleep(500);
        }

    }

    private static void turnOnAllOneByOne(Color color) throws InterruptedException {
        for(ArrayList<String> list : grp){
            for(String id : list){
                Light.TurnOnAllLumio(color, id);
                Thread.sleep(500);
            }
        }

    }

    private static void shutdown() throws NameAlreadyUsedException {

        Light.TurnOffLumio("all");
    }






    private static void initColor() throws NameAlreadyUsedException {
        red = Color.create("Red", 255,0,0);
        yellow = Color.create("Yellow", 255,255,0);
        orange = Color.create("Orange", 255,165,0);
        blue = Color.create("Blue", 0,0,255);
        purple = Color.create("Purple", 165,0,255);
    }

    private static void initGroup() {
        grp = new ArrayList<>();
        /*ArrayList<String> grp1 = new ArrayList<>();
        grp1.add(ReadProperties.prop.getJSONArray("idLaumio").getString(0));
        grp1.add(ReadProperties.prop.getJSONArray("idLaumio").getString(1));

        ArrayList<String> grp2 = new ArrayList<>();
        grp2.add(ReadProperties.prop.getJSONArray("idLaumio").getString(2));
        grp2.add(ReadProperties.prop.getJSONArray("idLaumio").getString(3));
        grp2.add(ReadProperties.prop.getJSONArray("idLaumio").getString(4));

        ArrayList<String> grp3 = new ArrayList<>();
        grp3.add(ReadProperties.prop.getJSONArray("idLaumio").getString(5));
        grp3.add(ReadProperties.prop.getJSONArray("idLaumio").getString(6));

        ArrayList<String> grp4 = new ArrayList<>();
        grp4.add(ReadProperties.prop.getJSONArray("idLaumio").getString(7));
        grp4.add(ReadProperties.prop.getJSONArray("idLaumio").getString(8));
        grp4.add(ReadProperties.prop.getJSONArray("idLaumio").getString(9));

        ArrayList<String> grp5 = new ArrayList<>();
        grp5.add(ReadProperties.prop.getJSONArray("idLaumio").getString(10));

        grp.add(grp1);
        grp.add(grp2);
        grp.add(grp3);
        grp.add(grp4);
        grp.add(grp5);
        */

        grp.add(new ArrayList<String>() {{add(ReadProperties.prop.getJSONArray("idLaumio").getString(0));
            add(ReadProperties.prop.getJSONArray("idLaumio").getString(1));}});

        grp.add(new ArrayList<String>() {{add(ReadProperties.prop.getJSONArray("idLaumio").getString(2));
            add(ReadProperties.prop.getJSONArray("idLaumio").getString(3));
            add(ReadProperties.prop.getJSONArray("idLaumio").getString(4));}});

        grp.add(new ArrayList<String>() {{add(ReadProperties.prop.getJSONArray("idLaumio").getString(5));
            add(ReadProperties.prop.getJSONArray("idLaumio").getString(6));}});

        grp.add(new ArrayList<String>() {{add(ReadProperties.prop.getJSONArray("idLaumio").getString(7));
            add(ReadProperties.prop.getJSONArray("idLaumio").getString(8));
            add(ReadProperties.prop.getJSONArray("idLaumio").getString(9));}});

        grp.add(new ArrayList<String>() {{add(ReadProperties.prop.getJSONArray("idLaumio").getString(10));}});

    }


}