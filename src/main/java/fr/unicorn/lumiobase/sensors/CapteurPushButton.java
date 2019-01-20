package fr.unicorn.lumiobase.sensors;

import fr.unicorn.lumiobase.Color;
import fr.unicorn.lumiobase.models.Buttons.LedState;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.Arrays;

public class CapteurPushButton {
    private IMqttClient client;

    private boolean online = false;


    private boolean[] buttonState;
    private boolean[] ledState;

    @Override
    public String toString() {
        return "CapteurPushButton{" +
                "buttonState=" + Arrays.toString(buttonState) +
                ", ledState=" + Arrays.toString(ledState) +
                '}';
    }

    public void tappetCapteur(IMqttClient client, int num) throws MqttException {

        client.subscribe("capteur_bp/status", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            online = (str == "online") ? true : false;
            System.out.println(str);
        });
        client.subscribe("capteur_bp/sensor/bp_rssi/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            System.out.println(str);
        });

        client.subscribe("capteur_bp/switch/led" + num + "/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            ledState[num] = (str == "ON") ? true : false;
            System.out.println(str);
        });

        client.subscribe("capteur_bp/binary_sensor/bp" + num + "/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            ledState[num] = (str == "ON") ? true : false;
            System.out.println(str);
        });
    }

    public boolean[] getButtonState() {
        return buttonState;
    }

    public boolean[] getLedState() {
        return ledState;
    }
}