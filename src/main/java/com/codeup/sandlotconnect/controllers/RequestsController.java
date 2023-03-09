package com.codeup.sandlotconnect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RequestsController {

        @GetMapping("/requests")
        public String showRequests(Model model) {
            return "requests/index";
        }

        @PostMapping("/requests/create")
        public String createRequest() {
            return "redirect:/requests";
        }
}
