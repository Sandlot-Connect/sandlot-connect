package com.codeup.sandlotconnect.controllers;

import com.codeup.sandlotconnect.models.Team;
import com.codeup.sandlotconnect.models.User;
import com.codeup.sandlotconnect.repositories.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class TeamController {
    private final TeamRepository teamDao;

    public TeamController(TeamRepository teamDao) {
        this.teamDao = teamDao;
    }

    @GetMapping("/teams")
    public String showTeams(Model model) {
        List<Team> teams = teamDao.findAll();
        model.addAttribute("teams", teams);
        return "teams/index";
    }

    @GetMapping("/teams/{id}")
    public String showTeam(@PathVariable long id, Model model) {
        Team team = teamDao.findTeamById(id);
        model.addAttribute("team", team);
        return "teams/show";
    }

    @GetMapping("/teams/create")
    public String createTeamForm() {
        return "teams/create";
    }

    @PostMapping("/teams/create")
    public String createTeam(@RequestParam String name, @RequestParam String description, @RequestParam String city, @RequestParam String state, String logoUrl) {
        Team team = new Team(name, description, city, state, logoUrl);
        teamDao.save(team);
        return "redirect:/teams";
    }
}