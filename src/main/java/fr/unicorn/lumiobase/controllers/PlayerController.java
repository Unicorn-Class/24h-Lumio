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
    public String player(@RequestParam(name="msg", required=false, defaultValue="0") long msg, Model model) {
        model.addAttribute("scenarios", screpo.findAll());
        if (msg == 1) model.addAttribute("msg","Scenario Launched :)");
        else model.addAttribute("msg","Please select a scenario ^^");
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

            Fonction f = new Fonction();

            f.setFct(o.getString("function"));
            f.setDuration(o.getInt("duration"));
            f.setColor(o.getString("color"));
            f.setId(o.getInt("id"));
            f.setNom(o.getString("title"));


            f.execute();
        }
        return (new PlayerController()).player(1, model);
    }
}
