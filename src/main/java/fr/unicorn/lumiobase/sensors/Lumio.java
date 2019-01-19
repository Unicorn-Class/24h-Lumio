package fr.unicorn.lumiobase.sensors;

import fr.unicorn.lumiobase.Connections;
import fr.unicorn.lumiobase.sensors.remote.Remote;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Lumio {
    public Distance distance;
    public Athmospheric ath;
    public CapteurPushButton capteurPushButton;
    public Remote remote;

    IMqttClient client = Connections.connectPublisher();
    public Lumio() throws MqttException{
        this.distance.initDistance(client);
        this.ath.initAtmospheric(client);
        this.remote.initRemote(client);
        for (int i = 1; i < 5; i++) {
            this.capteurPushButton.tappetCapteur(client, new Led(i, true), new PushButton(i));
        }
    }



    @Override
    public String toString() {
       return "Distance "+this.distance.distance+"\n" +
               "Temperature "+this.ath.temperature+"\n" +
               "Pressure "+this.ath.pressure+"\n" +
               "Humidity "+this.ath.humidity+"\n" +
               "AbsHumidity "+this.ath.absHumidity+"\n" +
               "";
    }
}
