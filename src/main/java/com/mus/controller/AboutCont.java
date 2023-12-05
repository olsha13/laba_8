package com.mus.controller;

import com.mus.controller.main.Attributes;
import com.mus.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/about")
public class AboutCont extends Attributes {
    @GetMapping
    public String About(Model model) {
        AddAttributes(model);
        return "about";
    }
}
