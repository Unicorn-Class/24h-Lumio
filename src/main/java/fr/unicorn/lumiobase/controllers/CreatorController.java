package fr.unicorn.lumiobase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreatorController {

    @GetMapping("/creator")
    public String creator(Model model) {
        return "creator";
    }

}
