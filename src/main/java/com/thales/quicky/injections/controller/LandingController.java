package com.thales.quicky.injections.controller;

import com.thales.quicky.injections.model.MonObjet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LandingController {

    @GetMapping
    public String home(){
        return "home";
    }

    @PostMapping
    public String createMonObjet(@ModelAttribute @Valid MonObjet monObjet){
        /** do some cool stuff here **/

        return "home";
    }

}
