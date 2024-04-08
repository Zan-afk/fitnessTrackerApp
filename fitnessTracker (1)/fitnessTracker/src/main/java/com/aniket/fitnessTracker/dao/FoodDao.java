package com.aniket.fitnessTracker.dao;

import com.aniket.fitnessTracker.model.Foodinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDao extends JpaRepository<Foodinfo, Integer> {

    Foodinfo findByfoodname(String foodname);

    List<Foodinfo> findByCaloriesBetween(float minCalories, float maxCalories);
    List<Foodinfo> findByproteinBetween(float minprotein,float maxprotein);

    List<Foodinfo> findByfiberBetween(float minfiber,float maxfiber);

    @Query(value = "SELECT f.calories FROM foodinfo f WHERE f.foodname = :foodName" , nativeQuery = true)
    float findCaloriesByfoodname(String foodName);
}
