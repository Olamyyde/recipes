package com.example.recipes.controller;

import com.example.recipes.model.Recipe;
import com.example.recipes.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipe")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping
    public void addRecipe(@RequestBody Recipe recipe){
        recipeService.setRecipe(recipe);
    }

    @GetMapping
    public Recipe getRecipe(){
        return recipeService.getRecipe();
    }


}
