package fr.unicorn.lumiobase.demo;

import fr.unicorn.lumiobase.Animation;
import fr.unicorn.lumiobase.Color;
import fr.unicorn.lumiobase.NameAlreadyUsedException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mood implements Runnable {
    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long id;
    public String name ="";
    public int r, g,b;
    public String idBoule = "";


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.r = color.getR();
        this.g = color.getG();
        this.b = color.getB();
    }

    public String getIdBoule() {
        return idBoule;
    }

    public Mood(){
        super();
        try {
            r=255;
            g=255;
            b=255;
        }catch(Exception e){

        }
    }
    public Mood(String name, Color c){
        try {
            r=255;
            g=255;
            b=255;
        }catch(Exception e){

        }
        this.name =name;
        r = c.getR();
        g = c.getG();
        b = c.getB();
    }

    public Mood(String name, Color color, String id) {
        this.name = name;
        r = color.getR();
        g = color.getG();
        b = color.getB();
        this.idBoule = id;
    }

    public void setIdBoule(String id) {
        this.idBoule = id;
    }

    @Override
    public String toString() {
        return name;
    }

    public void heart(String id) throws NameAlreadyUsedException {
        Animation.heart(Color.create(id,r, g, b),8000, 7,id, 1,0,2,100,200, 2000, 1000);
    }

    @Override
    public void run() {
        System.out.println("Zy vas, j'ai commence");
        try {
            Animation.heart(Color.create(id+"",r, g, b),8000, 7,idBoule, 1,0,2,100,200, 2000, 1000);
        } catch (NameAlreadyUsedException e) {
            e.printStackTrace();
        }
    }
}
