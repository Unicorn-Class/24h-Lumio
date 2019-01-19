package fr.unicorn.lumiobase;

public class Main {

    public static void main(String args[]) throws NameAlreadyUsedException {

        System.out.println("Hello World !");
        Animation.colorWipe(Color.create("Blue", 0,255,0),250);
        System.out.println("Signal send");
    }

}
