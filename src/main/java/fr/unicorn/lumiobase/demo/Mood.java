package fr.unicorn.lumiobase.demo;

import fr.unicorn.lumiobase.Animation;
import fr.unicorn.lumiobase.Color;
import fr.unicorn.lumiobase.NameAlreadyUsedException;

public class Mood implements Runnable {
    String name ="";
    Color color;
    String id = "";

    public Mood(String name, Color c){
        try {
            color = Color.create("test", 255, 255, 255);
        }catch(Exception e){

        }
        this.name =name;
        color = c;
    }

    public Mood(String name, Color color, String id) {
        this.name = name;
        this.color = color;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    public void heart(String id) throws NameAlreadyUsedException {
        Animation.heart(color,8000, 7,id, 1,0,2,100,200, 2000, 1000);
    }

    @Override
    public void run() {
        System.out.println("Zy vas, j'ai commence");
        try {
            Animation.heart(color,8000, 7,id, 1,0,2,100,200, 2000, 1000);
        } catch (NameAlreadyUsedException e) {
            e.printStackTrace();
        }
    }
}
