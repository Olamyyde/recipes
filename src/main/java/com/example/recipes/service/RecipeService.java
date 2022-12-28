package com.example.recipes.service;

import com.example.recipes.model.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
