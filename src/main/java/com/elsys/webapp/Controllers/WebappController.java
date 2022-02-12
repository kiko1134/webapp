package com.elsys.webapp.Controllers;

import com.elsys.webapp.Models.User;
import com.elsys.webapp.Services.NoteService;
import com.elsys.webapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebappController {
    private final NoteService noteService;
    private final UserService userService;

    @Autowired
    public WebappController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping
    public String homepage(Model model){
        return "homepage";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @PostMapping("/register-user")
    public void registerUser(@RequestBody User user){
        userService.registerUser(user.getUsername(), user.getPassword());
    }

    @PostMapping("/login-user")
    public int loginUser(@RequestBody User user){
        return userService.loginUser(user.getUsername(),user.getPassword());
    }

    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }
}
