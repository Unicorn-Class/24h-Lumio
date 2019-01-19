package fr.unicorn.lumiobase;

public class Util {

    public static int getIdPixel(int line, int column){
        if(line>=0 && line<ReadProperties.prop.getJSONObject("lumio").getJSONArray("idLine").length() &&
                column>=0 && column<ReadProperties.prop.getJSONObject("lumio").getJSONArray("idColumn").length()) {
            return ReadProperties.prop.getJSONObject("lumio").getJSONArray("idPixel").getJSONArray(line).getInt(column);
        }
        return 0;
    }
    public static int getIdLine(int line){
        if(line>=0 && line<ReadProperties.prop.getJSONObject("lumio").getJSONArray("idLine").length()){
            return ReadProperties.prop.getJSONObject("lumio").getJSONArray("idLine").getInt(line);
        }
        return 0;
    }
    public static int getIdColumn(int column){
        if(column>=0 && column<ReadProperties.prop.getJSONObject("lumio").getJSONArray("idColumn").length()){
            return ReadProperties.prop.getJSONObject("lumio").getJSONArray("idColumn").getInt(column);
        }
        return 0;
    }
}
