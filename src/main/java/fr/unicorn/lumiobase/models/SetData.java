package fr.unicorn.lumiobase.models;

import fr.unicorn.lumiobase.models.Sensors.*;

import java.util.Random;

public class SetData {
    public static void setData() {
        Random r = new Random();
        for (int i=0; i<15; i++) {
            new AbsHumidity(r.nextFloat());
            new Distance(r.nextFloat());
            new Humidity(r.nextFloat());
            new Presence(r.nextBoolean());
            new Pressure(r.nextFloat());
            new Temperature(r.nextFloat());
        }
    }
}
