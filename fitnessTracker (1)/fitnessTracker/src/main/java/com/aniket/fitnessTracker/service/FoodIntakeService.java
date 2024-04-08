package com.aniket.fitnessTracker.service;

import com.aniket.fitnessTracker.DTO.FoodIntakeRequest;
import com.aniket.fitnessTracker.dao.FoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodIntakeService {

    @Autowired
    private FoodDao foodDao;

    public float calculateTotalCalories(FoodIntakeRequest request) {
        // Retrieve calories for the food name from the database
        float caloriesPer100g = foodDao.findCaloriesByfoodname(request.getFoodName());

        // Calculate total calories based on quantity
        float totalCalories = (caloriesPer100g / 100) * request.getQuantityInGrams();

        return totalCalories;
    }
}
