import com.mashape.unirest.http.exceptions.UnirestException;
import fr.unicorn.lumiobase.AnimationMeteo;
import fr.unicorn.lumiobase.Meteo;
import fr.unicorn.lumiobase.NameAlreadyUsedException;

import java.text.ParseException;

public class TestAnimationMeteo {
    public static void main(String [] args) throws ParseException, UnirestException, NameAlreadyUsedException,InterruptedException {
        Meteo m=new Meteo("72000","fr");

        if(m.getFeel().equals("Sun")){
            AnimationMeteo.sun(2500,500,"Laumio_88813D");
        }
        else if(m.getFeel().equals("Clear")){

        }else if(m.getFeel().equals("Clouds")){

        }

    }
}
