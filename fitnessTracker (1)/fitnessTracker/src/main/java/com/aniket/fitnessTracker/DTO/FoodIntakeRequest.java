package com.aniket.fitnessTracker.DTO;

import lombok.Data;

@Data
public class FoodIntakeRequest {
    private String foodName;
    private int quantityInGrams;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQuantityInGrams() {
        return quantityInGrams;
    }

    public void setQuantityInGrams(int quantityInGrams) {
        this.quantityInGrams = quantityInGrams;
    }

    @Override
    public String toString() {
        return "FoodIntakeRequest{" +
                "foodName='" + foodName + '\'' +
                ", quantityInGrams=" + quantityInGrams +
                '}';
    }
}