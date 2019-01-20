package fr.unicorn.lumiobase.demo;

import com.mashape.unirest.http.exceptions.UnirestException;
import fr.unicorn.lumiobase.Meteo;
import fr.unicorn.lumiobase.NameAlreadyUsedException;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.text.ParseException;

public class DemoFinal {

    public static void main(String[] args) throws NameAlreadyUsedException, MqttException, InterruptedException {
        /**Musique**/

        /**Meteo**/

        Meteo m2;


        try {
            m2 = new Meteo("90001", "us");
            System.out.println(m2);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        /**Monitor**/

        /**Remote**/

        /**Mood**/


        /**Morpion**/
        Test.game();

        /**Memo**/
        TestNico.game();

        /**Animation Custom**/

    }
}
