package com.codeup.sandlotconnect.controllers;

import com.codeup.sandlotconnect.models.Request;
import com.codeup.sandlotconnect.models.Team;
import com.codeup.sandlotconnect.models.User;
import com.codeup.sandlotconnect.repositories.RequestsRepository;
import com.codeup.sandlotconnect.repositories.TeamRepository;
import com.codeup.sandlotconnect.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final UserRepository userDao;
    private final RequestsRepository requestDao;

    public TeamController(TeamRepository teamDao, UserRepository userDao, RequestsRepository requestDao) {
        this.teamDao = teamDao;
        this.userDao = userDao;
        this.requestDao = requestDao;
    }

    @GetMapping("/teams")
    public String showTeams(Model model) {
        User currentUser = userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Team> teams = teamDao.findAll();
        model.addAttribute("user", currentUser);
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
    public String createTeamForm(Model model) {
        List<Team> teams = teamDao.findAll();
        return "teams/create";
    }

    @GetMapping("/teams/{id}/admin")
    public String showAdminRequests(@PathVariable long id, Model model) {
        Team team = teamDao.findTeamById(id);
        model.addAttribute("team", team);
        return "teams/admin";
    }

    @PostMapping("/teams/{id}/admin")
    public String adminNotification(@PathVariable long id, long requestId, long userId) {
        Request request = requestDao.getById(requestId);
        Team team = teamDao.findTeamById(id);
        User user = userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (!user.isCaptain()) {
            return "redirect:/teams";
        } else
            return "redirect:/teams/admin";
    }


    @PostMapping("/teams/{id}/notifications")
    public String joinNotification(@PathVariable long id, Model model) {
        Team team = teamDao.findTeamById(id);
        User user = userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (team == null) {
            return "redirect:/teams";
        }
        Request req = new Request();
        req.setStatus("Pending");
        req.setTeam(team);
        req.setUser(user);
        requestDao.save(req);
        return "redirect:/teams";
    }


    @PostMapping("/teams/create")
    public String createTeam(@RequestParam String name, @RequestParam String description, @RequestParam String city, @RequestParam String state) {
        Team team = new Team(name, description, city, state);
        User user = userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        team.setCaptain(user);
        user.setTeam(team);
        user.setCaptain(true);
        teamDao.save(team);
        return "redirect:/teams";
    }

    @PostMapping("/teams/{id}/leave")
    public String removePlayer(@PathVariable long id) {
        User user = userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Team team = teamDao.findTeamById(id);
        if (user.isCaptain()) {
            user.setCaptain(false);
        }
        user.setTeam(null);
        userDao.save(user);
        return "redirect:/teams";
    }

    @PostMapping("/teams/{id}/posts/{userId}/drop")
    public String dropPlayer(@PathVariable long id, @PathVariable long userId) {
        User currentUser = userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        User user = userDao.findById(userId);
        Team team = teamDao.findTeamById(id);
//        Request request = requestDao.findRequestByUser(user);
        User captain = team.getCaptain();
        if (!currentUser.equals(captain)) {
            return "redirect:/teams/" + id + "/posts";
        }

        if (currentUser.equals(user)) {
            return "redirect:/teams/" + id + "/posts";
        }
        user.setTeam(null);
//        requestDao.delete(request);
        userDao.save(user);
        return "redirect:/teams/" + id + "/posts";
    }
}