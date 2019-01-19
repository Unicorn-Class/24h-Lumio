package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.UUID;

public class Connections {

    public static IMqttClient connectPublisher(boolean debug) {
        String publisherId = UUID.randomUUID().toString();
        IMqttClient publisher = null;
        try {
            if (!debug) publisher = new MqttClient("tcp://mpd.lan:1883",publisherId);
            else publisher = new MqttClient("tcp://192.168.43.35:1883",publisherId);
        } catch (MqttException e) {
            e.printStackTrace();
        }
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        try {
            publisher.connect(options);
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return publisher;
    }

    public static void disconnect(IMqttClient client){
        try {
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
