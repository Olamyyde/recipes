package com.example.recipes.service;

import com.example.recipes.model.Recipe;
import com.example.recipes.repo.RecipeRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Map;

@Service
public class RecipeService {
    private RecipeRepo recipeRepo;

    public RecipeService(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepo.findById(id).orElseThrow(() -> new
                ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Map addRecipe(Recipe recipe) {
        recipeRepo.save(recipe);

         // Return the id of the new recipe in the response
        return Collections.singletonMap("id", recipe.getId());
    }


}
