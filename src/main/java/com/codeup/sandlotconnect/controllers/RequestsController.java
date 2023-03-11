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

@Controller
public class RequestsController {
    private final TeamRepository teamDao;
    private final UserRepository userDao;
    private final RequestsRepository requestDao;

    public RequestsController(TeamRepository teamDao, UserRepository userDao, RequestsRepository requestDao) {
        this.teamDao = teamDao;
        this.userDao = userDao;
        this.requestDao = requestDao;
    }

    @GetMapping("/requests")
    public String showRequests(Model model) {
        return "requests/index";
    }

    @PostMapping("/requests/create")
    public String createRequest() {
        return "redirect:/requests";
    }

    @PostMapping("/teams/{id}/admin/{requestId}")
    public String adminRequestControl(@PathVariable long id, @PathVariable long requestId, @RequestParam String status) {
        Team team = teamDao.findTeamById(id);
        User user = userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Request request = requestDao.findRequestById(requestId);
        if (!user.isCaptain() || request == null || !request.getTeam().equals(team)) {
            return "redirect:/teams";
        }

        if (status.equals("accept")) {
            request.setStatus("Accepted");
            request.getUser().setTeam(team);
            userDao.save(request.getUser());
        } else if (status.equals("decline")) {
            request.setStatus("Declined");
        }
        requestDao.save(request);
        return "redirect:/teams/" + id + "/admin";
    }

    @PostMapping("/teams/{id}/requests/{requestId}/cancel")
    public String cancelRequest(@PathVariable long id, @PathVariable long requestId) {
        Team team = teamDao.findTeamById(id);
        User user = userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Request request = requestDao.findRequestById(requestId);

        if (request == null || !request.getUser().equals(user) || !request.getTeam().equals(team)) {
            return "redirect:/teams";
        }
        request.setStatus("Declined");
        request.setCancelled(true);
        requestDao.save(request);
        return "redirect:/teams";
    }
}
