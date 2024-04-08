package com.aniket.fitnessTracker.service;

import com.aniket.fitnessTracker.DTO.FoodIntakeRequest;
import com.aniket.fitnessTracker.dao.FoodDao;
import com.aniket.fitnessTracker.model.Foodinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    FoodDao foodDao;


    public List<Foodinfo> getallfoodsinfo() {

        return foodDao.findAll();
    }

    public  String getfoodByname(String foodname) {

        Foodinfo food =  foodDao.findByfoodname(foodname);

        return food.toString();
    }

    public ResponseEntity<List<Foodinfo>> getFoodsByCalorieRange(float minCalories, float maxCalories) {

        List<Foodinfo> foods = foodDao.findByCaloriesBetween(minCalories, maxCalories);
        return ResponseEntity.ok(foods);
    }

    public ResponseEntity<List<Foodinfo>> getFoodsByproteinRange(float minprotein, float maxprotein) {
        List<Foodinfo> foods = foodDao.findByproteinBetween(minprotein, maxprotein);
        return ResponseEntity.ok(foods);
    }

    public ResponseEntity<List<Foodinfo>> getFoodsByfiberRange(float minfiber, float maxfiber) {
        List<Foodinfo> foods = foodDao.findByfiberBetween(minfiber, maxfiber);
        return ResponseEntity.ok(foods);
    }


}
