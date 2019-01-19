package fr.unicorn.lumiobase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonitorController {

    @GetMapping("/monitor")
    public String monitor(Model model) {
        return "monitor";
    }


}
