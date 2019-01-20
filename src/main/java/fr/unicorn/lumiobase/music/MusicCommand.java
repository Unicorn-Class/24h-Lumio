package fr.unicorn.lumiobase.music;

import fr.unicorn.lumiobase.Connections;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

public class MusicCommand {
    private int vol;


    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public MusicCommand(int vol) throws MqttException{
        this.vol=vol;
        this.stopMusic();
        this.setVolMusic();
        this.playMusic();
        this.nextMusic();
        //this.previousMusic();
        //this.toggleMusic();
    }


    public boolean initMusic() throws MqttException {
        //System.out.println("Marche "+getVol());

        IMqttClient publisher = Connections.connectPublisher();

        byte[] payload = String.format(String.valueOf(getVol()))
                .getBytes();
        byte[] payload2=String.format("play").getBytes();
        byte[] payload3=String.format("stop").getBytes();
        byte[] payload4=String.format("pause").getBytes();
        MqttMessage message = new MqttMessage(payload);
        MqttMessage message2 = new MqttMessage(payload2);
        MqttMessage message3 = new MqttMessage(payload3);
        MqttMessage message4 = new MqttMessage(payload4);
        //message.setPayload(json.toString().getBytes());
        try {
            //
            //System.out


            publisher.publish("music/control/play",message2 );
            publisher.publish("music/control/pause",message4 );


        } catch (MqttException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void stopMusic()throws MqttException{
        IMqttClient publisher = Connections.connectPublisher();

        byte[] payload3=String.format("stop").getBytes();
        MqttMessage message3 = new MqttMessage(payload3);
        publisher.publish("music/control/stop",message3);
    }

    public void playMusic()throws MqttException{
        IMqttClient publisher = Connections.connectPublisher();

        byte[] payload3=String.format("play").getBytes();
        MqttMessage message2 = new MqttMessage(payload3);
        publisher.publish("music/control/play",message2 );
    }

    public void toggleMusic()throws MqttException{
        IMqttClient publisher = Connections.connectPublisher();

        byte[] payload3=String.format("toggle").getBytes();
        MqttMessage message2 = new MqttMessage(payload3);
        publisher.publish("music/control/toggle",message2 );
    }

    public void setVolMusic()throws MqttException{
        IMqttClient publisher = Connections.connectPublisher();

        byte[] payload = String.format(String.valueOf(getVol()))
                .getBytes();
        MqttMessage message2 = new MqttMessage(payload);
        publisher.publish("music/control/setvol",message2 );
    }

    public void pauseMusic()throws MqttException{
        IMqttClient publisher = Connections.connectPublisher();

        byte[] payload3=String.format("pause").getBytes();
        MqttMessage message2 = new MqttMessage(payload3);
        publisher.publish("music/control/pause",message2 );
    }


    public void previousMusic()throws MqttException{
        IMqttClient publisher = Connections.connectPublisher();

        byte[] payload3=String.format("next").getBytes();
        MqttMessage message2 = new MqttMessage(payload3);
        publisher.publish("music/control/previous",message2 );
    }

    public void nextMusic()throws MqttException{
        IMqttClient publisher = Connections.connectPublisher();

        byte[] payload3=String.format("previous").getBytes();
        MqttMessage message2 = new MqttMessage(payload3);
        publisher.publish("music/control/next",message2 );
    }
}
