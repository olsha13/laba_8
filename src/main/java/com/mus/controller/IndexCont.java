package com.mus.controller;

import com.mus.controller.main.Attributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexCont extends Attributes {

    @GetMapping
    public String index1(Model model) {
        AddAttributesIndex(model);
        return "foods";
    }

    @GetMapping("/index")
    public String index2(Model model) {
        AddAttributesIndex(model);
        return "foods";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam String name, @RequestParam Long categoryId) {
        AddAttributesSearch(model, name, categoryId);
        return "foods";
    }
}
