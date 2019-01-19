package fr.unicorn.lumiobase;

import java.util.UUID;

public class ColorRing {
    public void sendColorRing(Color color, int ring){
        IMqttClient publisher = Connections.connectPublisher(true);

        JSONObject json = new JSONObject();
        json.put("command", "set_ring");
        json.put("ring", ring);
        json.put("rgb",c.getRGB());
        MqttMessage message = new MqttMessage();
        message.setPayload(json.toString().getBytes());
        try {
            publisher.publish("laumio/all/json",message);
        } catch (MqttException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
