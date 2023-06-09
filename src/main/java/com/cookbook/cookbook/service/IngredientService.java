package com.cookbook.cookbook.service;

import java.util.List;

import org.hibernate.query.sqm.function.FunctionKind;
import org.springframework.stereotype.Service;

import com.cookbook.cookbook.domain.ingredient.Ingredient;
import com.cookbook.cookbook.repository.IngredientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class IngredientService {

    private final IngredientRepository repository;

    @Transactional
    public Ingredient save(Ingredient ingredient){
        return repository.save(ingredient);
    }

    public Ingredient find(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ingredient not found!") );
    }

    public List<Ingredient> findAll(){
        return repository.findAll();
    }

    public Ingredient update(Long id, Ingredient ingredient){
        Ingredient found = this.find(id);
        found.setName(ingredient.getName());
        found.setQuantity(ingredient.getQuantity());
        return repository.save(found);
    }

    @Transactional
    public void delete(Long id){
        this.find(id);
        repository.deleteById(id);
    }
    
}
