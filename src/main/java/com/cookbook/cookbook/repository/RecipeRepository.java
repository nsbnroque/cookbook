package com.cookbook.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cookbook.cookbook.domain.recipe.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{
    
}
