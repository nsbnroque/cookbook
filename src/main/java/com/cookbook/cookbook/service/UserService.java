package com.cookbook.cookbook.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cookbook.cookbook.domain.recipe.Recipe;
import com.cookbook.cookbook.domain.user.User;
import com.cookbook.cookbook.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    @Transactional
    public User save(User user){
        return repository.save(user);
    }

    public User find(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found!"));
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User update(Long id, User user){
        this.find(id);
        user.setId(id);
        return repository.save(user);
    }
    
    @Transactional
    public void delete(Long id){
        this.find(id);
        repository.deleteById(id);
    }

    public List<Recipe> getCookbook(Long id){
        return repository.getAllRecipesForUser(id);
    }


}
