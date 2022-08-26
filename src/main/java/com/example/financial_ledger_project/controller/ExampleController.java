package com.example.financial_ledger_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

    @GetMapping("/ex")
    public String niceToMeetYou() {

        return "/page/calender";
    }
}
