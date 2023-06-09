package com.cookbook.cookbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cookbook.cookbook.domain.recipe.Recipe;
import com.cookbook.cookbook.domain.recipe.RecipeDTO;
import com.cookbook.cookbook.repository.IngredientRepository;
import com.cookbook.cookbook.repository.RecipeRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RecipeService {

    private final RecipeRepository repository;
    private final IngredientRepository ingredientRepository;

    @Transactional
    public Recipe save(Recipe recipe){
        recipe.getIngredients().stream().forEach(ingredient -> ingredientRepository.save(ingredient));
        return repository.save(recipe);
    }

    public Recipe find(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Recipe not found!"));
    }

    public List<Recipe> findAll(){
        return repository.findAll();
    }

    public Recipe update(Long id, RecipeDTO dto){
        Recipe found = this.find(id);
        found.update(dto);
        return repository.save(found);
    }

    @Transactional
    public void delete(Long id){
        this.find(id);
        repository.deleteById(id);
    }
    
}
