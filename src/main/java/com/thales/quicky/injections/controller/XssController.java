package com.thales.quicky.injections.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/xss")
public class XssController {

    private List<String> comments = new ArrayList<>();

    @GetMapping("/reflected")
    public String reflected(Model model, @RequestParam(required = false) String input){
        model.addAttribute("output", input);
        return "xss-reflected";
    }

    @GetMapping("/stored")
    public String stored(Model model){
        model.addAttribute("comments", comments);
        return "xss-stored";
    }

    @PostMapping("/stored")
    public String storedPost(@RequestParam String input){
        comments.add(input);
        return "redirect:/xss/stored";
    }

    @GetMapping("/dom")
    public String domBased(Model model, @RequestParam(required = false) String input){
        model.addAttribute("output", input);
        return "xss-dom-based";
    }

}
