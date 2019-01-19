package fr.unicorn.lumiobase.test;

import fr.unicorn.lumiobase.*;

public class testNico {

    public static void main(String[] args) throws NameAlreadyUsedException, InterruptedException {
        //log.info("Data transmisssion finished !");

        Color c1 = Color.create("Rouge", 255,0,0);
        Color c2 = Color.create("Vert", 0,255,0);
        Color c3 = Color.create("Bleu", 0,0,255);


        System.out.println("=============");
        System.out.println(" TEST ELODIE");
        System.out.println("=============");

        System.out.println("\tEteindre");
        Boubou.TurnOffLumio("all");
        System.out.println("\tPause de 1sec");
        Thread.sleep(1000);

        System.out.println("\tFull couleur "+c3.getName());
        Boubou.SendColorLumio(c3, "all");

        /*System.out.println("============");
        System.out.println(" TEST SENAM");
        System.out.println("============");

        System.out.println("\tEteindre");
        Boubou.TurnOffLumio("all");
        System.out.println("\tPause de 1sec");
        Thread.sleep(1000);

        System.out.println("\tAnneau 2 couleur "+c2.getName());
        Boubou.SendColorLumio(c3, "all");*/



        System.out.println("===========");
        System.out.println(" TEST NICO");
        System.out.println("===========");

        System.out.println("\tEteindre");
        Boubou.TurnOffLumio("all");
        System.out.println("\tPause de 1sec");
        Thread.sleep(1000);


        System.out.println("\tEnvoi Couleur column 1"+c1.getName());
        ColorColumn.SendColorColumn(c1, 1);

        System.out.println("\tEteindre");
        Boubou.TurnOffLumio("all");
        System.out.println("\tPause de 1sec");
        Thread.sleep(1000);

        System.out.println("\tLueur"+c2.getName()+" pendant 5 sec");
        Animation.glow(c2, 5000, 50);

        System.out.println("\tEteindre");
        Boubou.TurnOffLumio("all");
        System.out.println("\tPause de 1sec");
        Thread.sleep(1000);

        System.out.println("\tRainbow");
        Animation.rainbow();


        System.out.println("==========");
        System.out.println(" FIN TEST");
        System.out.println("==========");

    }
}
