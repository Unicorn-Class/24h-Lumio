package fr.unicorn.lumiobase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RemoteController {

    @GetMapping("/remote")
    public String remote(Model model) {
        return "remote";
    }
}
