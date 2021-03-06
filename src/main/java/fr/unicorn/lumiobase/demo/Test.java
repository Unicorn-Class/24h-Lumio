package fr.unicorn.lumiobase.demo;

import fr.unicorn.lumiobase.Color;
import fr.unicorn.lumiobase.Light;
import fr.unicorn.lumiobase.NameAlreadyUsedException;
import fr.unicorn.lumiobase.ReadProperties;

import java.util.Scanner;

public class Test {
    private static String[][] gridId = new String[3][3];
    private static String idFinal = "";
    private static Color colorP[] = new Color[3];
    private static int[][] grid = new int[3][3];
    private static boolean end = false;
    private static int persW = 3;
    private static int pers = 1;
    private static int use = 0;


    public static void main(String[] args) throws NameAlreadyUsedException {
        game();
    }
    public static void game() throws NameAlreadyUsedException {
        init();

        Scanner sc = new Scanner(System.in);
        int x, y;
        do{
            do {
                System.out.println("Player " + pers);
                do {
                    System.out.println("Saisir x :");
                    x = sc.nextInt();
                }while(x<0 && x>2);
                do {
                    System.out.println("Saisir y :");
                    y = sc.nextInt();
                }while(y<0 || y>2);
            }while(verifTurn(x, y));

            changePers();

        }while(verifEnd());

       // Light.TurnOnAllLumio(colorP[persW-1],idFinal);
    }

    private static void display(int x, int y) {
       // Light.TurnOnAllLumio(colorP[pers-1],gridId[x][y]);
    }

    private static boolean verifTurn(int x, int y) {
        if(grid[x][y] == 0){
            grid[x][y] = pers;
            use++;
            System.out.println(use);
            display(x, y);
            return false;
        }else{
            System.out.println("Deja pris");
            return true;
        }
    }

    private static void changePers() {
        if(pers == 1){
            pers = 2;
       //     Light.TurnOnAllLumio(colorP[pers-1],idFinal);
        }else{
            pers = 1;
        //    Light.TurnOnAllLumio(colorP[pers-1],idFinal);
        }
    }

    private static boolean verifEnd() {
        if(same(grid[0][0], grid[0][1], grid[0][2])
                || same(grid[1][0], grid[1][1], grid[1][2])
                || same(grid[2][0], grid[2][1], grid[2][2])

                || same(grid[0][0], grid[1][0], grid[2][0])
                || same(grid[0][1], grid[1][1], grid[1][2])
                || same(grid[0][2], grid[1][2], grid[2][2])

                || same(grid[0][0], grid[1][1], grid[2][2])

                || use == 9
        ){
            System.out.println("END ! victory "+persW);
            return false;
        }
        return true;
    }

    private static boolean same(int i, int i1, int i2) {
        if(i==i1 && i2 == i1 && i != 0){
            persW = i;
            return true;
        }
        return false;
    }


    private static void init() throws NameAlreadyUsedException {


        Color white = Color.create("Empty", 165,165,165);
        colorP[0] = Color.create("Purple", 165,0,255);
        colorP[1] = Color.create("Green", 255,165,0);
        colorP[2] = white;



        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                grid[i][j] = 0;
            }
        }

        gridId[0][0] = ReadProperties.prop.getJSONArray("idLaumio").getString(0);
        gridId[0][1] = ReadProperties.prop.getJSONArray("idLaumio").getString(1);
        gridId[0][2] = ReadProperties.prop.getJSONArray("idLaumio").getString(4);

        gridId[1][0] = ReadProperties.prop.getJSONArray("idLaumio").getString(2);
        gridId[1][1] = ReadProperties.prop.getJSONArray("idLaumio").getString(5);//Ori 3, mais boule qui beug
        gridId[1][2] = ReadProperties.prop.getJSONArray("idLaumio").getString(6);

        gridId[2][0] = ReadProperties.prop.getJSONArray("idLaumio").getString(8);
        gridId[2][1] = ReadProperties.prop.getJSONArray("idLaumio").getString(7);
        gridId[2][2] = ReadProperties.prop.getJSONArray("idLaumio").getString(9);

        idFinal = ReadProperties.prop.getJSONArray("idLaumio").getString(10);

        Light.TurnOffLumio("all");

        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
         //       Light.TurnOnAllLumio(white,gridId[i][j]);
            }
        }


    }
}
