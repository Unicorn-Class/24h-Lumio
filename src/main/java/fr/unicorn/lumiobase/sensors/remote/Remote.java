package fr.unicorn.lumiobase.sensors.remote;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Remote{

    private static final Logger log = LogManager.getRootLogger();

    public static void initRemote(IMqttClient client) throws MqttException {
        client.subscribe("remote/power/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.POWER);
        });
        client.subscribe("remote/mode/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.MODE);
        });
        client.subscribe("remote/mute/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.MUTE);
        });
        client.subscribe("remote/playp/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.PLAYP);
        });
        client.subscribe("remote/prev/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.PREV);
        });
        client.subscribe("remote/next/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.NEXT);
        });
        client.subscribe("remote/eq/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.EQ);
        });
        client.subscribe("remote/minus/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.MINUS);
        });
        client.subscribe("remote/plus/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.PLUS);
        });
        client.subscribe("remote/chg/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.CHG);
        });
        client.subscribe("remote/u_sd/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.U_SD);
        });
        client.subscribe("remote/0/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.NB_0);
        });
        client.subscribe("remote/1/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.NB_1);
        });
        client.subscribe("remote/2/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.NB_2);
        });
        client.subscribe("remote/3/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.NB_3);
        });
        client.subscribe("remote/4/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.NB_4);
        });
        client.subscribe("remote/5/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.NB_5);
        });
        client.subscribe("remote/6/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.NB_6);
        });
        client.subscribe("remote/7/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.NB_7);
        });
        client.subscribe("remote/8/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.NB_8);
        });
        client.subscribe("remote/9/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("true")) btnPushed(RemoteValues.NB_9);
        });

    }

    public static void btnPushed(RemoteValues val) {
        log.info("BTN PUSHED : "+val.toString());
        switch (val) {

        }
    }

}
