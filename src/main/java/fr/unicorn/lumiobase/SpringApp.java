package fr.unicorn.lumiobase;

import fr.unicorn.lumiobase.sensors.Lumio;
import fr.unicorn.lumiobase.sensors.Presence;
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
        Lumio l = new Lumio();

        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                temperatureHistory.add(lumioSensors.getAth().temperature);
                pressureHistory.add(lumioSensors.getAth().pressure);
                humidityHistory.add(lumioSensors.getAth().humidity);
                abshumidityHistory.add(lumioSensors.getAth().absHumidity);
                distanceHistory.add(lumioSensors.getDistance().distance);
                presenceHistory.add(Presence.presence ? 1 : 0);
            }
        }, 0, 5, TimeUnit.MINUTES);
    }

}
