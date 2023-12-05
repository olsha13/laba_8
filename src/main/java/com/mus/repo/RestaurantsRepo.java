package com.mus.repo;

import com.mus.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantsRepo extends JpaRepository<Restaurants, Long> {
    List<Restaurants> findAllByCategory(String category);
}
