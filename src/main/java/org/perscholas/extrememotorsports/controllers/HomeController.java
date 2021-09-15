package org.perscholas.extrememotorsports.controllers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class HomeController {

    //Opens up homepage
    @GetMapping({"/", "/index"})
    public String showIndex() {
        log.warn("Requesting homepage");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        log.warn("login method");
        return "login";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
}
