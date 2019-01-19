package fr.unicorn.lumiobase.test;

import fr.unicorn.lumiobase.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class testNico {

    private static final Logger log = LogManager.getRootLogger();

   // static Color c0;
    static Color c1;
    static Color c2;
    static Color c3;


    public static void main(String[] args) throws NameAlreadyUsedException, InterruptedException {
        //c0 = Color.create("Noir", 0, 0, 0);
        c1 = Color.create("Rouge", 255, 0, 0);
        c2 = Color.create("Vert", 0, 255, 0);
        c3 = Color.create("Bleu", 0, 0, 255);


        log.fatal("============");
        log.fatal(" DEBUT NICO");
        log.fatal("============");
        test1();
        testLED();


        log.fatal("==========");
        log.fatal(" FIN TEST");
        log.fatal("==========");

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

        log.fatal("\tAnneau 2 couleur "+c2.getName());
        Boubou.SendColorLumio(c3, "all");


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
        Animation.glow(c2, 5000, 50);


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
