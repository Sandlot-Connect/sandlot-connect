package com.codeup.sandlotconnect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {

    @GetMapping("/teams")
    public String showTeams() {
        return "teams/index";
    }

//    @GetMapping("/teams/create")
//    public String showCreateTeamForm() {
//        return "teams/create";
//    }
}
