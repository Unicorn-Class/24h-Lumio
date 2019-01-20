package fr.unicorn.lumiobase.models;

import fr.unicorn.lumiobase.Connections;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {

     @Id
     private int id;
     private int vol;

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }


     public int getVol() {
            return vol;
        }

     public void setVol(int vol) {
            this.vol = vol;
        }

        public Music(int vol) throws MqttException{
            this.vol=vol;
            this.stopMusic();
            this.setVolMusic();
            this.playMusic();
            //this.nextMusic();
            //this.previousMusic();
            this.toggleMusic();
        }
        public Music(){

        }
    public void stopMusic()throws MqttException {
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
