package com.demo.spring.springhelloword.controller;

import com.demo.spring.springhelloword.model.UserData;
import com.demo.spring.springhelloword.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@RequestParam("login") String login,
                               @RequestParam("password") String password) {
        UserData userData = new UserData();
        userData.setUsername(login);
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        userData.setPassword(encoder.encode(password));
        userRepository.save(userData);
        return "redirect:/";
    }
}
