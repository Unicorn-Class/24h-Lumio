package fr.unicorn.lumiobase.controllers;

import fr.unicorn.lumiobase.SpringApp;
import fr.unicorn.lumiobase.models.Sensors.*;
import org.springframework.beans.factory.annotation.Autowired;
import fr.unicorn.lumiobase.sensors.remote.RemoteValues;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
public class MonitorController {

    @Autowired
    AbsHumidityRepository absHumidityRepository;
    @Autowired
    DistanceRepository distanceRepository;
    @Autowired
    HumidityRepository humidityRepository;
    @Autowired
    PresenceRepository presenceRepository;
    @Autowired
    PressureRepository pressureRepository;
    @Autowired
    TemperatureRepository temperatureRepository;

    @GetMapping("/monitor")
    public String monitor(Model model) {

        Random r = new Random();
        for (int i=0; i<15; i++) {
            absHumidityRepository.save(new AbsHumidity(r.nextFloat()));
            distanceRepository.save(new Distance(r.nextFloat()));
            humidityRepository.save(new Humidity(r.nextFloat()));
            presenceRepository.save(new Presence(r.nextBoolean()));
            pressureRepository.save(new Pressure(r.nextFloat()));
            temperatureRepository.save(new Temperature(r.nextFloat()));
        }

        int i=1;
        List<AbsHumidity> absL = absHumidityRepository.findAll(new Sort(Sort.Direction.DESC, "date"));
        for (AbsHumidity ah : absL) {
            model.addAttribute("xAbsHum"+i, ""+ah.getDate().getHours()+":"+ah.getDate().getMinutes());
            model.addAttribute("yAbsHum"+i, ah.getValue());
            if ((i++) > 10) break;
        }
        i=1;
        List<Temperature> tempL = temperatureRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
        for (Temperature t : tempL) {
            model.addAttribute("xTemp"+i, ""+t.getDate().getHours()+":"+t.getDate().getMinutes());
            model.addAttribute("yTemp"+i, t.getValue());
            if ((i++) > 10) break;
        }
        i=1;
        List<Pressure> pressL = pressureRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
        for (Pressure p : pressL) {
            model.addAttribute("xPressure"+i, ""+p.getDate().getHours()+":"+p.getDate().getMinutes());
            model.addAttribute("yPressure"+i, p.getValue());
            if ((i++) > 10) break;
        }
        i=1;
        List<Humidity> humL = humidityRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
        for (Humidity h : humL) {
            model.addAttribute("xHum"+i, ""+h.getDate().getHours()+":"+h.getDate().getMinutes());
            model.addAttribute("yHum"+i, h.getValue());
            if ((i++) > 10) break;
        }
        i=1;
        List<Presence> presL = presenceRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
        for (Presence p : presL) {
            model.addAttribute("xPres"+i, ""+p.getDate().getHours()+":"+p.getDate().getMinutes());
            model.addAttribute("yPres"+i, (p.getValue())?1:0);
            System.out.println("p.getValue() = " + p.getValue());
            if ((i++) > 10) break;
        }
        i=1;
        List<Distance> distL = distanceRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
        for (Distance d : distL) {
            model.addAttribute("xDist"+i, ""+d.getDate().getHours()+":"+d.getDate().getMinutes());
            model.addAttribute("yDist"+i, d.getValue());
            if ((i++) > 10) break;
        }
        return "monitor";
    }


}
