package fr.unicorn.lumiobase.sensors;

import fr.unicorn.lumiobase.Connections;
import fr.unicorn.lumiobase.sensors.remote.Remote;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Lumio {
    private Distance distance;
    private Athmospheric ath;
    private CapteurPushButton capteurPushButton;
    private Remote remote;

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Athmospheric getAth() {
        return ath;
    }

    public void setAth(Athmospheric ath) {
        this.ath = ath;
    }

    public CapteurPushButton getCapteurPushButton() {
        return capteurPushButton;
    }

    public void setCapteurPushButton(CapteurPushButton capteurPushButton) {
        this.capteurPushButton = capteurPushButton;
    }

    public Remote getRemote() {
        return remote;
    }

    public void setRemote(Remote remote) {
        this.remote = remote;
    }

    public IMqttClient getClient() {
        return client;
    }

    public void setClient(IMqttClient client) {
        this.client = client;
    }

    IMqttClient client = Connections.connectPublisher();
    public Lumio() throws MqttException{
        this.distance=new Distance();
        this.ath=new Athmospheric();
        this.remote=new Remote();
        this.capteurPushButton=new CapteurPushButton();
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
