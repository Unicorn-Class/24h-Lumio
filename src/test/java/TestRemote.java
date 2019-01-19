import fr.unicorn.lumiobase.sensors.remote.Remote;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import static fr.unicorn.lumiobase.Connections.connectPublisher;

public class TestRemote {

    public static void main(String args[]) throws MqttException {
        IMqttClient client = connectPublisher(true);
        Remote.initRemote(client);
        MqttMessage message = new MqttMessage();
        message.setPayload("ON".getBytes());
        try {
            client.publish("remote/1/state",message);
        } catch (MqttException e) {
            e.printStackTrace();
        }
        message.setPayload("OFF".getBytes());
        try {
            client.publish("remote/1/state",message);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

}
