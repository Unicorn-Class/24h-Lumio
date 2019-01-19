package fr.unicorn.lumiobase.music;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MusicCommand {
    private int vol;
    private boolean toggle=true;//play ou pause
    private int etat;// si next = -1, previous=-1, stop=0

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public MusicCommand(int vol,boolean toggle,int etat){
        this.etat=etat;
        this.toggle=toggle;
        this.vol=vol;
    }


    public void initMusic(MqttClient client) throws MqttException {
        client.subscribe("music/control/getstate", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
            System.out.println(str);
        });

        client.subscribe("music/control/getvol", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
            System.out.println(str);
        });

        client.subscribe("music/control/previous", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
            System.out.println(str);
        });

        client.subscribe("music/control/stop", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
            System.out.println(str);
        });

        client.subscribe("music/control/play", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
            System.out.println(str);
        });

        client.subscribe("music/control/pause", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
            System.out.println(str);
        });

        client.subscribe("music/control/toggle", (topic, msg) -> {
            byte[] payload = msg.getPayload();

            String str = new String(payload);
            System.out.println(str);
        });


    }
}
