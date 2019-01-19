package fr.unicorn.lumiobase;

import org.json.JSONObject;

import java.io.*;

public class ReadProperties {

    public static JSONObject prop;

    static {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("config.json"));
            String json = "";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                json += line;
            }
            prop = new JSONObject(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        System.out.println("prop.get(\"debug\") = " + prop.get("debug"));
        System.out.println("prop.getJSONObject(\"lumio\").get(\"NB_LINE\") = " + prop.getJSONObject("lumio").get("NB_LINE"));
        System.out.println("prop.getJSONObject(\"lumio\").get(\"idColumn\") = " + (int) prop.getJSONObject("lumio").getJSONArray("idColumn").getInt(0));
    }
}
