package com.codeup.sandlotconnect.controllers;

import com.codeup.sandlotconnect.models.User;
import com.codeup.sandlotconnect.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class UserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

//    @Value("${FILESTACK_API_KEY}")
//    private String apiKey;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
//        model.addAttribute("usernameError", null);
//        model.addAttribute("passwordError", null);
//        model.addAttribute("confirmPasswordError", null);
//        model.addAttribute("apiKey", apiKey);
        return "users/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors() && !user.getPasswordForm().equals(user.getConfirmPassword())) {
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                String errorMessage = error.getDefaultMessage();
//                if (error.getField().equals("username")) {
//                    model.addAttribute("usernameError", errorMessage);
//                } else if (error.getField().equals("passwordForm")) {
//                    model.addAttribute("passwordError", errorMessage);
//                } else if (error.getField().equals("confirmPassword")) {
//                    model.addAttribute("confirmPasswordError", errorMessage);
//                }
//            }
//            model.addAttribute("confirmPasswordError", "Passwords do not match");
//            return "users/register";
//        } else if (bindingResult.hasErrors()) {
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                String errorMessage = error.getDefaultMessage();
//                if (error.getField().equals("username")) {
//                    model.addAttribute("usernameError", errorMessage);
//                } else if (error.getField().equals("passwordForm")) {
//                    model.addAttribute("passwordError", errorMessage);
//                } else if (error.getField().equals("confirmPassword")) {
//                    model.addAttribute("confirmPasswordError", errorMessage);
//                }
//            }
//            return "users/register";
//        } else if (!user.getPasswordForm().equals(user.getConfirmPassword())) {
//            model.addAttribute("confirmPasswordError", "Passwords do not match");
//            return "users/register";
//        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user = userDao.findById(user.getId());
        model.addAttribute("user", user);
        return "users/profile";
    }

    @GetMapping("/profile/edit")
    public String showEditProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user = userDao.findById(user.getId());
        model.addAttribute("user", user);
        return "users/edit-profile";
    }

    @PostMapping("/profile/edit")
    public String editProfile(@RequestParam String description, @RequestParam String firstName, @RequestParam String lastName) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user = userDao.findById(user.getId());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDescription(description);

        userDao.save(user);
        return "redirect:/profile";
    }


}
