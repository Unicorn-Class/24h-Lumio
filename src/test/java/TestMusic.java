import fr.unicorn.lumiobase.Connections;
import fr.unicorn.lumiobase.music.MusicCommand;
import fr.unicorn.lumiobase.sensors.Lumio;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class TestMusic {
    public static void main(String args[]) throws MqttException {
        IMqttClient client = Connections.connectPublisher();

        MusicCommand musicCommand=new MusicCommand(2,true,1);
        musicCommand.initMusic(client);
       /* Remote.initRemote(client);
        Presence.initPresence(client);
        Athmospheric.initAtmospheric(client);
        Distance.initDistance(client);
        for (int i = 1; i < 5; i++) {
            CapteurPushButton.tappetCapteur(client,new Led(i,true), new PushButton(i));
        }*/
    }
}
