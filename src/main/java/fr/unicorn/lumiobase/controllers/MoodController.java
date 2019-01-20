package fr.unicorn.lumiobase.controllers;

import fr.unicorn.lumiobase.demo.Mood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MoodController {
    @Autowired
    MoodRepository moodRepository;

    @GetMapping("/mood")
    public String mood(Model model) {
        model.addAttribute("mood", new Mood());
        return "mood";
    }

    @PostMapping("/addMood")
    public String greetingSubmit(@ModelAttribute Mood mood) {
        mood.setId(mood.id);
        mood.setId(mood.id);
        mood.setId(mood.id);
        System.out.println(mood);
        moodRepository.save(mood);
        return "success";
    }


}
