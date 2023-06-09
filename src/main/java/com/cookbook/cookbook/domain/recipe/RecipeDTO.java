package com.cookbook.cookbook.domain.recipe;

import java.util.List;

import com.cookbook.cookbook.domain.ingredient.Ingredient;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {

    @NotNull
    private String name;
    private String image;
    private Integer preparationTime; 
    private Integer cookTime;
    private Integer totalTime;
    private Integer servings;
    private DifficultyLevel difficultyLevel;
    private List<Ingredient> ingredients;
    private List<String> directions;
    private String authorName;

    public RecipeDTO(Recipe recipe){
        this.name = recipe.getName();
        this.image = recipe.getImage();
        this.preparationTime = recipe.getPreparationTime();
        this.cookTime = recipe.getCookTime();
        this.totalTime = this.preparationTime + this.cookTime;
        this.servings = recipe.getServings();
        this.difficultyLevel = recipe.getDifficultyLevel();
        this.ingredients = recipe.getIngredients();
        this.directions = recipe.getDirections();
        this.authorName = recipe.getAuthor().getName();
    }

}
