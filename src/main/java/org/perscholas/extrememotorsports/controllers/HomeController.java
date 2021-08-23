package org.perscholas.extrememotorsports.controllers;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
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
    @GetMapping({"/", "index"})
    public String showIndex() {
        log.warn("Requesting homepage");
        return "index";
    }

    @PostMapping({"/process"})
    public String addUser(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult, Model model) {
        log.trace("Adding new user");
        model.addAttribute("newUser", user);
        return "index";
    }
}
