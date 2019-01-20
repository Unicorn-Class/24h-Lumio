package fr.unicorn.lumiobase.controllers;

import fr.unicorn.lumiobase.models.Scenario.Scenario;
import fr.unicorn.lumiobase.models.Scenario.ScenarioRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {

    @Autowired
    ScenarioRepository screpo;

    @GetMapping("/player")
    public String player(Model model) {
        model.addAttribute("scenarios", screpo.findAll());
        return "player";
    }

    @GetMapping("/play")
    public String play(@RequestParam(name="id", required=true, defaultValue="1") long id, Model model) {
        Scenario sc = screpo.findById(id).get();
        JSONObject obj = new JSONObject(sc.getJson());
        JSONArray arr = obj.getJSONArray("scenario");
        for (int i = 0; i < arr.length(); i++)
        {
            System.out.println("OUT : "+arr.get(i).toString());
            JSONObject o = (JSONObject) arr.get(i);
            switch (o.getString("function")) {
                case "fill":
                    System.out.println("FILL !");
                    break;
            }
        }
        return "monitor";
    }
}
