package fr.unicorn.lumiobase;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.sql.Time;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CapteurPushButton {
    private IMqttClient client;


    public void tappetCapteur(IMqttClient client,Led led, PushButton pb) throws MqttException {

        client.subscribe("capteur_bp/status", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
        });
        client.subscribe("capteur_bp/sensor/bp_rssi/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
        });

        client.subscribe("capteur_bp/sensor/uptime_sensor/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
        });

        client.subscribe("capteur_bp/status/advertise", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
        });

        client.subscribe("capteur_bp/switch/led"+led.getNum()+"/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
        });

        client.subscribe("capteur_bp/switch/bp"+pb.getNum()+"/command", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            led.setNum(pb.getNum());//change state of associated led
            String str = new String(payload);
            if(str.equals("ON")){led.changeState();}
        });

        client.subscribe("capteur_bp/switch/led"+led.getNum()+"/command", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);

        });
    }



}
