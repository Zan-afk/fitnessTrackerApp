package com.aniket.fitnessTracker.controller;

import com.aniket.fitnessTracker.DTO.FoodIntakeRequest;
import com.aniket.fitnessTracker.service.FoodIntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/foodIntake")
public class FoodIntakeController {

    @Autowired
    private FoodIntakeService foodIntakeService;

//    @PostMapping("/calculateCalories")
//    public ResponseEntity<Float> calculateCalories(@RequestBody FoodIntakeRequest request) {
//        try {
//            float totalCalories = foodIntakeService.calculateTotalCalories(request);
//            System.out.println(totalCalories);
//            return ResponseEntity.ok(totalCalories);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }

    @PostMapping("/calculateCalories")
    public ResponseEntity<Float> calculateCalories(@RequestBody List<FoodIntakeRequest> requests) {
        try {
            float totalCalories = 0;
            for (FoodIntakeRequest request : requests) {
                totalCalories += foodIntakeService.calculateTotalCalories(request);
            }
            System.out.println("Total Calories: " + totalCalories);
            return ResponseEntity.ok(totalCalories);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
