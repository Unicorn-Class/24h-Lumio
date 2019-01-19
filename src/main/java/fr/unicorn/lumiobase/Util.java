package fr.unicorn.lumiobase;

public class Util {

    public static int NB_LINE = 3;
    public static int NB_COLUMN = 4;
    private static String[][] idPixel = {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"}};
    private static String[] idColumn = {"0","1","2","3"};
    private static String[] idLine = {"0","1","2"};


    public static String getIdPixel(int line, int column){
        if(line>=0 && line<idLine.length && column>=0 && column<idColumn.length) {
            return idPixel[line][column];
        }
        return "";
    }
    public static String getIdLine(int line){
        if(line>=0 && line<idLine.length){
            return idLine[line];
        }
        return "";
    }
    public static String getIdColumn(int column){
        if(column>=0 && column<idColumn.length){
            return idColumn[column];
        }
        return "";
    }
}
