package fr.unicorn.lumiobase.controllers;

import fr.unicorn.lumiobase.Color;
import fr.unicorn.lumiobase.Light;
import fr.unicorn.lumiobase.NameAlreadyUsedException;
import fr.unicorn.lumiobase.ReadProperties;

public class Fonction {
    int duration =0;
    Color color;
    String fct="";
    int id=0;
    String nom = "";

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration*1000;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(String color) {
        try {
            this.color = Color.create(color,
                    Integer.valueOf( color.substring( 1, 3 ), 16 ),
                    Integer.valueOf( color.substring( 3, 5 ), 16 ),
                    Integer.valueOf( color.substring( 5, 7 ), 16 ));
        } catch (NameAlreadyUsedException e) {
            e.printStackTrace();
        }
    }

    public String getFct() {
        return fct;
    }

    public void setFct(String fct) {
        this.fct = fct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if(!nom.equals("All")){
            nom = ReadProperties.prop.getJSONArray("idLaumio").getString(Integer.parseInt(nom.split(" ")[1]));
        } else {
            nom = "all";
        }
        this.nom = nom;
    }


    public void execute() {
        switch (fct){
            case "fill" :
                Light.TurnOnAllLumio(color, nom);
                break;

            case "ring" :
                Light.TurnOnRing(color,id, nom);
                break;

            case "col" :
                Light.TurnOnColumn(color,id, nom);
                break;

            case "pixel" :
                Light.TurnOnPixel(color,id, nom);
                break;

        }

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Light.TurnOffLumio(nom);
        } catch (NameAlreadyUsedException e) {
            e.printStackTrace();
        }
    }
}
