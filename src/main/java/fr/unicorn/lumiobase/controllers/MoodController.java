package fr.unicorn.lumiobase.controllers;

import fr.unicorn.lumiobase.NameAlreadyUsedException;
import fr.unicorn.lumiobase.demo.moodTest;
import fr.unicorn.lumiobase.models.MoodRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoodController {

    @Autowired
    MoodRepository moodRepository;

    @GetMapping("/mood")
    public String mood(Model model) {
        return "mood";
    }

    @PostMapping("/sendMood")
    public String sendMood(@RequestBody String json, Model model) {
        //(new JSONObject(json)).getString("idLumio");
        //(new JSONObject(json)).getString("mood");
        return "greatAnswer";
    }
}
