package fr.unicorn.lumiobase.demo;

import fr.unicorn.lumiobase.*;

        import java.util.ArrayList;
        import java.util.Scanner;

public class moodTest {

    private static ArrayList<String> users = new ArrayList<>();
    private static ArrayList<String> id = new ArrayList<>();
    private static ArrayList<Mood> moods = new ArrayList<>();

    public static void main(String[] args) throws NameAlreadyUsedException {
        mood();
    }
    public static void mood() throws NameAlreadyUsedException {
        init();
        Scanner sc = new Scanner(System.in);
        for(int j=0 ; j<4 ; j++) {
            for (String str : users) {
                System.out.println("\t" + str);
            }
            System.out.println("Selectionner un user : ");
            String lampId = id.get(users.indexOf(sc.nextLine()));

            System.out.println(lampId);
            for (int i = 0; i < moods.size(); i++) {
                System.out.println(i + "\t" + moods.get(i));
            }
            Light.TurnOffLumio(lampId);
            System.out.println("Selectionner un mood : ");
            int value = sc.nextInt();
            System.out.println("1");
            moods.get(value).setIdBoule(lampId);
            Mood m = moods.get(value);

            System.out.println("2");
            //Thread t = new Thread(new Mood(m.name, Color.create("j",m.r,m.g,m.b), m.idBoule));
            System.out.println("3");
            //t.run();
            m.heart(lampId);
            System.out.println("4");

        }


        /*
        Light.TurnOffLumio(ReadProperties.prop.getJSONArray("idLaumio").getString(8));
        System.out.println("start");
        glow();*/
    }
    public static void mood(String lampId, int value) throws NameAlreadyUsedException {
        init();
        Scanner sc = new Scanner(System.in);
        for(int j=0 ; j<4 ; j++) {

            Light.TurnOffLumio(lampId);

            moods.get(value).setIdBoule(lampId);
            Mood m = moods.get(value);
            m.heart(lampId);

        }


        /*
        Light.TurnOffLumio(ReadProperties.prop.getJSONArray("idLaumio").getString(8));
        System.out.println("start");
        glow();*/
    }

    private static void init() throws NameAlreadyUsedException {
        users.add("Nicolas");
        id.add(ReadProperties.prop.getJSONArray("idLaumio").getString(10));
        users.add("Victor");
        id.add(ReadProperties.prop.getJSONArray("idLaumio").getString(0));
        users.add("Senam");
        id.add(ReadProperties.prop.getJSONArray("idLaumio").getString(1));
        users.add("TiMout");
        id.add(ReadProperties.prop.getJSONArray("idLaumio").getString(2));
        users.add("Somni");
        id.add(ReadProperties.prop.getJSONArray("idLaumio").getString(3));

        moods.add(new Mood("Happy", Color.create("Blue", 0,255,0)));
        moods.add(new Mood("Sad", Color.create("Red", 255,0,0)));
        moods.add(new Mood("Think", Color.create("Purple", 165,0,255)));
        moods.add(new Mood("Out", Color.create("Black", 0,0,0)));


    }


    private static void glow() throws NameAlreadyUsedException {
        String str = ReadProperties.prop.getJSONArray("idLaumio").getString(8);
        Animation.heart(Color.create("Purple",165,0,255),8000, 7,str, 1,0,2,100,200, 5000, 1000);
    }

}