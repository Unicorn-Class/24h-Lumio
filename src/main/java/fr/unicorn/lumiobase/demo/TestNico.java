package fr.unicorn.lumiobase.demo;

import fr.unicorn.lumiobase.Color;
import fr.unicorn.lumiobase.Light;
import fr.unicorn.lumiobase.NameAlreadyUsedException;
import fr.unicorn.lumiobase.ReadProperties;
import fr.unicorn.lumiobase.sensors.Lumio;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestNico {

    private static String idFinal = "";
    private static Color colorP[] = new Color[2];
    private static Integer choix[] = new Integer[2];
    private static Integer score[] = new Integer[2];
    private static Color white;
    private static Color select;
    private static int tour;
    private static ArrayList<Color> gridC = new ArrayList<>();
    private static ArrayList<String> grid = new ArrayList<>();
    private static ArrayList<Boolean> gridF = new ArrayList<>();
    private static int cursor = 0;
    private static int pers = 0;

    private static boolean valid = false;

    public static void main(String[] args) throws NameAlreadyUsedException, InterruptedException, MqttException {
        init();
        initDisplay();
        Lumio l = new Lumio();
        int msg = 0;
        Scanner sc = new Scanner(System.in);


        do{
            System.out.println("Player "+(pers+1) +" ("+score[pers]+") :");
            for(tour=0 ; tour<2 ; tour++){

                do{
                    /**
                     * Pour saisie au clavier
                     */
                    //System.out.println("Choisir :");
                    //msg = sc.nextInt();
                    //choix(msg);
                    System.out.print("..");
                }while(!valid || (tour==1 && cursor==choix[0]));
                display();
                Thread.sleep(1000);
                valid = false;

                choix[tour] = cursor;
            }
            verif(choix);
            changePers();
        }while(end());
        System.out.println("Player "+(2) +" ("+score[1]+") :");
        System.out.println("Player "+(1) +" ("+score[0]+") :");

        displayEnd();
    }

    private static void displayEnd() {
        if(score[1] == score[0]){
            Light.TurnOnColumn(colorP[0],0,idFinal);
            Light.TurnOnColumn(colorP[0],2,idFinal);
            Light.TurnOnColumn(colorP[1],1,idFinal);
            Light.TurnOnColumn(colorP[1],3,idFinal);
        }else if(score[1]>score[0]){
            Light.TurnOnAllLumio(colorP[1], idFinal);
        }else{
            Light.TurnOnAllLumio(colorP[0], idFinal);
        }
    }


    private static void changePers() {
        if(pers == 1){
            pers = 0;
        }else{
            pers = 1;
        }
    }
    private static void verif(Integer[] tab) throws InterruptedException {
        if(!gridC.get(tab[0]).equals(gridC.get(tab[1]))){
            Thread.sleep(1000);
            hide(tab);
            System.out.println("Dommage");
        }else{
            System.out.println("Bravo");
            score[pers]++;
            gridF.set(tab[0], true);
            gridF.set(tab[1], true);
        }
    }

    private static void hide(Integer[] tab) {
        Light.TurnOnAllLumio(white,grid.get(tab[0]));
        Light.TurnOnAllLumio(white,grid.get(tab[1]));
    }

    private static void display() {
        System.out.println(gridC.get(cursor).getName());
        Light.TurnOnAllLumio(gridC.get(cursor),grid.get(cursor));
    }

    @Deprecated
    public static void choix(int msg) {
        if(msg==6 && cursor<grid.size()-1){
            hideCursor();
            cursor++;
            displayCursor();
        }
        if(msg==4 && cursor>0){
            hideCursor();
            cursor--;
            displayCursor();
        }
        if(msg == 5){
            valid = true;
        }
        System.out.println("Cursor : "+cursor);
    }

    private static void displayCursor() {
        Light.TurnOnRing(select,1, grid.get(cursor));
    }

    private static void hideCursor() {
        if((tour == 1 && choix[0] == cursor ) || gridF.get(cursor)){
            Light.TurnOnRing(gridC.get(cursor),1, grid.get(cursor));
        }else{
            Light.TurnOnRing(white,1, grid.get(cursor));
        }

    }

    private static void initDisplay() throws NameAlreadyUsedException, InterruptedException {
        Light.TurnOffLumio("all");
        Thread.sleep(500);
        Light.TurnOnAllLumio(white,grid);
    }

    private static boolean end() {
        for(Boolean b : gridF){
            if(!b){             //If il y en a un cache, alors ce n'est pas la fin
                return true;
            }
        }
        return false;
    }

    private static void init() throws NameAlreadyUsedException {

        score[0] = 0;
        score[1] = 0;

        white = Color.create("White", 165,165,165);
       // select = Color.create("Select", 200,200,165);
        select = Color.create("Select", 255,1,1);

        Color c1 = Color.create("Red", 255,0,0);
        Color c2 = Color.create("Yellow", 255,255,0);
        Color c3 = Color.create("Blue", 0,0,255);
        Color c4 = Color.create("Purple", 165,0,255);
        Color c5 = Color.create("Green", 0,255,0);

        idFinal = ReadProperties.prop.getJSONArray("idLaumio").getString(10);

        gridC.add(c1);
        gridC.add(c1);
        gridC.add(c2);
        gridC.add(c2);
        gridC.add(c3);
        gridC.add(c3);
        gridC.add(c4);
        gridC.add(c4);
        gridC.add(c5);
        gridC.add(c5);

        Collections.shuffle(gridC);



        colorP[0] = c4;
        colorP[1] = c5;

        for(int i=0 ; i<gridC.size() ; i++){
            grid.add(ReadProperties.prop.getJSONArray("idLaumio").getString(i));
            gridF.add(false);
        }


    }





    public static void move(int nb){
        hideCursor();
        if(nb == 5){
            valid= true;
        }
        switch(nb){
            case 8:
                switch (cursor){
                    case 0 :
                        cursor = 2;
                        break;
                    case 1 :
                        cursor = 3;
                        break;
                    case 2 :
                        cursor = 5;
                        break;
                    case 3 :
                        cursor = 6;
                        break;
                    case 4 :
                        cursor = 6;
                        break;
                    case 5 :
                        cursor = 7;
                        break;
                    case 6 :
                        cursor = 7;
                        break;
                    case 7 :
                        cursor = 8;
                        break;
                }
                break;
            case 2:
                switch (cursor){
                    case 2 :
                        cursor = 0;
                        break;
                    case 3 :
                        cursor = 1;
                        break;
                    case 4 :
                        cursor = 1;
                        break;
                    case 5 :
                        cursor = 2;
                        break;
                    case 6 :
                        cursor = 3;
                        break;
                    case 7 :
                        cursor = 5;
                        break;
                    case 8 :
                        cursor = 7;
                        break;
                    case 9 :
                        cursor = 7;
                        break;
                }
                break;
            case 4:
                switch (cursor){
                    case 1 :
                        cursor = 0;
                        break;
                    case 3 :
                        cursor = 2;
                        break;
                    case 4 :
                        cursor = 3;
                        break;
                    case 5 :
                        cursor = 8;
                        break;
                    case 6 :
                        cursor = 5;
                        break;
                    case 7 :
                        cursor = 8;
                        break;
                    case 9 :
                        cursor = 8;
                        break;
                }
                break;
            case 6:
                switch (cursor){
                    case 0 :
                        cursor = 1;
                        break;
                    case 2 :
                        cursor = 3;
                        break;
                    case 3 :
                        cursor = 4;
                        break;
                    case 5 :
                        cursor = 6;
                        break;
                    case 7 :
                        cursor = 9;
                        break;
                    case 8 :
                        cursor = 9;
                        break;
                }
                break;
            case 5 :
                valid = true;
                break;
        }
        displayCursor();
    }


}
