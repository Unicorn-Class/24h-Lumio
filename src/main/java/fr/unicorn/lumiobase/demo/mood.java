package fr.unicorn.lumiobase.demo;

import fr.unicorn.lumiobase.*;

public class mood {

    public static void main(String[] args) throws NameAlreadyUsedException {
        Light.TurnOffLumio(ReadProperties.prop.getJSONArray("idLaumio").getString(10));
        System.out.println("start");
        glow();
    }


    private static void glow() throws NameAlreadyUsedException {
        String str = ReadProperties.prop.getJSONArray("idLaumio").getString(10);
        Animation.glow(Color.create("Purple",165,0,255),8000, 7,str, 1,0,2,100,200);
    }

}