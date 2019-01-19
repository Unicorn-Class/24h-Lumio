package fr.unicorn.lumiobase.sensors;

import fr.unicorn.lumiobase.models.Sensors.AbsHumidity;
import fr.unicorn.lumiobase.models.Sensors.Humidity;
import fr.unicorn.lumiobase.models.Sensors.Pressure;
import fr.unicorn.lumiobase.models.Sensors.Temperature;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Athmospheric {
    public boolean online = false;

    public void initAtmospheric(IMqttClient client) throws MqttException {
        client.subscribe("atmosphere/temperature", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (online) new Temperature(Float.parseFloat(str));
            System.out.println("temperature = " + str);
        });
        client.subscribe("atmosphere/pression", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (online) new Pressure(Float.parseFloat(str));
            System.out.println("pressure = " + str);
        });
        client.subscribe("atmosphere/humidite", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (online) new Humidity(Float.parseFloat(str));
            System.out.println("humidity = " + str);
        });
        client.subscribe("atmosphere/humidite_absolue", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (online) new AbsHumidity(Float.parseFloat(str));
            System.out.println("absHumidity = " + str);
        });
        client.subscribe("atmosphere/status", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            online = (str=="online") ? true : false;
            if (str.equals("online")) atmosphereStatus(true);
            else atmosphereStatus(false);
        });
    }

    public void atmosphereStatus(boolean state) {
        if (state) System.out.println("Presence : Online");
        else System.out.println("Presence : Offline");
    }
}
