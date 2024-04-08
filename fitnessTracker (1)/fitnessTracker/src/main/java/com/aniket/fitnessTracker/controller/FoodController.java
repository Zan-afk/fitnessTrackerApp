package com.aniket.fitnessTracker.controller;

import com.aniket.fitnessTracker.model.Foodinfo;
import com.aniket.fitnessTracker.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("foodInfo")
public class FoodController {

    @Autowired
    FoodService foodService;


    @GetMapping("allfoods")
    public List<Foodinfo> allFoodInfo(){

        return foodService.getallfoodsinfo();
    }

    @GetMapping("{foodname}")
    public String getFoodByname(@PathVariable String foodname){ //pathvariable assign getmapping category to this category

        return foodService.getfoodByname(foodname);
    }


    @GetMapping("bycalories/{min}/{max}")
    public ResponseEntity<List<Foodinfo>> getFoodsByCalorieRange(@PathVariable float min, @PathVariable float max) {
        return foodService.getFoodsByCalorieRange(min, max);
    }

    @GetMapping("byprotein/{min}/{max}")
    public ResponseEntity<List<Foodinfo>> getFoodsByproteinRange(@PathVariable float min, @PathVariable float max) {
        return foodService.getFoodsByproteinRange(min, max);
    }

    @GetMapping("byfiber/{min}/{max}")
    public ResponseEntity<List<Foodinfo>> getFoodsByfiberRange(@PathVariable float min, @PathVariable float max) {
        return foodService.getFoodsByfiberRange(min, max);
    }

}
