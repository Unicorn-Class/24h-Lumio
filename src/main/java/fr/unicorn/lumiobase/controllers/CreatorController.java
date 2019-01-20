package fr.unicorn.lumiobase.controllers;

import fr.unicorn.lumiobase.models.Scenario.Scenario;
import fr.unicorn.lumiobase.models.Scenario.ScenarioRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreatorController {

    @Autowired
    ScenarioRepository scenarioRepository;

    @GetMapping("/creator")
    public String creator(Model model) {
        return "scenarioCreate";
    }

    @PostMapping("/sendCreator")
    public String sendCreator(@RequestBody String json, Model model) {
        scenarioRepository.save(new Scenario(json));
        return "greatAnswer";
    }
}
