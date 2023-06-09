package com.cookbook.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cookbook.cookbook.domain.ingredient.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long>{
    
}
