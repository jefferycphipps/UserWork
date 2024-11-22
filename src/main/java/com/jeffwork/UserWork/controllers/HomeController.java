package com.jeffwork.UserWork.controllers;

import com.jeffwork.UserWork.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("title", "Fun");
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
}
