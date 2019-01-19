package fr.unicorn.lumiobase.test;

import fr.unicorn.lumiobase.*;
import fr.unicorn.lumiobase.sensors.Led;
import fr.unicorn.lumiobase.sensors.Lumio;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

public class testNico {

    //private static String[] id = {"Laumio_0FC168","Laumio_10805F","Laumio_88813D","Laumio_104F03","Laumio_D454DB","Laumio_CD0522","Laumio_0FBFBF","Laumio_107DA8","Laumio_10508F","Laumio_1D9486","Laumio_104A13"};
    private static final Logger log = LogManager.getRootLogger();

   // static Color c0;
    static Color c1;
    static Color c2;
    static Color c3;
    static Color c4;


    public static void main(String[] args) throws NameAlreadyUsedException, InterruptedException, MqttException {
        //c0 = Color.create("Noir", 0, 0, 0);
        c1 = Color.create("Rouge", 255, 0, 0);
        c2 = Color.create("Vert", 0, 255, 0);
        c3 = Color.create("Bleu", 0, 0, 255);
        c4 = Color.create("Blanc", 255, 255, 255);


        log.fatal("============");
        log.fatal(" DEBUT NICO");
        log.fatal("============");
        //test1();
       // testLED();
        //testVictor();
        //testGlow();
        //t();
        //testIdLumio();
       // testVictor2();
       // testRing();
       // rainbow();

        log.fatal("Test Laumio");
        //testLumio();

       // DisplayLedForLaumio(c1,"Laumio_88813D");

        log.fatal("==========");
        log.fatal(" FIN TEST");
        log.fatal("==========");

    }

