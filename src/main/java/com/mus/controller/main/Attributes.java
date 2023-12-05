package com.mus.controller.main;

import com.mus.model.Category;
import com.mus.model.Restaurants;
import com.mus.model.Foods;
import com.mus.model.Users;
import com.mus.model.enums.Role;
import org.springframework.ui.Model;

import java.util.List;

public class Attributes extends Main {

    protected void AddAttributes(Model model) {
        model.addAttribute("role", getRole());
        model.addAttribute("user", getUser());
    }

    protected void AddAttributesUsers(Model model) {
        AddAttributes(model);
        model.addAttribute("users", usersRepo.findAll());
        model.addAttribute("roles", Role.values());
    }

    protected void AddAttributesFoodAdd(Model model) {
        AddAttributes(model);
        model.addAttribute("categories", categoryRepo.findAll());
    }

    protected void AddAttributesFoodEdit(Model model, Long id) {
        AddAttributes(model);
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("food", foodsRepo.getReferenceById(id));
    }

    protected void AddAttributesFoodsMy(Model model) {
        AddAttributes(model);
        Users user = getUser();
        if (user.getRole() == Role.MANAGER) {
            model.addAttribute("orderings", user.getRestaurant().getOrderings());
        } else {
            model.addAttribute("orderings", user.getOrderings());
        }
    }

    protected void AddAttributesFood(Model model, Long id) {
        AddAttributes(model);
        Foods food = foodsRepo.getReferenceById(id);
        List<Restaurants> restaurants = restaurantsRepo.findAllByCategory(food.getCategory().getName());
        model.addAttribute("food", food);
        model.addAttribute("restaurants", restaurants);
    }

    protected void AddAttributesIndex(Model model) {
        AddAttributes(model);
        model.addAttribute("foods", foodsRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());
    }

    protected void AddAttributesCategory(Model model) {
        AddAttributes(model);
        model.addAttribute("categories", categoryRepo.findAll());
    }

    protected void AddAttributesRestaurant(Model model) {
        AddAttributes(model);
        model.addAttribute("categories", categoryRepo.findAll());
    }

    protected void AddAttributesRestaurants(Model model) {
        AddAttributes(model);
        model.addAttribute("restaurants", restaurantsRepo.findAll());
    }

    protected void AddAttributesSearch(Model model, String name, Long categoryId) {
        AddAttributes(model);
        Category category = categoryRepo.getReferenceById(categoryId);
        model.addAttribute("foods", foodsRepo.findAllByNameContainingAndCategory_Name(name, category.getName()));
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("selectedCId", categoryId);
        model.addAttribute("name", name);
    }

    protected void AddAttributesStats(Model model) {
        AddAttributes(model);
        model.addAttribute("foods", foodsRepo.findAll());
    }
}
