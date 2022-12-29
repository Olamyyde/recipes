package com.example.recipes.controller;

import com.example.recipes.model.Recipe;
import com.example.recipes.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/new")
    public ResponseEntity<Map<String, Long>> addRecipe(@RequestBody Recipe recipe){
        Map<String, Long> response = recipeService.addRecipe(recipe);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id){
        Recipe recipeById = recipeService.getRecipeById(id);

        return new ResponseEntity<>(recipeById, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRecipe(@PathVariable Long id){
        return recipeService.deleteRecipe(id);
    }

}
