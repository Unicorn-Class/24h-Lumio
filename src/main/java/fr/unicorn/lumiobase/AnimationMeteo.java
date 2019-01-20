package fr.unicorn.lumiobase;

import java.util.ArrayList;

public class AnimationMeteo {

    public static void rain(int delay, String idLaumio) throws NameAlreadyUsedException,InterruptedException  {
        Color blue=Color.create("Blue",0,0,200);
        Color grey=Color.create("grey",30,30,30);
        Color white=Color.create("White",248,248,255);
        Light.TurnOffLumio(idLaumio);
        //sky
        Light.TurnOnAllLumio(grey, "all");
        //First step of rain
        Light.TurnOnPixel(blue,1,idLaumio);
        Thread.sleep(delay/4);
        Light.TurnOnPixel(blue,10,idLaumio);
        Thread.sleep(delay/4);
        Light.TurnOnPixel(blue,4,idLaumio);
        Thread.sleep(delay/4);
        Light.TurnOnPixel(blue,7,idLaumio);
        Thread.sleep(delay);

        //second step of rain
        Light.TurnOnPixel(blue,0,idLaumio);
        Thread.sleep(delay/4);
        Light.TurnOnPixel(blue,11,idLaumio);
        Thread.sleep(delay/4);
        Light.TurnOnPixel(blue,5,idLaumio);
        Thread.sleep(delay/4);
        Light.TurnOnPixel(blue,6,idLaumio);
        Thread.sleep(delay);
    }

    public static void rain(int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException, InterruptedException {
        for (String s : idsLaumio) rain(delay,s);
    }

    public static void sun(int time,int delay, String idLaumio) throws NameAlreadyUsedException,InterruptedException  {
        Color yellow=Color.create("Yellow",255,255,0);
        Animation.glowReduce(yellow,time,delay,idLaumio);
    }

    public static void cloud(int time,int delay, String idLaumio) throws NameAlreadyUsedException,InterruptedException {
        Light.TurnOffLumio(idLaumio);
        Color grey=Color.create("grey",20,20,20);
        Animation.glow(grey,time,delay,idLaumio);
    }


}
