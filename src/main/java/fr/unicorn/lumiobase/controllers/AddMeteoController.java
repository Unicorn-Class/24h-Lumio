package fr.unicorn.lumiobase.controllers;

import fr.unicorn.lumiobase.demo.Mood;
import fr.unicorn.lumiobase.models.Location;
import fr.unicorn.lumiobase.models.MoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddMeteoController {
    @GetMapping("/addMeteo")
    public String addMeteo(@ModelAttribute Location location, Model model) {
        model.addAttribute("location", new Location());
        System.out.println("location.getCountry() = " + location.getCountry());
        return "meteo";
    }





}
