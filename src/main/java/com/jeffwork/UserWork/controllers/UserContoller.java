package com.jeffwork.UserWork.controllers;


import com.jeffwork.UserWork.models.Image;
import com.jeffwork.UserWork.models.User;
import com.jeffwork.UserWork.models.data.ImageRepository;
import com.jeffwork.UserWork.models.data.UserRepository;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
@RequestMapping("users")
public class UserContoller {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("title", "All Users");
        model.addAttribute("users", userRepository.findAll());

        return "users/index";
    }

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title","Add User");
        return "users/add";
    }

    @PostMapping(value = "add")
    public String processAddUserForm(@ModelAttribute @Valid User newUser,@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
            return "users/add";
        }




        Image tempImage = new Image();
        tempImage = saveImage(tempImage, fileName, file);
        //imageRepository.save(tempImage);
        newUser.setUserImage(tempImage);
        userRepository.save(newUser);

        return "redirect:";
    }

    @GetMapping("view/{userId}")
    public String displayViewUser(Model model, @PathVariable int userId) {

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = (User) optionalUser.get();
            model.addAttribute("user", user);
            return "users/view";
        } else {
            return "redirect:../";
        }

    }


    public Image saveImage(Image imageEntity, String name, MultipartFile file) {
        try {
            imageEntity.setName(name);
            imageEntity.setImageData(file.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageEntity;
    }

}
