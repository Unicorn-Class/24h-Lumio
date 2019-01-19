package fr.unicorn.lumiobase.sensors;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class CapteurPushButton {
    private IMqttClient client;


    public static void tappetCapteur(IMqttClient client, Led led, PushButton pb) throws MqttException {

        client.subscribe("capteur_bp/status", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
            System.out.println(str);
        });
        client.subscribe("capteur_bp/sensor/bp_rssi/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
            System.out.println(str);
        });

        client.subscribe("capteur_bp/sensor/uptime_sensor/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
            System.out.println(str);
        });

        client.subscribe("capteur_bp/status/advertise", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
            System.out.println(str);
        });

        client.subscribe("capteur_bp/switch/led"+led.getNum()+"/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
            System.out.println(str);
        });

        client.subscribe("capteur_bp/switch/bp"+pb.getNum()+"/command", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            led.setNum(pb.getNum());//change state of associated led
            String str = new String(payload);
            System.out.println(str);
            if(str.equals("ON")){led.changeState();}
        });

        client.subscribe("capteur_bp/switch/led"+led.getNum()+"/command", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
            System.out.println(str);

        });
    }



}