   /* private static void t() {
        System.out.println("\""+id[10-1]+"\"");
        System.out.println("\""+id[11-1]+"\"");
        System.out.println("\""+id[4-1]+"\"");
        System.out.println("\""+id[9-1]+"\"");
        System.out.println("\""+id[7-1]+"\"");
        System.out.println("\""+id[2-1]+"\"");
        System.out.println("\""+id[6-1]+"\"");
        System.out.println("\""+id[1-1]+"\"");
        System.out.println("\""+id[5-1]+"\"");
        System.out.println("\""+id[8-1]+"\"");
        System.out.println("\""+id[3-1]+"\"");
    }*/
    public static void DisplayLedForLaumio(Color c,String idLaumio) {
        IMqttClient publisher = Connections.connectPublisher();
        for (int i = 0; i < 13; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            JSONObject json = new JSONObject();
            json.put("command", "set_pixel");
            json.put("led", i);
            json.put("rgb", c.getRGB());
            MqttMessage message = new MqttMessage();
            message.setPayload(json.toString().getBytes());
            try {
                publisher.publish("laumio/"+idLaumio+"/json", message);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean rainbow(){

        IMqttClient publisher = Connections.connectPublisher();


        try {
            publisher.subscribe("laumio/status/advertise", (topic, msg) -> {
                byte[] payload = msg.getPayload();
                String str = new String(payload);
                System.out.println("NICOLAS ! = " + str);
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }

        JSONObject json = new JSONObject();
        json.put("command", "dis");
        MqttMessage message = new MqttMessage();
        message.setPayload(json.toString().getBytes());
        try {
            publisher.publish("laumio/all/name",message);
        } catch (MqttException e) {
            e.printStackTrace();
            return false;
        }
        return true;


    }
    private static void testIdLumio() throws InterruptedException {
        for(int i = 0 ; i<ReadProperties.prop.getJSONArray("idLaumio").length(); i++){
            System.out.println(i+" : "+ReadProperties.prop.getJSONArray("idLaumio").getString(i));
            Boubou.SendColorLumio(c3,ReadProperties.prop.getJSONArray("idLaumio").getString(i));
            Thread.sleep(500);
        }
    }

    private static void testGlow() throws NameAlreadyUsedException, InterruptedException {
       // log.fatal("\tEteindre");
        //Boubou.TurnOffLumio("all");

        log.fatal("\tLueur" + c2.getName() + " pendant 0.5 sec");
        Animation.glow(c3, 7000, 75,"Laumio_88813D");
    }

    private static void testRing() throws NameAlreadyUsedException, InterruptedException {
        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");

        log.fatal("\tAnimation arrow");
        ColorRing.sendColorRing(c3,1);

        log.fatal("\tPause de 0.5sec");
        Thread.sleep(500);
    }

    private static void testVictor2() throws NameAlreadyUsedException, InterruptedException {
        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");

        log.fatal("\tAnimation arrow");
        Animation.arrow(c1,  100, "all");

        log.fatal("\tPause de 0.5sec");
        Thread.sleep(500);
    }

    private static void testLumio() throws NameAlreadyUsedException, InterruptedException, MqttException {
        log.fatal("\tRecup info");
        Lumio l=new Lumio();
        System.out.println("l = " + l);
    }



    private static void testVictor() throws NameAlreadyUsedException, InterruptedException {

        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");

        log.fatal("\tAnimation arrow");
        Animation.arrow(c1,  50, "all");

        log.fatal("\tPause de 0.5sec");
        Thread.sleep(500);


        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");

        log.fatal("\tAnimation +");
        Animation.plus(2000, 50);

        log.fatal("\tPause de 0.5sec");
        Thread.sleep(500);


        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");

        log.fatal("\tAnimation -");
        Animation.minus(2000, 50);

        log.fatal("\tPause de 0.5sec");
        Thread.sleep(500);


        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");

        log.fatal("\tAnimation rain");
        Animation.rain(2000, 50, "all");

        log.fatal("\tPause de 0.5sec");
        Thread.sleep(500);


        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");

        log.fatal("\tAnimation happy");
        Animation.happy(2000, 50, "all");

        log.fatal("\tPause de 0.5sec");
        Thread.sleep(500);


        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");

        log.fatal("\tAnimation sad");
        Animation.sad(2000, 50, "all");

        log.fatal("\tPause de 0.5sec");
        Thread.sleep(500);
    }

    public static void test1() throws NameAlreadyUsedException, InterruptedException {

        //log.info("Data transmisssion finished !");



        log.fatal("=============");
        log.fatal(" TEST ELODIE");
        log.fatal("=============");

        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");
        log.fatal("\tPause de 1sec");
        Thread.sleep(1000);

        log.fatal("\tFull couleur " + c3.getName());
        Boubou.SendColorLumio(c3, "all");

        log.fatal("============");
        log.fatal(" TEST SENAM");
        log.fatal("============");

        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");
        log.fatal("\tPause de 1sec");
        Thread.sleep(1000);

        log.fatal("\tAnneau 1 couleur "+c2.getName());
        ColorRing.sendColorRing(c3, 1);


        log.fatal("===========");
        log.fatal(" TEST NICO");
        log.fatal("===========");

        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");
        log.fatal("\tPause de 1sec");
        Thread.sleep(1000);


        log.fatal("\tEnvoi Couleur column 1" + c1.getName());
        ColorColumn.SendColorColumn(c1, 1);

        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");
        log.fatal("\tPause de 1sec");
        Thread.sleep(1000);

        log.fatal("\tLueur" + c2.getName() + " pendant 5 sec");
        //Animation.glow(c2, 5000, 50);


     log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");
        log.fatal("\tPause de 1sec");
        Thread.sleep(1000);

        log.fatal("\tRainbow");
        Animation.rainbow();


    }

    public static void testLED() throws InterruptedException, NameAlreadyUsedException {
        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");
        log.fatal("\tPause de 1sec");
        Thread.sleep(1000);

        for(int i=0 ; i<13 ; i++){
            log.fatal("\tAllumage "+i);
            ColorPixel.SendColorPixel(c1, i, "all");

            log.fatal("...");
            Thread.sleep(250);

            log.fatal("Eteindre");
            Boubou.TurnOffLumio("all");
        }

    }
}
