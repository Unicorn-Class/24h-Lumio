package fr.unicorn.lumiobase.test;

import fr.unicorn.lumiobase.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class testNico {

    private static final Logger log = LogManager.getRootLogger();

    static Color c0;
    static Color c1;
    static Color c2;
    static Color c3;


    public static void main(String[] args) throws NameAlreadyUsedException, InterruptedException {
        c0 = Color.create("Noir", 0, 0, 0);
        c1 = Color.create("Rouge", 255, 0, 0);
        c2 = Color.create("Vert", 0, 255, 0);
        c3 = Color.create("Bleu", 0, 0, 255);

        test1();
        test2();
        test3();
        //test4();


    }

    public static void test1() throws NameAlreadyUsedException {

        //log.info("Data transmisssion finished !");



        log.fatal("=============");
        log.fatal(" TEST ELODIE");
        log.fatal("=============");

        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all", c0);
        log.fatal("\tPause de 1sec");
        Thread.sleep(1000);

        log.fatal("\tFull couleur " + c3.getName());
        Boubou.SendColorLumio(c3, "all");

        /*log.fatal("============");
        log.fatal(" TEST SENAM");
        log.fatal("============");

        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all");
        log.fatal("\tPause de 1sec");
        Thread.sleep(1000);

        log.fatal("\tAnneau 2 couleur "+c2.getName());
        Boubou.SendColorLumio(c3, "all");*/

    }
    public static void test2() throws NameAlreadyUsedException, InterruptedException {

        log.fatal("===========");
        log.fatal(" TEST NICO");
        log.fatal("===========");
/*
        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all", c0);
        log.fatal("\tPause de 1sec");
        Thread.sleep(1000);
*/

        log.fatal("\tEnvoi Couleur column 1" + c1.getName());
        ColorColumn.SendColorColumn(c1, 1);
/*
        log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all", c0);
        log.fatal("\tPause de 1sec");
        Thread.sleep(1000);
*/
        log.fatal("\tLueur" + c2.getName() + " pendant 5 sec");
        Animation.glow(c2, 5000, 50);
    }

    public static void test3() throws NameAlreadyUsedException, InterruptedException {
       /* log.fatal("\tEteindre");
        Boubou.TurnOffLumio("all",c0);
        log.fatal("\tPause de 1sec");
        Thread.sleep(1000);
*/
        log.fatal("\tRainbow");
        Animation.rainbow();


        log.fatal("==========");
        log.fatal(" FIN TEST");
        log.fatal("==========");

    }

    public static void test4(){


    }
}
