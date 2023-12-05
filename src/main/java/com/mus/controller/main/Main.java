package com.mus.controller.main;

import com.mus.model.Users;
import com.mus.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Main {
    @Autowired
    protected UsersRepo usersRepo;
    @Autowired
    protected CategoryRepo categoryRepo;
    @Autowired
    protected RestaurantsRepo restaurantsRepo;
    @Autowired
    protected FoodsRepo foodsRepo;
    @Autowired
    protected OrderingRepo orderingRepo;
    @Value("${upload.img}")
    protected String uploadImg;
    protected String defPhoto = "def_photo.jpg";

    protected Users getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((!(auth instanceof AnonymousAuthenticationToken)) && auth != null) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            return usersRepo.findByUsername(userDetail.getUsername());
        }
        return null;
    }

    protected String getRole() {
        Users users = getUser();
        if (users == null) return "NOT";
        return users.getRole().toString();
    }
}