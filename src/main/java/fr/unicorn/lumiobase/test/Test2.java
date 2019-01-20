package fr.unicorn.lumiobase.test;

import fr.unicorn.lumiobase.Color;
import fr.unicorn.lumiobase.Connections;
import fr.unicorn.lumiobase.Light;
import fr.unicorn.lumiobase.NameAlreadyUsedException;
import fr.unicorn.lumiobase.sensors.CapteurPushButton;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test2 {
    private static Color red, yellow, blue, green;

    public static ArrayList<Color> generateSeq(int size){
        ArrayList<Color> seq=new ArrayList<Color>();
        for(int i=0;i<size;i++){
            Random rand = new Random();
            int nb = rand.nextInt( 4);
            System.out.println("nb = " + nb);
            switch (nb){
                case 0 :
                    seq.add(green);
                    break;
                case 1:
                    seq.add(yellow);
                    break;
                case 2:
                    seq.add(blue);
                    break;
                case 3:
                    seq.add(red);
                    break;
                default :
                    System.out.println("Erreur");
            }
        }
        return seq;
    }

    public static void main(String[] args) throws NameAlreadyUsedException, MqttException, InterruptedException {
        IMqttClient client = Connections.connectPublisher();
        CapteurPushButton res=new CapteurPushButton();
        for (int i = 1; i < 5; i++) {
            System.out.println("ok");
            res.tappetCapteur(client,i);
        }
        Scanner sc=new Scanner(System.in);
        int score=0;
        initColor();
        boolean cont=true;

        do{
            ArrayList<Color> seq= Test2.generateSeq(score+1);
            for (Color c : seq) {
                Light.TurnOnAllLumio(c, "Laumio_88813D");
                Thread.sleep(1000);
                Light.TurnOffLumio("Laumio_88813D");
                Thread.sleep(3000);
                System.out.println(c);
            }
            int i = 1;
            for (Color c : seq) {
                if(cont==true) {
                    System.out.println("Entrez la couleur " + i);
                    System.out.println(green.getName());
                    System.out.println(red.getName());
                    System.out.println(yellow.getName());
                    System.out.println(blue.getName());
                    String answer = sc.next();
                    System.out.println(res);
                    if (answer.contentEquals(c.getName()) == false) {
                        System.out.println("Raté la réponse était "+c.getName());
                        cont = false;
                    }
                }
                i++;
            }
            if(cont==true);
            score++;
        }while(cont==true);
        System.out.println("Votre score est "+score);
    }

    private static void initColor() throws NameAlreadyUsedException {
        red = Color.create("Red", 255,0,0);
        yellow = Color.create("Yellow", 255,255,0);;
        blue = Color.create("Blue", 0,0,255);
        green = Color.create("Green", 0,255,0);
    }
}
