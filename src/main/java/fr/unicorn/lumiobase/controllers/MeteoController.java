package fr.unicorn.lumiobase.controllers;

import fr.unicorn.lumiobase.models.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MeteoController {
    @GetMapping("/meteo")
    public String meteo(Model model) {
        model.addAttribute("location", new Location());
        return "meteo";
    }
}
