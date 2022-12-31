package com.example.recipes.controller;

import com.example.recipes.model.Recipe;
import com.example.recipes.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/new")
    public ResponseEntity<Map<String, Long>> addRecipe(@RequestBody @Valid Recipe recipe){
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

    @PutMapping("/{id}")
    public ResponseEntity updateRecipe(@PathVariable Long id, @RequestBody @Valid Recipe recipe){
        return recipeService.updateRecipe(id, recipe);
    }

    @GetMapping("/search")
    public List<Recipe> searchRecipes(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String category){
        return recipeService.searchRecipes(name, category);
    }

}
