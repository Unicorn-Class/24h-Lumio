package fr.unicorn.lumiobase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoodController {

    @GetMapping("/mood")
    public String mood(Model model) {
        return "mood";
    }
}
