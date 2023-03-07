package com.codeup.sandlotconnect.controllers;

import com.codeup.sandlotconnect.models.Team;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class TeamController {

    @GetMapping("/teams")
    public String showTeams(Model model) {
        ArrayList<Team> teams = new ArrayList<>();
        teams.add(new Team(1, "red-dawgs", "Camden Red Dawgs Baseball", "Camden", "NJ"));
        model.addAttribute("teams", teams);
        return "teams/index";
    }

    @GetMapping("/teams/{id}")
    public String showTeam() {
        return "teams/show";
    }

//    @GetMapping("/teams/create")
//    public String showCreateTeamForm() {
//        return "teams/create";
//    }
}
