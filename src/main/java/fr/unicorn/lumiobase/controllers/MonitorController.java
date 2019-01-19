package fr.unicorn.lumiobase.controllers;

import fr.unicorn.lumiobase.SpringApp;
import fr.unicorn.lumiobase.models.Sensors.*;
import org.springframework.beans.factory.annotation.Autowired;
import fr.unicorn.lumiobase.sensors.remote.RemoteValues;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonitorController {

    @Autowired
    AbsHumidityRepository absHumidityRepository;
    DistanceRepository distanceRepository;
    HumidityRepository humidityRepository;
    PresenceRepository presenceRepository;
    PressureRepository pressureRepository;
    TemperatureRepository temperatureRepository;

    @GetMapping("/monitor")
    public String monitor(Model model) {
        model.addAttribute("temperature", SpringApp.temperatureHistory);
        model.addAttribute("pressure", SpringApp.pressureHistory);
        model.addAttribute("humidity", SpringApp.humidityHistory);
        model.addAttribute("abshumidity", SpringApp.abshumidityHistory);
        model.addAttribute("presence", SpringApp.presenceHistory);
        model.addAttribute("distance", SpringApp.distanceHistory);
        model.addAttribute("remote", RemoteValues.POWER.toString());
        return "monitor";
    }


}
