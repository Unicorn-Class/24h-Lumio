package fr.unicorn.lumiobase.controllers;

import fr.unicorn.lumiobase.NameAlreadyUsedException;
import fr.unicorn.lumiobase.demo.moodTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoodController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="nameGET", required=false, defaultValue="World") String nameGET, Model model) {
        model.addAttribute("nomTemplate", nameGET);
        try {
            moodTest.mood(nameGET,1);
        } catch (NameAlreadyUsedException e) {
            e.printStackTrace();
        }
        return "greeting";

    }
    @GetMapping("/mood")
    public String mood(Model model) {
        try {
            moodTest.mood(""+1,1);
        } catch (NameAlreadyUsedException e) {
            e.printStackTrace();
        }
        return "mood";
    }
}
