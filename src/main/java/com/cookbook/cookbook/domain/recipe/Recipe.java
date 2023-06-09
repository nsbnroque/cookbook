package com.cookbook.cookbook.domain.recipe;
import java.util.List;

import com.cookbook.cookbook.domain.ingredient.Ingredient;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tb_recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String name;
    private String image;
    private Integer preparationTime; 
    private Integer cookTime;
    private Integer totalTime;
    private Integer servings;
    private DifficultyLevel difficultyLevel;
    @OneToMany
    private List<Ingredient> ingredients;
    
    public Recipe(RecipeDTO dto){
        this.name = dto.getName();
        this.image = dto.getImage();
        this.cookTime = dto.getCookTime();
        this.preparationTime = dto.getPreparationTime();
        this.totalTime = dto.getTotalTime();
        this.servings = dto.getServings();
        this.difficultyLevel = dto.getDifficultyLevel();
        this.ingredients = dto.getIngredients();

    }

    public void update(RecipeDTO dto){
        if (dto.getName() != null){
            this.name = dto.getName();
        }
        if (dto.getCookTime() != null){
            this.cookTime = dto.getCookTime();
        }
        if (dto.getPreparationTime() != null){
            this.preparationTime = dto.getPreparationTime();
        }
        if(dto.getImage() != null){
            this.image = dto.getImage();
        }
        if(dto.getDifficultyLevel() != null){
            this.difficultyLevel = dto.getDifficultyLevel();
        }
        if(dto.getServings() != null){
            this.servings = dto.getServings();
        }
        if(dto.getIngredients() != null){
            this.ingredients = dto.getIngredients();
        }
    }
}