import fr.unicorn.lumiobase.Connections;
import fr.unicorn.lumiobase.music.MusicCommand;
import fr.unicorn.lumiobase.sensors.Lumio;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class TestMusic {
    public static void main(String args[]) throws MqttException {
        IMqttClient client = Connections.connectPublisher();

        MusicCommand musicCommand=new MusicCommand(90);
        //System.out.println(musicCommand.initMusic());
    }
}
