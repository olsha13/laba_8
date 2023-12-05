package com.mus.controller;

import com.mus.controller.main.Attributes;
import com.mus.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryCont extends Attributes {
    @GetMapping
    public String Category(Model model) {
        AddAttributesCategory(model);
        return "category";
    }

    @PostMapping("/add")
    public String categoryAdd(@RequestParam String name) {
        categoryRepo.save(new Category(name));
        return "redirect:/category";
    }

    @PostMapping("/edit/{id}")
    public String categoryEdit(@RequestParam String name, @PathVariable Long id) {
        Category category = categoryRepo.getReferenceById(id);
        category.setName(name);
        categoryRepo.save(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String CategoryDelete(@PathVariable Long id) {
        categoryRepo.deleteById(id);
        return "redirect:/category";
    }
}
