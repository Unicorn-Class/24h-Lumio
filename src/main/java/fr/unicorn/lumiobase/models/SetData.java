package fr.unicorn.lumiobase.models;

import fr.unicorn.lumiobase.models.Sensors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Random;

@Controller
public class SetData {

    @Autowired
    static AbsHumidityRepository absHumidityRepository;
    @Autowired
    static DistanceRepository distanceRepository;
    @Autowired
    static HumidityRepository humidityRepository;
    @Autowired
    static PresenceRepository presenceRepository;
    @Autowired
    static PressureRepository pressureRepository;
    @Autowired
    static TemperatureRepository temperatureRepository;


    public static void setData() {
        Random r = new Random();
        for (int i=0; i<15; i++) {
/*            absHumidityRepository.save(new AbsHumidity(r.nextFloat()));
            distanceRepository.save(new Distance(r.nextFloat()));
            humidityRepository.save(new Humidity(r.nextFloat()));
            presenceRepository.save(new Presence(r.nextBoolean()));
            pressureRepository.save(new Pressure(r.nextFloat()));
            temperatureRepository.save(new Temperature(r.nextFloat()));*/
        }
    }
}
