package fr.unicorn.lumiobase;

public class Util {

    public static int NB_LINE = 3;
    public static int NB_COLUMN = 4;
    private static int[][] idPixel = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    private static int[] idColumn = {0,1,2,3};
    private static int[] idLine = {0,1,2};

    public static boolean DEBUG = false;


    public static int getIdPixel(int line, int column){
        if(line>=0 && line<idLine.length && column>=0 && column<idColumn.length) {
            return idPixel[line][column];
        }
        return 0;
    }
    public static int getIdLine(int line){
        if(line>=0 && line<idLine.length){
            return idLine[line];
        }
        return 0;
    }
    public static int getIdColumn(int column){
        if(column>=0 && column<idColumn.length){
            return idColumn[column];
        }
        return 0;
    }
}
