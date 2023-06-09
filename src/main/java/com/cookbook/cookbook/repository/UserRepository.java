package com.cookbook.cookbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cookbook.cookbook.domain.recipe.Recipe;
import com.cookbook.cookbook.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT r FROM User u JOIN u.cookBook r WHERE u.id = :userId")
    public List<Recipe> getAllRecipesForUser(Long userId);
}
