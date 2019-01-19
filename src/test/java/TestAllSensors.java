import fr.unicorn.lumiobase.Connections;
import fr.unicorn.lumiobase.sensors.*;
import fr.unicorn.lumiobase.sensors.remote.Remote;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class TestAllSensors {

    public static void main(String args[]) throws MqttException {
        IMqttClient client = Connections.connectPublisher();
       /* Remote.initRemote(client);
        Presence.initPresence(client);
        Athmospheric.initAtmospheric(client);
        Distance.initDistance(client);
        for (int i = 1; i < 5; i++) {
            CapteurPushButton.tappetCapteur(client,new Led(i,true), new PushButton(i));
        }*/
    }
}
