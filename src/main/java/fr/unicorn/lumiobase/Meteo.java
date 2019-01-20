package fr.unicorn.lumiobase;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.resource.HttpResource;

import java.text.ParseException;

public class Meteo {

    private String feel;
    private String description;
    private float temp;
    private int pressure;
    private int humidity;
    private float temp_min;
    private float temp_max;

    public String getFeel() {
        return feel;
    }

    public void setFeel(String feel) {
        this.feel = feel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public Meteo(String zip, String pays,String idLaumio) throws ParseException, UnirestException, NameAlreadyUsedException, InterruptedException {
        String key="6faae96326a861f899e0d72ad4d9210c";

        HttpResponse<JsonNode> resp= Unirest.get("http://api.openweathermap.org/data/2.5/weather?zip="+zip+","+pays+"&APPID="+key).asJson();
        JSONArray rs=resp.getBody().getObject().getJSONArray("weather");
        this.feel=rs.getJSONObject(0).getString("main").toLowerCase();
        JSONObject rs2=resp.getBody().getObject().getJSONObject("main");

        this.temp=rs2.getFloat("temp");
        this.pressure=rs2.getInt("pressure");
        this.humidity=rs2.getInt("humidity");
        this.temp_max=rs2.getFloat("temp_max");
        this.temp_min=rs2.getFloat("temp_min");
        if(this.feel.contains("rain")){
            System.out.println("rain");
            AnimationMeteo.rain(1500,idLaumio);

        }
        else if(this.feel.contains("clear")){
            System.out.println("clear");
            AnimationMeteo.sun(2500,500,idLaumio);
        }
        else {
            System.out.println("other");
            AnimationMeteo.cloud(2500,500, idLaumio);
        }
    }

    public Meteo(String zip, String pays) throws ParseException, UnirestException {
        String key="6faae96326a861f899e0d72ad4d9210c";

        HttpResponse<JsonNode> resp= Unirest.get("http://api.openweathermap.org/data/2.5/weather?zip="+zip+","+pays+"&APPID="+key).asJson();
        JSONArray rs=resp.getBody().getObject().getJSONArray("weather");
        this.feel=rs.getJSONObject(0).getString("main").toLowerCase();
        JSONObject rs2=resp.getBody().getObject().getJSONObject("main");

        this.temp=rs2.getFloat("temp");
        this.pressure=rs2.getInt("pressure");
        this.humidity=rs2.getInt("humidity");
        this.temp_max=rs2.getFloat("temp_max");
        this.temp_min=rs2.getFloat("temp_min");
    }

    public String toString(){
        return "Feel "+this.feel+"  " +
                "Temp "+this.temp+"    " +
                "Humidity "+this.humidity;
    }
    public static void main(String[] args){
        try {
            Meteo m=new Meteo("72000","fr");
            System.out.print(m);
            Meteo m2=new Meteo("90001","us");
            System.out.print(m2);
            Meteo m3=new Meteo("BN1","gb");
            System.out.print(m3);
        }catch (UnirestException e){

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
