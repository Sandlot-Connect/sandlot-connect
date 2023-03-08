package com.codeup.sandlotconnect.controllers;

import com.codeup.sandlotconnect.models.Post;
import com.codeup.sandlotconnect.models.Team;
import com.codeup.sandlotconnect.models.User;
import com.codeup.sandlotconnect.repositories.PostsRepository;
import com.codeup.sandlotconnect.repositories.TeamRepository;
import com.codeup.sandlotconnect.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {
    private final TeamRepository teamDao;
    private final UserRepository userDao;
    private final PostsRepository postDao;

    public PostsController(TeamRepository teamDao, UserRepository userDao, PostsRepository postDao) {
        this.teamDao = teamDao;
        this.userDao = userDao;
        this.postDao = postDao;
    }
    @GetMapping("/teams/{id}/posts")
    public String showTeamPosts(@PathVariable long id, Model model) {
        Team team = teamDao.findTeamById(id);
        List<User> users = userDao.findAllByTeam(team);
        List<Post> posts = postDao.findAll();
        List<Post> filteredPosts = new ArrayList<>();
        for (Post post : posts) {
            for (User user : users) {
                if (post.getUser().getId() == user.getId()) {
                    filteredPosts.add(post);
                    break;
                }
            }
        }
        model.addAttribute("user", users);
        model.addAttribute("team", team);
        model.addAttribute("posts", filteredPosts);
        return "posts/team-posts";
    }
}
