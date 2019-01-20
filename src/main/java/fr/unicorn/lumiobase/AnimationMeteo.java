package fr.unicorn.lumiobase;

import java.util.ArrayList;

public class AnimationMeteo {

    public static void rain(int delay, String idLaumio) throws NameAlreadyUsedException,InterruptedException  {
        Color blue=Color.create("Blue",0,0,255);
        Color grey=Color.create("Grey",47,79,79);
        Color white=Color.create("White",255,255,255);
        Light.TurnOffLumio(idLaumio);
        //sky
        Light.TurnOnAllLumio(grey, "all");
        //First step of rain
        Light.TurnOnPixel(blue,1,idLaumio);
        Thread.sleep(delay/2);
        Light.TurnOnPixel(blue,10,idLaumio);
        Thread.sleep(delay/2);
        Light.TurnOnPixel(blue,4,idLaumio);
        Thread.sleep(delay/2);
        Light.TurnOnPixel(blue,7,idLaumio);
        Thread.sleep(delay);

        //second step of rain
        Light.TurnOnPixel(blue,0,idLaumio);
        Thread.sleep(delay/2);
        Light.TurnOnPixel(blue,11,idLaumio);
        Thread.sleep(delay/2);
        Light.TurnOnPixel(blue,5,idLaumio);
        Thread.sleep(delay/2);
        Light.TurnOnPixel(blue,6,idLaumio);
        Thread.sleep(delay);

        //Erase bottom
        Light.TurnOnPixel(white,0,idLaumio);
        Thread.sleep(delay/2);
        Light.TurnOnPixel(white,11,idLaumio);
        Thread.sleep(delay/2);
        Light.TurnOnPixel(white,5,idLaumio);
        Thread.sleep(delay/2);
        Light.TurnOnPixel(white,6,idLaumio);

        //Erase middle
        Light.TurnOnPixel(white,1,idLaumio);
        Thread.sleep(delay/2);
        Light.TurnOnPixel(white,10,idLaumio);
        Thread.sleep(delay/2);
        Light.TurnOnPixel(white,4,idLaumio);
        Thread.sleep(delay/2);
        Light.TurnOnPixel(white,7,idLaumio);
    }

    public static void rain(int delay, ArrayList<String> idsLaumio) throws NameAlreadyUsedException, InterruptedException {
        for (String s : idsLaumio) rain(delay,s);
    }

    public static void sun(int time,int delay, String idLaumio) throws NameAlreadyUsedException,InterruptedException  {
        Color yellow=Color.create("Yellow",255,255,0);
        Animation.glow(yellow,time,delay,idLaumio);
    }
}
