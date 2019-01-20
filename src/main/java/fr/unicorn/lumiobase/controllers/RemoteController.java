package fr.unicorn.lumiobase.controllers;

import fr.unicorn.lumiobase.NameAlreadyUsedException;
import fr.unicorn.lumiobase.demo.Test;
import fr.unicorn.lumiobase.demo.TestNico;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RemoteController {

    @GetMapping("/remote")
    public String remote(Model model) {
        return "remote";
    }
    @GetMapping("/launch1")
    public String launch1(Model model) throws NameAlreadyUsedException {
        Test.game();
        return "remote";
    }
    @GetMapping("/launch2")
    public String launch2(Model model) throws InterruptedException, NameAlreadyUsedException, MqttException {
        TestNico.game();
        return "remote";
    }
}
