package com.example.firstproject.conttroller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String nicetomeetyou(Model model){
        model.addAttribute("username", "Chris");
        return "greetings";
    }

    @GetMapping("/bye")
    public String seeuagain(Model model){
        model.addAttribute("username", "Chris");
        return "goodbye";
    } 
}
