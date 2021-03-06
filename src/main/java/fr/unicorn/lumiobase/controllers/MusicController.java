package fr.unicorn.lumiobase.controllers;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import fr.unicorn.lumiobase.models.*;


@Controller
public class MusicController {
    @Autowired
    MusicRepository musicRepository;

    @PostMapping("/functionsMusic")
    public String functions(@RequestBody String function, Model model) {
        return "greatAnswer";
    }

    @GetMapping("/musique")
    public String musique(Model model) {
        model.addAttribute("musique", new Music());
        return "musique";
    }

    @PostMapping("/toggle")
    public String toggleSubmit(@ModelAttribute Music music,Model model) throws MqttException {
        //model.addAttribute("toggle",music.playMusic())stopMusic();
        music.playMusic();

        return "success";
    }
   /* @PostMapping("/toggle")
    public void toggle(){
        System.out.print("n");
    }

    @RequestMapping(value="/processForm",params="next",method= RequestMethod.POST)
    public void next(){
        System.out.print("t");
    }

    @RequestMapping(value="/processForm",params="previous",method= RequestMethod.POST)
    public void previous(){
        System.out.print("l");
    }*/
}

