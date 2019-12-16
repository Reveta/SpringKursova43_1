package com.demo.spring.springhelloword.controller;

import com.demo.spring.springhelloword.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {

        userRepository.findAll().forEach(System.out::println);
        return "index";
    }

    @RequestMapping(value = "/qwe", method = RequestMethod.GET)
    public String getQwe() {
        return "qwe";
    }
}
