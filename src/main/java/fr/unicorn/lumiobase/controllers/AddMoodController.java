package fr.unicorn.lumiobase.controllers;

import ch.qos.logback.core.net.SyslogOutputStream;
import fr.unicorn.lumiobase.Color;
import fr.unicorn.lumiobase.NameAlreadyUsedException;
import fr.unicorn.lumiobase.demo.Mood;
import fr.unicorn.lumiobase.demo.moodTest;
import fr.unicorn.lumiobase.models.MoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddMoodController {
    @Autowired
    MoodRepository moodRepository;

    @GetMapping("/add-mood")
    public String mood(Model model) {
        model.addAttribute("mood", new Mood());
        return "add-mood";
    }


    @PostMapping("/addMood")
    public String greetingSubmit(@ModelAttribute Mood mood) {
        mood.setIdBoule(mood.idBoule);
        mood.setName(mood.name);
        System.out.println(mood);
        moodRepository.save(mood);
        return "success";
    }


}
