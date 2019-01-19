package fr.unicorn.lumiobase.controllers;

import fr.unicorn.lumiobase.SpringApp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonitorController {

    @GetMapping("/monitor")
    public String monitor(Model model) {
        model.addAttribute("temperature", SpringApp.temperatureHistory);
        model.addAttribute("pressure", SpringApp.pressureHistory);
        model.addAttribute("humidity", SpringApp.humidityHistory);
        model.addAttribute("abshumidity", SpringApp.abshumidityHistory);
        model.addAttribute("presence", SpringApp.presenceHistory);
        model.addAttribute("distance", SpringApp.distanceHistory);
        return "monitor";
    }


}
