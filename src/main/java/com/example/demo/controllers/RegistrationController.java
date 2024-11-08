package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.exceptions.AlreadyExistException;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("error","");
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            userService.createUser(user.getUsername(), user.getEmail(), user.getPassword());
        }
        catch (AlreadyExistException e) {
            model.addAttribute("error",e.getMessage());
            return "registration";
        }
        return "redirect:/login";
    }
}