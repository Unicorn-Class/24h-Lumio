package fr.unicorn.lumiobase;

import fr.unicorn.lumiobase.models.SetData;
import fr.unicorn.lumiobase.sensors.Lumio;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringApp {

    public static Lumio lumioSensors;
    public static ArrayList<Float> temperatureHistory = new ArrayList<Float>();
    public static ArrayList<Float> pressureHistory = new ArrayList<Float>();
    public static ArrayList<Float> humidityHistory = new ArrayList<Float>();
    public static ArrayList<Float> abshumidityHistory = new ArrayList<Float>();
    public static ArrayList<Float> distanceHistory = new ArrayList<Float>();
    public static ArrayList<Integer> presenceHistory = new ArrayList<Integer>();

    public static void main(String args[]) throws MqttException {
        SpringApplication.run(SpringApp.class, args);
        SetData.setData();
       // Lumio l = new Lumio();
    }

}
