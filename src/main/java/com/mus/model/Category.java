package com.mus.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Foods> foods;

    public Category(String name) {
        this.name = name;
        foods = new ArrayList<>();
    }

    public void addFood(Foods food) {
        foods.add(food);
        food.setCategory(this);
    }

    public void removeFood(Foods food) {
        foods.remove(food);
        food.setCategory(null);
    }
}
