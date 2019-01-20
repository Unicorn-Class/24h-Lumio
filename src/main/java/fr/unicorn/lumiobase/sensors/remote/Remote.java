package fr.unicorn.lumiobase.sensors.remote;

import fr.unicorn.lumiobase.demo.TestNico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.HashMap;
import java.util.Map;

public class Remote{

    private static final Logger log = LogManager.getRootLogger();

    private static Map<RemoteValues, Boolean> buttonState = new HashMap<RemoteValues, Boolean>();

    static {
        for (RemoteValues v : RemoteValues.values()) {
            buttonState.put(v, false);
        }
    }

    public void initRemote(IMqttClient client) throws MqttException {
        client.subscribe("remote/power/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.POWER, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.POWER);
        });
        client.subscribe("remote/mode/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.MODE, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.MODE);
        });
        client.subscribe("remote/mute/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.MUTE, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.MUTE);
        });
        client.subscribe("remote/playp/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.PLAYP, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.PLAYP);
        });
        client.subscribe("remote/prev/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.PREV, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.PREV);
        });
        client.subscribe("remote/next/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.NEXT, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.NEXT);
        });
        client.subscribe("remote/eq/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("ON")) btnPushed(RemoteValues.EQ);
        });
        client.subscribe("remote/minus/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("ON")) btnPushed(RemoteValues.MINUS);
        });
        client.subscribe("remote/plus/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.PLUS, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.PLUS);
        });
        client.subscribe("remote/chg/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.CHG, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.CHG);
        });
        client.subscribe("remote/u_sd/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.U_SD, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.U_SD);
        });
        client.subscribe("remote/0/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.NB_0, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.NB_0);
        });
        client.subscribe("remote/1/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.NB_1, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.NB_1);
        });
        client.subscribe("remote/2/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.NB_2, (str=="ON")? true:false);
            if (str.equals("ON")){
                btnPushed(RemoteValues.NB_2);
                System.out.println("DOWN !!");
                TestNico.move(2);
            }
        });
        client.subscribe("remote/3/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.NB_3, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.NB_3);
        });
        client.subscribe("remote/4/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("ON")){
                btnPushed(RemoteValues.NB_4);
                System.out.println("LEFT !!");
                TestNico.choix(4);
            }
        });
        client.subscribe("remote/5/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("ON")){
                btnPushed(RemoteValues.NB_5);
                System.out.println("OK !!");
                TestNico.move(5);
            }
        });
        client.subscribe("remote/6/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("ON")){
                btnPushed(RemoteValues.NB_6);
                System.out.println("RIGHT !!");
                TestNico.move(6);
            }
        });
        client.subscribe("remote/7/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.NB_7, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.NB_7);
        });
        client.subscribe("remote/8/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            if (str.equals("ON")) {
                btnPushed(RemoteValues.NB_8);
                System.out.println("UP !!");
                TestNico.move(8);
            }
        });
        client.subscribe("remote/9/state", (topic, msg) -> {
            byte[] payload = msg.getPayload();
            String str = new String(payload);
            buttonState.put(RemoteValues.NB_9, (str=="ON")? true:false);
            if (str.equals("ON")) btnPushed(RemoteValues.NB_9);
        });

    }

    public static void btnPushed(RemoteValues val) {
        System.out.println("BTN PUSHED : "+val.toString());
        switch (val) {

        }
    }

    public static Map<RemoteValues, Boolean> getButtonState() {
        return buttonState;
    }
}
