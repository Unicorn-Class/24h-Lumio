package fr.unicorn.lumiobase.controllers;

import com.mashape.unirest.http.exceptions.UnirestException;
import fr.unicorn.lumiobase.Meteo;
import fr.unicorn.lumiobase.NameAlreadyUsedException;
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

import java.text.ParseException;

@Controller
public class AddMeteoController {
    @GetMapping("/addMeteo")
    public String addMeteo(@ModelAttribute Location location, Model model) throws InterruptedException, NameAlreadyUsedException, UnirestException, ParseException {
        model.addAttribute("location", new Location());
        Meteo m=new Meteo(location.zip,location.country,"Laumio_88813D");
        return "meteo";
    }





}
